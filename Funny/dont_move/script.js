const video = document.getElementById('video');
const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const statusEl = document.getElementById('status');
const startBtn = document.getElementById('startBtn');

// === 전역 상태 ===
let detector = null;         // MoveNet MultiPose Detector
let detectionActive = false; // 매 프레임 감지 on/off
let modelLoaded = false;     // 모델 로딩 완료 여부

let prevPoses = [];          // 이전 프레임의 사람들(멀티 포즈)
let movementDetected = false;
let coverDetected = false;

// 라운드 진행 변수
let currentRound = 0;
const MAX_ROUNDS = 10;
let gameActive = false;

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
// (4) 메인 추론 루프
// ------------------------------------
async function detectionLoop() {
  if (!detectionActive) return;

  // (1) 비디오 -> 캔버스
  ctx.drawImage(video, 0, 0, canvas.width, canvas.height);

  // (2) 카메라 가림 체크
  if (checkCover() && gameActive) {
    endGame(true); // 승리
    return;
  }

  // (3) Pose 추론
  let poses = [];
  try {
    // 정확도를 좀 더 높이고 싶다면 maxPoses 늘리거나, scoreThreshold 조정 가능
    poses = await detector.estimatePoses(video, {
      maxPoses: 6,
      flipHorizontal: false
    });
  } catch (err) {
    console.warn('estimatePoses 에러:', err);
    requestAnimationFrame(detectionLoop);
    return;
  }

  // MultiPoseThunder가 정확도↑지만 속도↓.
  // 필요 시 confidence score / filtering 로직 추가 가능.

  // (4) bounding box 계산
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
        x: minX,
        y: minY,
        width: maxX - minX,
        height: maxY - minY
      }
    };
  });

  // (5) 움직임 감지
  movementDetected = detectMovementMulti(persons, prevPoses);

  // (시연용) 사람 드로잉
  drawPersons(persons);

  // (6) 갱신
  prevPoses = persons;

  // (7) 다음 루프
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
  // 임계값 조정 가능. 10보다 작으면 매우 어둡다고 가정
  return avg < 10;
}

// ------------------------------------
// (6) 여러 사람 움직임 감지
//    - 정확도↑를 위해 threshold 낮추거나, keypoints score↑ 조건 추가 가능
// ------------------------------------
function detectMovementMulti(currentPersons, prevPersons) {
  if (!prevPersons || prevPersons.length === 0) {
    return false;
  }

  // threshold를 줄이면 더 민감해짐
  const MOVE_THRESHOLD = 10; // 기존 20 → 10 (더 민감하게)
  let someoneMoved = false;

  currentPersons.forEach(cur => {
    const match = findClosestPerson(cur, prevPersons);
    if (!match) return;
    const dist = computeAvgKeypointDistance(cur.keypoints, match.keypoints);
    if (dist > MOVE_THRESHOLD) {
      someoneMoved = true;
    }
  });

  return someoneMoved;
}

function findClosestPerson(person, prevPersons) {
  let best = null;
  let minDist = Infinity;
  const c1 = getCenter(person.box);
  for (let p of prevPersons) {
    const c2 = getCenter(p.box);
    const dx = c1.x - c2.x;
    const dy = c1.y - c2.y;
    const dist = dx*dx + dy*dy;
    if (dist < minDist) {
      minDist = dist;
      best = p;
    }
  }
  return best;
}

function getCenter(box) {
  return { x: box.x + box.width / 2, y: box.y + box.height / 2 };
}

function computeAvgKeypointDistance(kpsA, kpsB) {
  let sumDist = 0;
  let count = 0;
  for (let i = 0; i < kpsA.length; i++) {
    const a = kpsA[i], b = kpsB[i];
    if (a.score > 0.3 && b.score > 0.3) { // score threshold를 더 높여 잡아도 됨
      const dx = a.x - b.x;
      const dy = a.y - b.y;
      const dist = Math.sqrt(dx*dx + dy*dy);
      sumDist += dist;
      count++;
    }
  }
  if (count === 0) return 0;
  return sumDist / count;
}

