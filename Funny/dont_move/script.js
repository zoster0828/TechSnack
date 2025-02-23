const video = document.getElementById('video');
const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const statusEl = document.getElementById('status');
const startBtn = document.getElementById('startBtn');

// === 전역 상태 ===
let detector = null;         // MoveNet MultiPose Detector
let detectionActive = false; // 실시간 감지 on/off
let modelLoaded = false;     // 모델 로딩 완료 여부

// 이전 프레임 Pose
let prevPoses = [];
// 움직임 감지 플래그
let movementDetected = false;

// 게임 진행
let gameActive = false;
let currentRound = 0;
const MAX_ROUNDS = 10;

// "빨간불" 상태를 구분(빨간불일 때 움직임이 감지되면 즉시 탈락)
let isRedLight = false;

// ------------------------------------
// (1) 카메라 셋업
// ------------------------------------
async function setupCamera() {
  try {
    const stream = await navigator.mediaDevices.getUserMedia({
      video: { width: 640, height: 480 },
      audio: false
    });
    video.srcObject = stream;
    return new Promise((resolve) => {
      video.onloadedmetadata = () => {
        resolve();
      };
    });
  } catch (e) {
    alert('카메라 접근 불가: ' + e.message);
    throw e;
  }
}

// ------------------------------------
// (2) TTS: 말하기/취소
// ------------------------------------
function speak(text) {
  speechSynthesis.cancel();
  const utter = new SpeechSynthesisUtterance(text);
  utter.lang = 'ko-KR';
  speechSynthesis.speak(utter);
}

function stopAllTTS() {
  speechSynthesis.cancel();
}

// ------------------------------------
// (3) Detector 초기화 (MoveNet MultiPose Thunder)
// ------------------------------------
async function initDetector() {
  const model = poseDetection.SupportedModels.MoveNet;
  const detectorConfig = {
    modelType: poseDetection.movenet.modelType.MULTIPOSE_THUNDER,
  };
  detector = await poseDetection.createDetector(model, detectorConfig);
}

// ------------------------------------
// (4) 메인 추론 루프 (requestAnimationFrame)
//     - 빨간불 기간에 움직임 감지되면 즉시 탈락
// ------------------------------------
async function detectionLoop() {
  if (!detectionActive) return;

  // 1) 비디오를 캔버스에 그리기
  ctx.drawImage(video, 0, 0, canvas.width, canvas.height);

  // 2) 카메라 가림 체크 (화면이 어두워지면 승리)
  if (checkCover() && gameActive) {
    endGame(true); // 승리
    return;
  }

  // 3) Pose 추론
  let poses = [];
  try {
    poses = await detector.estimatePoses(video, {
      maxPoses: 6,
      flipHorizontal: false
    });
  } catch (err) {
    console.warn('estimatePoses 에러:', err);
    requestAnimationFrame(detectionLoop);
    return;
  }

  // bounding box 계산
  const persons = poses.map((pose) => {
    const validKps = pose.keypoints.filter(kp => kp.score > 0.2);
    let minX = Infinity, maxX = -Infinity;
    let minY = Infinity, maxY = -Infinity;
    validKps.forEach(kp => {
      if (kp.x < minX) minX = kp.x;
      if (kp.x > maxX) maxX = kp.x;
      if (kp.y < minY) minY = kp.y;
      if (kp.y > maxY) maxY = kp.y;
    });
    return {
      keypoints: pose.keypoints,
      box: {
        x: minX, y: minY,
        width: maxX - minX,
        height: maxY - minY
      }
    };
  });

  // 4) 움직임 감지
  movementDetected = detectMovementMulti(persons, prevPoses);

  // "빨간불" 상태이며, 게임이 진행 중이고, 움직임 감지되면 => 즉시 탈락
  if (isRedLight && gameActive && movementDetected) {
    endGame(false);
    return;
  }

  // 5) 시각화(옵션)
  drawPersons(persons);

  // 6) 갱신
  prevPoses = persons;

  // 7) 다음 프레임 요청
  requestAnimationFrame(detectionLoop);
}

// ------------------------------------
// (5) 카메라 가림 여부 판정(평균 밝기)
// ------------------------------------
function checkCover() {
  const frame = ctx.getImageData(0, 0, canvas.width, canvas.height);
  let total = 0;
  let step = 50;
  for (let i = 0; i < frame.data.length; i += 4 * step) {
    const r = frame.data[i];
    const g = frame.data[i + 1];
    const b = frame.data[i + 2];
    total += (r + g + b) / 3;
  }
  const count = frame.data.length / (4 * step);
  const avg = total / count;
  return avg < 10; // 어두우면 가림으로 판단
}

// ------------------------------------
// (6) 여러 사람 움직임 감지
//     - MOVE_THRESHOLD를 낮추면 더 민감하게 감지
// ------------------------------------
function detectMovementMulti(currentPersons, prevPersons) {
  if (!prevPersons || prevPersons.length === 0) {
    return false;
  }
  const MOVE_THRESHOLD = 10; // 더 민감하게
  for (let cur of currentPersons) {
    const match = findClosestPerson(cur, prevPersons);
    if (!match) continue;
    const dist = computeAvgKeypointDistance(cur.keypoints, match.keypoints);
    if (dist > MOVE_THRESHOLD) {
      return true;
    }
  }
  return false;
}

