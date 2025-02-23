const video = document.getElementById('video');
const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const statusEl = document.getElementById('status');
const startBtn = document.getElementById('startBtn');

// 전역 flags
let modelLoaded = false;          // 모델 로딩 완료 여부
let detectionActive = false;      // 실시간 감지 on/off
let gameActive = false;           // 게임 진행 여부
let isRedLight = false;           // 빨간불 상태

// 라운드
let currentRound = 0;
const MAX_ROUNDS = 10;

// Pose Detector
let detector = null;

// 이전 프레임 Pose
let prevPoses = [];

// 추론 주기 제한 (약 10fps)
const DETECTION_INTERVAL = 100; // ms
let lastDetectionTime = 0;

// ---------------------------
// 1) WebGPU 백엔드 우선 설정
// ---------------------------
async function initBackend() {
  // WebGPU 백엔드 등록 여부 확인
  const hasWebGPUBackend = !!tf.engine().registryFactory['webgpu'];
  if (hasWebGPUBackend) {
    try {
      await tf.setBackend('webgpu');
      await tf.ready();
      console.log('✅ Using WebGPU backend');
      return;
    } catch (err) {
      console.warn('❌ WebGPU not available, fallback to WebGL', err);
    }
  }
  // fallback to webgl
  await tf.setBackend('webgl');
  await tf.ready();
  console.log('🔄 Using WebGL backend');
}

// ---------------------------
// 2) 카메라 셋업
// ---------------------------
async function setupCamera() {
  try {
    const stream = await navigator.mediaDevices.getUserMedia({
      video: {
        facingMode: 'user',
        width: { ideal: 640 },
        height: { ideal: 480 }
      },
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

// ---------------------------
// 3) TTS
// ---------------------------
function speak(text) {
  // 이미 재생 중인 TTS 취소
  speechSynthesis.cancel();

  // 1) 기기 언어 설정 확인
  // - iOS Safari, 안드로이드 크롬 등에서 대부분 navigator.language 반환 가능
  // - 예: "ko-KR", "en-US", "en-GB" 등
  const userLang = (navigator.language || 'en-US').toLowerCase();

  // 2) 언어 결정
  let selectedLang;
  if (userLang.startsWith('ko')) {
    // 한국어 기기
    selectedLang = 'ko-KR';
  } else {
    // 그 외(영문 등)
    selectedLang = 'en-US';
  }

  // 3) SpeechSynthesisUtterance 생성
  const utter = new SpeechSynthesisUtterance(text);
  utter.lang = selectedLang;

  // (선택) 실제로 설치된 음성 중에서 selectedLang에 맞는 voice를 찾기
  //  - iOS/Android에서 해당 언어 음성이 설치되어 있으면 더 자연스럽게 발음
  const voices = speechSynthesis.getVoices().filter(v => v.lang.startsWith(selectedLang));
  if (voices.length > 0) {
    utter.voice = voices[0];
  }

  // 4) 재생
  speechSynthesis.speak(utter);
}


function stopAllTTS() {
  speechSynthesis.cancel();
}

// ---------------------------
// 4) MoveNet MultiPose Thunder 초기화
// ---------------------------
async function initDetector() {
  const model = poseDetection.SupportedModels.MoveNet;
  const detectorConfig = {
    modelType: poseDetection.movenet.modelType.MULTIPOSE_THUNDER
  };
  detector = await poseDetection.createDetector(model, detectorConfig);
}

// ---------------------------
// 5) 메인 루프 (requestAnimationFrame)
//    - 그러나 실제 추론은 DETECTION_INTERVAL 간격으로 실행
// ---------------------------
function mainLoop(timestamp) {
  if (!detectionActive) return;

  // (A) 화면에 비디오 그리기
  ctx.drawImage(video, 0, 0, canvas.width, canvas.height);

  // (B) 일정 주기가 지났다면 pose 추론
  const elapsed = timestamp - lastDetectionTime;
  if (elapsed > DETECTION_INTERVAL) {
    lastDetectionTime = timestamp;
    doPoseDetection(); // 실제 추론 & 움직임 체크
  }

  requestAnimationFrame(mainLoop);
}

// 실제 pose 추론 함수
async function doPoseDetection() {
  // 카메라가 가려졌는지 먼저 체크 (가려지면 승리)
  if (checkCover() && gameActive) {
    endGame(true); // 승리
    return;
  }

  // Pose 추론
  let poses = [];
  try {
    poses = await detector.estimatePoses(video, {
      maxPoses: 6,
      flipHorizontal: false
    });
  } catch (err) {
    console.warn("Pose 추론 에러:", err);
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
        x: minX,
        y: minY,
        width: maxX - minX,
        height: maxY - minY
      }
    };
  });

  // 움직임 감지
  const movementDetected = detectMovementMulti(persons, prevPoses);
  // 빨간불 + 움직임 + 게임중 -> 탈락
  if (isRedLight && gameActive && movementDetected) {
    endGame(false);
    return;
  }

  // 시각화(옵션)
  drawPersons(persons);

  // update prev
  prevPoses = persons;
}

// ---------------------------
// 6) 카메라 가림 체크 (평균 밝기)
// ---------------------------
function checkCover() {
  const frame = ctx.getImageData(0, 0, canvas.width, canvas.height);
  let total = 0;
  const step = 50;
  for (let i = 0; i < frame.data.length; i += 4 * step) {
    const r = frame.data[i];
    const g = frame.data[i+1];
    const b = frame.data[i+2];
    total += (r + g + b) / 3;
  }
  const count = frame.data.length / (4 * step);
  const avg = total / count;
  return (avg < 10); // 아주 어두우면 가림 판단
}

// ---------------------------
// 7) 여러 사람 움직임 감지
// ---------------------------
function detectMovementMulti(currentPersons, prevPersons) {
  if (!prevPersons || prevPersons.length === 0) return false;

  const MOVE_THRESHOLD = 15; // iPhone에서 약간 여유
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
    if (a.score > 0.3 && b.score > 0.3) {
      const dx = a.x - b.x;
      const dy = a.y - b.y;
      sumDist += Math.sqrt(dx*dx + dy*dy);
      count++;
    }
  }
  if (count === 0) return 0;
  return sumDist / count;
}