// ------------------------------------
// (7) 시각화(옵션): 사람 bbox & keypoints
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
        ctx.arc(kp.x, kp.y, 3, 0, 2*Math.PI);
        ctx.fill();
      }
    });
  });
}

// ------------------------------------
// (8) 게임 로직
// ------------------------------------
async function startGameFlow() {
  // 모델이 로딩 안됐으면 무시
  if (!modelLoaded) {
    alert("아직 모델이 로딩되지 않았습니다. 잠시 후 다시 시도해주세요!");
    return;
  }
  if (gameActive) return; // 이미 진행중이면 무시

  gameActive = true;
  currentRound = 0;
  speak("게임 시작");
  statusEl.textContent = "게임 시작!";

  // 10번 라운드
  for (let i = 1; i <= MAX_ROUNDS; i++) {
    if (!gameActive) break;
    currentRound = i;

    // (A) 무궁화 꽃이 피었습니다.
    statusEl.textContent = `Round ${i} - 무궁화 꽃이 피었습니다! (자유 이동)`;
    speak("무궁화 꽃이 피었습니다.");
    // 말이 너무 길지 않다면 약간 대기
    await wait(1500);
    if (!gameActive) break;

    // (B) 3초간 움직임 체크
    statusEl.textContent = `Round ${i} - 3초간 움직임이 없는지 체크...`;
    await checkNoMovementFor(3000);
    if (!gameActive) break;

    statusEl.textContent = `Round ${i} 완료!`;
  }

  // 라운드가 다 끝났는데 승리(커버) 못했으면 패배
  if (gameActive) {
    endGame(false);
  }
}

// 3초간 움직임 없는지 체크.
// 여기서는 움직임이 있어도 추가 처벌은 없지만, 필요하면 여기서 처리 가능.
async function checkNoMovementFor(ms) {
  const startTime = performance.now();
  return new Promise((resolve) => {
    const timer = setInterval(() => {
      if (!gameActive) {
        clearInterval(timer);
        resolve();
        return;
      }
      const now = performance.now();
      const elapsed = now - startTime;
      if (elapsed >= ms) {
        clearInterval(timer);
        resolve();
      }
    }, 100);
  });
}

// 게임 종료
function endGame(isWin) {
  if (!gameActive) return;
  gameActive = false;

  stopAllTTS();
  if (isWin) {
    speak("플레이어 승리");
    statusEl.textContent = "플레이어 승리! (카메라가 가려졌습니다.)";
  } else {
    speak("플레이어 패배");
    statusEl.textContent = "플레이어 패배! (10번 내에 카메라를 가리지 못했습니다.)";
  }
}

// ------------------------------------
// (9) 유틸
// ------------------------------------
function wait(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

// ------------------------------------
// (10) 메인 초기화 흐름
// ------------------------------------
startBtn.addEventListener('click', async () => {
  if (!modelLoaded) {
    alert("아직 모델이 로딩되지 않았습니다!");
    return;
  }
  // 모델이 준비됐다면 게임 시작
  startGameFlow();
});

// 페이지 로드 시점에 카메라 + 모델 로딩 -> 완료 후 startBtn 활성화
(async function initAll() {
  statusEl.textContent = "카메라 준비 중...";
  await setupCamera();
  video.play();

  statusEl.textContent = "MoveNet MultiPose Thunder 모델 로딩 중...";
  await initDetector();

  // 모델 로딩 완료!
  modelLoaded = true;
  statusEl.textContent = "모델 로딩 완료! 게임을 시작할 수 있습니다.";
  startBtn.disabled = false;  // 시작 버튼 활성화

  // detection 루프 시작
  detectionActive = true;
  requestAnimationFrame(detectionLoop);
})();