function findClosestPerson(person, prevPersons) {
  let best = null;
  let minDist = Infinity;
  const c1 = getCenter(person.box);
  for (let p of prevPersons) {
    const c2 = getCenter(p.box);
    const dx = c1.x - c2.x;
    const dy = c1.y - c2.y;
    const dist = dx * dx + dy * dy;
    if (dist < minDist) {
      minDist = dist;
      best = p;
    }
  }
  return best;
}

function computeAvgKeypointDistance(kpsA, kpsB) {
  let sumDist = 0;
  let count = 0;
  for (let i = 0; i < kpsA.length; i++) {
    const a = kpsA[i];
    const b = kpsB[i];
    if (a.score > 0.3 && b.score > 0.3) {
      const dx = a.x - b.x;
      const dy = a.y - b.y;
      const dist = Math.sqrt(dx * dx + dy * dy);
      sumDist += dist;
      count++;
    }
  }
  if (count === 0) return 0;
  return sumDist / count;
}

function getCenter(box) {
  return {
    x: box.x + box.width / 2,
    y: box.y + box.height / 2
  };
}

// ------------------------------------
// (7) 시각화(옵션)
// ------------------------------------
function drawPersons(persons) {
  ctx.strokeStyle = 'lime';
  ctx.lineWidth = 2;
  ctx.fillStyle = 'cyan';

  persons.forEach((p) => {
    const { x, y, width, height } = p.box;
    if (width > 0 && height > 0) {
      ctx.strokeRect(x, y, width, height);
    }
    p.keypoints.forEach(kp => {
      if (kp.score > 0.3) {
        ctx.beginPath();
        ctx.arc(kp.x, kp.y, 3, 0, 2 * Math.PI);
        ctx.fill();
      }
    });
  });
}

// ------------------------------------
// (8) 게임 로직
//     - "무궁화 꽃이 피었습니다" (초록불)에 움직임 자유
//     - 이후 3초 (빨간불) 동안 움직이면 탈락
// ------------------------------------
async function startGameFlow() {
  if (!modelLoaded) {
    alert("아직 모델이 로딩되지 않았습니다!");
    return;
  }
  if (gameActive) return; // 이미 진행중

  gameActive = true;
  currentRound = 0;
  speak("게임 시작");
  statusEl.textContent = "게임 시작!";

  for (let i = 1; i <= MAX_ROUNDS; i++) {
    if (!gameActive) break;
    currentRound = i;

    // --- (A) 초록불: "무궁화 꽃이 피었습니다." (움직임 자유) ---
    statusEl.textContent = `Round ${i} - 초록불 (움직여도 됨)`;
    speak("무궁화 꽃이 피었습니다.");
    isRedLight = false;
    // 여기선 2초 정도 대기
    await wait(2000);
    if (!gameActive) break;

    // --- (B) 빨간불: 3초 ---
    statusEl.textContent = `Round ${i} - 빨간불 3초 (움직이면 탈락)`;
    speak("빨간불입니다. 움직이지 마세요.");
    isRedLight = true;

    // 3초 대기 중에 detectionLoop 에서 movementDetected=true => endGame(false) 처리
    await wait(3000);
    if (!gameActive) break;

    statusEl.textContent = `Round ${i} 완료`;
    // 빨간불 해제
    isRedLight = false;
  }

  // 10라운드가 끝났는데 승리 못했다면 => 패배
  if (gameActive) {
    endGame(false);
  }
}

// (9) 게임 종료
function endGame(isWin) {
  if (!gameActive) return;
  gameActive = false;
  stopAllTTS();

  if (isWin) {
    speak("플레이어 승리");
    statusEl.textContent = "플레이어 승리! (카메라 가려짐)";
  } else {
    speak("플레이어 패배");
    statusEl.textContent = "플레이어 패배! (빨간불에 움직임 발견 or 10라운드 완료)";
  }

  // 빨간불 플래그 해제
  isRedLight = false;
}

// 유틸
function wait(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

// ------------------------------------
// (10) 초기화 흐름: 페이지 로드 시
// ------------------------------------
startBtn.addEventListener('click', async () => {
  if (!modelLoaded) {
    alert("모델이 아직 로딩되지 않았습니다!");
    return;
  }
  startGameFlow();
});

(async function initAll() {
  statusEl.textContent = "카메라 준비 중...";
  await setupCamera();
  video.play();

  statusEl.textContent = "MoveNet MultiPose Thunder 모델 로딩 중...";
  await initDetector();

  modelLoaded = true;
  statusEl.textContent = "모델 로딩 완료! [게임 시작] 버튼을 누르세요.";
  startBtn.disabled = false;

  detectionActive = true;
  requestAnimationFrame(detectionLoop);
})();