// ---------------------------
// 8) 시각화(옵션): bbox & keypoints
// ---------------------------
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
        ctx.arc(kp.x, kp.y, 4, 0, 2 * Math.PI);
        ctx.fill();
      }
    });
  });
}

// ---------------------------
// 9) 게임 로직 (빨간불/초록불)
// ---------------------------
async function startGameFlow() {
  if (!modelLoaded) {
    alert("모델이 아직 로딩되지 않았습니다!");
    return;
  }
  if (gameActive) return;

  gameActive = true;
  currentRound = 0;
  speak("게임 시작");
  statusEl.textContent = "게임 시작!";

  for (let i = 1; i <= MAX_ROUNDS; i++) {
    if (!gameActive) break;
    currentRound = i;

    // (A) 초록불 구간: "무궁화 꽃이 피었습니다."
    statusEl.textContent = `Round ${i}: 초록불 (움직여도 됨)`;
    speak("무궁화 꽃이 피었습니다.");
    isRedLight = false;
    // 2초 정도 대기
    await wait(2000);
    if (!gameActive) break;

    // (B) 빨간불 3초
    statusEl.textContent = `Round ${i}: 빨간불 3초 (움직이면 탈락)`;
    speak("빨간불입니다. 움직이지 마세요.");
    isRedLight = true;
    await wait(3000);
    isRedLight = false;
    if (!gameActive) break;

    statusEl.textContent = `Round ${i} 완료`;
  }

  // 10라운드 끝났는데 승리 못하면 패배
  if (gameActive) endGame(false);
}

function endGame(isWin) {
  if (!gameActive) return;
  gameActive = false;
  stopAllTTS();

  if (isWin) {
    speak("플레이어 승리");
    statusEl.textContent = "플레이어 승리! (카메라 가려짐)";
  } else {
    speak("플레이어 패배");
    statusEl.textContent = "플레이어 패배! (빨간불에 움직임 or 10라운드 종료)";
  }

  isRedLight = false;
}

// ---------------------------
// 10) 유틸
// ---------------------------
function wait(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

// ---------------------------
// 11) 초기화 흐름
// ---------------------------
startBtn.addEventListener('click', () => {
  if (!modelLoaded) {
    alert("아직 모델이 로딩되지 않았습니다!");
    return;
  }
  startGameFlow();
});

(async function initAll() {
  // (A) WebGPU 백엔드 (or WebGL) 설정
  await initBackend();

  // (B) 카메라 준비
  statusEl.textContent = "카메라 준비 중...";
  await setupCamera();
  video.play();

  // (C) MoveNet MultiPose Thunder 모델 로딩
  statusEl.textContent = "포즈 모델 로딩 중...";
  await initDetector();

  // (D) 모델 로딩 완료
  modelLoaded = true;
  statusEl.textContent = "모델 로딩 완료! [게임 시작] 버튼을 누르세요.";
  startBtn.disabled = false;

  // (E) detection 루프 시작
  detectionActive = true;
  requestAnimationFrame(mainLoop);
})();
