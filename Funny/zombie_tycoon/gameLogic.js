/*******************************************************
 * gameLogic.js (합본)
 * - 전역 상태/DOM & 게임 로직(몬스터, 투사체, 업그레이드, 로터리 등)
 *******************************************************/
/** ==============================
 *  [전역 상태 / DOM 참조]
 * ============================== */

// 기본 게임 상태
export let gold = 0;
/** gold 값을 특정 value로 설정 */
export function setGold(value) {
  gold = value;
}
/** gold를 value만큼 추가 */
export function addGold(value) {
  gold += value;
}
/** gold를 value만큼 차감 */
export function spendGold(value) {
  gold -= value;
}
export let reviveUsed = false; // 부활(한 번만) 사용 여부
export let weaponDamage = 10;
export let attackSpeed = 1;
export let isGameRunning = false;
export let isGameOver = false;

// 몬스터 레벨 관련
export let maxMonsterLevel = 1;
export const maxLevelLimit = 20;

// 몬스터, 투사체 목록
export let monsters = [];
export let projectiles = [];

// 업그레이드 비용
export let spawnCost = 100;
export let levelCost = 80;
export let damageCost = 80;
export let speedCost = 80;

// 보호 구역 비율
export let protectedZoneHeight = 0.05;

// 자동 공격 & 이동 Interval
export let attackInterval = null;
export let moveInterval = null;
export let spawnInterval = null;

// 몬스터 이름 목록 (레벨 1~20)
export const monsterNames = [
  ""
];

// 몬스터 등장 주기 단계별 (3초 → 0.1초)
export const spawnIntervals = [3000, 2200, 1600, 1200, 900, 700, 500, 300, 200, 100];
export let spawnLevel = 0;
export let spawnDelay = 3000;
export const monsterSpeed = 0.6;
export const projectileSpeed = 30;

// DOM 요소
export const goldDisplay       = document.getElementById("goldDisplay");
export const damageDisplay     = document.getElementById("damageDisplay");
export const speedDisplay      = document.getElementById("speedDisplay");
export const spawnDisplay      = document.getElementById("spawnDisplay");

export const shopButton        = document.getElementById("shopButton");
export const shopMenu          = document.getElementById("shopMenu");
export const spawnUpgradeBtn   = document.getElementById("spawnUpgradeBtn");
export const levelUpgradeBtn   = document.getElementById("levelUpgradeBtn");
export const damageUpgradeBtn  = document.getElementById("damageUpgradeBtn");
export const speedUpgradeBtn   = document.getElementById("speedUpgradeBtn");

export const spawnCostSpan     = document.getElementById("spawnCostSpan");
export const levelCostSpan     = document.getElementById("levelCostSpan");
export const damageCostSpan    = document.getElementById("damageCostSpan");
export const speedCostSpan     = document.getElementById("speedCostSpan");

export const startButton       = document.getElementById("startButton");
export const gameOverMessage   = document.getElementById("gameOverMessage");
export const gameArea          = document.getElementById("gameArea");
export const castle            = document.getElementById("castle");

// 로터리(뽑기)
export const lotteryButton     = document.getElementById("lotteryButton");
export const lotteryShop       = document.getElementById("lotteryShop");
export const lottery100        = document.getElementById("lottery100");
export const lottery10000      = document.getElementById("lottery10000");
export const lottery1000000    = document.getElementById("lottery1000000");
export const lottery100000000  = document.getElementById("lottery100000000");

// 보호 구역 표시
export const protectedZone = document.createElement("div");
protectedZone.id = "protectedZone";
gameArea.appendChild(protectedZone);

/** ==============================
 *  [게임 로직 부분]
 * ============================== */

/** UI 업데이트 */
export function updateUI() {
  goldDisplay.textContent   = gold;
  damageDisplay.textContent = weaponDamage;
  speedDisplay.textContent  = attackSpeed.toFixed(1);
  spawnDisplay.textContent  = (spawnDelay / 1000).toFixed(1);

  spawnCostSpan.textContent  = spawnCost;
  levelCostSpan.textContent  = levelCost;
  damageCostSpan.textContent = damageCost;
  speedCostSpan.textContent  = speedCost;

  // 업그레이드 버튼 활성/비활성
  spawnUpgradeBtn.disabled  = (gold < spawnCost || spawnDelay <= 100);
  levelUpgradeBtn.disabled  = (gold < levelCost || maxMonsterLevel >= maxLevelLimit);
  damageUpgradeBtn.disabled = (gold < damageCost);
  speedUpgradeBtn.disabled  = (gold < speedCost);
}

/** 보호 구역 표시 업데이트 */
export function updateProtectedZoneUI() {
  const height = gameArea.clientHeight * protectedZoneHeight;
  protectedZone.style.height = `${height}px`;
}

/** 간단 효과음(Web Audio) */
export function playSound(frequency, type = "sine", duration = 0.1) {
  const audioCtx = new (window.AudioContext || window.webkitAudioContext)();
  const oscillator = audioCtx.createOscillator();
  const gainNode = audioCtx.createGain();

  oscillator.type = type;
  oscillator.frequency.setValueAtTime(frequency, audioCtx.currentTime);

  gainNode.gain.setValueAtTime(0.2, audioCtx.currentTime);
  gainNode.gain.exponentialRampToValueAtTime(0.001, audioCtx.currentTime + duration);

  oscillator.connect(gainNode);
  gainNode.connect(audioCtx.destination);
  oscillator.start();
  oscillator.stop(audioCtx.currentTime + duration);
}

/** 몬스터 정보 */
function getMonsterInfo(level) {
  const hp = 30 + (level - 1) * 25;
  const reward = Math.floor(20 * Math.pow(1.5, level - 1));
  const idx = Math.min(level - 1, monsterNames.length - 1);
  const name = monsterNames[idx];
  return { hp, reward, name };
}

/** 몬스터 스폰 */
export function spawnMonster() {
  if (isGameOver) return;

  const level = Math.floor(Math.random() * maxMonsterLevel) + 1;
  const { hp, reward, name } = getMonsterInfo(level);

  const monsterDiv = document.createElement("div");
  monsterDiv.className = "monster";

  const nameDiv = document.createElement("div");
  nameDiv.className = "monster-name";
  nameDiv.textContent = `${name} (Lv.${level})`;

  const healthBar = document.createElement("div");
  healthBar.className = "monster-healthbar";
  const healthFill = document.createElement("div");
  healthFill.className = "monster-healthbar-fill";
  healthBar.appendChild(healthFill);

  const monsterImg = document.createElement("img");
  const imgIndex = Math.min(level, 20);
  monsterImg.src = `assets/monster${imgIndex}.png`;

  monsterDiv.appendChild(nameDiv);
  monsterDiv.appendChild(healthBar);
  monsterDiv.appendChild(monsterImg);

  const startLeft = Math.random() * (gameArea.clientWidth - 80);
  monsterDiv.style.left = `${startLeft}px`;
  monsterDiv.style.top  = `-120px`;

  gameArea.appendChild(monsterDiv);

  const protectedZoneY = gameArea.clientHeight * protectedZoneHeight;

  monsters.push({
    level,
    name,
    hp,
    maxHp: hp,
    reward,
    element: monsterDiv,
    nameDiv,
    healthBar,
    healthFill,
    x: startLeft,
    y: -120,
    isProtected: true,
    protectedZoneY
  });
}

/** 몬스터 이동 */
export function moveMonsters() {
  if (isGameOver) return;

  const castleRect = castle.getBoundingClientRect();
  const castleTop  = castleRect.top;

  for (let i = monsters.length - 1; i >= 0; i--) {
    const m = monsters[i];
    m.y += monsterSpeed;
    m.element.style.top = m.y + "px";

    const ratio = m.hp / m.maxHp;
    m.healthFill.style.width = `${(ratio * 100).toFixed(1)}%`;

    // 보호 구역 해제
    if (m.isProtected && m.y >= m.protectedZoneY) {
      m.isProtected = false;
    }

    // 성 도달 체크
    if (m.y + 120 >= castleTop) {
      // ====== 변경된 로직 ======
      if (!reviveUsed) {
        // 처음으로 성에 닿았으면 => 몬스터 전부 밀어내고 reviveUsed = true
        doRevive();
        return; // monsters 이동 로직 한 번 중단
      } else {
        // 이미 부활 사용 => 게임 오버
        gameOverFunc();
        return;
      }
    }
  }
}

/** 몬스터 전체 '밀어내기'(부활) */
function doRevive() {
  // 부활 사용
  reviveUsed = true;

  // 사운드 재생 (원하는 효과음)
  playSound(50, "triangle", 0.01); // 저음 폭발 느낌

  // 모든 몬스터를 시작 위치(-120)로 밀어내고, 보호 상태(true)로 만든다.
  for (let i = 0; i < monsters.length; i++) {
    const m = monsters[i];
    m.y = -120;
    m.element.style.top = "-120px";
    m.isProtected = true; // 다시 보호구역 적용
  }
}

/** 투사체 생성 */
export function spawnProjectile(target) {
  const proj = document.createElement("div");
  proj.className = "projectile";

  const castleRect = castle.getBoundingClientRect();
  const startX = (gameArea.clientWidth / 2);
  const startY = castleRect.top - 20;

  proj.style.left = `${startX}px`;
  proj.style.top  = `${startY}px`;
  gameArea.appendChild(proj);

  projectiles.push({
    element: proj,
    x: startX,
    y: startY,
    target
  });

  playSound(500, "square", 0.01);
}

/** 투사체 이동 */
export function moveProjectiles() {
  if (isGameOver) return;

  for (let i = projectiles.length - 1; i >= 0; i--) {
    const p = projectiles[i];
    const t = p.target;
    if (!monsters.includes(t)) {
      removeProjectile(i);
      continue;
    }
    const centerX = t.x + 40;
    const centerY = t.y + 60;
    const dx = centerX - p.x;
    const dy = centerY - p.y;
    const dist = Math.sqrt(dx*dx + dy*dy);

    if (dist < 15) {
      if (!t.isProtected) {
        hitMonster(t, i);
      } else {
        removeProjectile(i);
      }
      continue;
    }
    const vx = (dx / dist) * projectileSpeed;
    const vy = (dy / dist) * projectileSpeed;
    p.x += vx;
    p.y += vy;
    p.element.style.left = `${p.x}px`;
    p.element.style.top  = `${p.y}px`;
  }
}

/** 투사체 제거 */
export function removeProjectile(idx) {
  const p = projectiles[idx];
  if (!p) return;
  gameArea.removeChild(p.element);
  projectiles.splice(idx, 1);
}

/** 몬스터 피격 */
function hitMonster(monster, projIndex) {
  removeProjectile(projIndex);

  monster.hp -= weaponDamage;
  if (monster.hp <= 0) {
    playSound(100, "sawtooth", 0.2);

    // 10% 확률 10배 보너스
    let bonus = Math.random() < 0.1 ? 10 : 1;
    let rewardAmount = monster.reward * bonus;
    createCoinAnimation(monster.x, monster.y, rewardAmount, bonus === 10);

    // 죽은 몬스터를 향해 날아가던 투사체 제거
    for (let i = projectiles.length - 1; i >= 0; i--) {
      if (projectiles[i].target === monster) {
        removeProjectile(i);
      }
    }
    // 몬스터 제거
    gameArea.removeChild(monster.element);
    monsters.splice(monsters.indexOf(monster), 1);
  }
  updateUI();
}

/** 돈 획득 애니메이션 */
export function createCoinAnimation(x, y, amount, isBonus) {
  const coin = document.createElement("img");
  if (isBonus) {
    coin.src = "assets/coin_bonus.png";
    coin.style.width = "40px";
    coin.style.height = "40px";
  } else {
    coin.src = "assets/coin.png";
    coin.style.width = "32px";
    coin.style.height = "32px";
  }

  coin.className = "coin-animation";
  coin.style.left = `${x}px`;
  coin.style.top  = `${y}px`;
  gameArea.appendChild(coin);

  setTimeout(() => {
    coin.style.left = "10px";
    coin.style.top  = "10px";
    coin.style.opacity = "0";

    setTimeout(() => {
      addGold(amount); // gold += amount;
      gameArea.removeChild(coin);
      updateUI();
    }, 600);
  }, 10);
}

/** 뽑기 상점 */
export function playLottery(cost) {
  if (gold < cost) return;
  spendGold(cost);
  updateUI();

  let rand = Math.random();
  let multiplier = 0;
  let isJackpot = false;

  // 2% 확률로 100배
  if (rand < 0.02) {
    multiplier = 100;
    isJackpot = true;
  }
  // 10% 확률로 10배
  else if (rand < 0.1) {
    multiplier = 10;
  }

  if (multiplier > 0) {
    let rewardAmount = cost * multiplier;
    createLotteryCoinAnimation(300, 300, rewardAmount, isJackpot);
  }
}

/** 뽑기 보상 애니메이션 */
function createLotteryCoinAnimation(x, y, amount, isJackpot) {
  const coin = document.createElement("img");

  if (isJackpot) {
    coin.src = "assets/coin_jackpot.png";
    coin.style.width = "500px";
    coin.style.height = "250px";
  } else {
    coin.src = "assets/coin_bonus.png";
    coin.style.width = "200px";
    coin.style.height = "200px";
  }

  coin.className = "coin-animation";
  coin.style.left = `${x}px`;
  coin.style.top  = `${y}px`;
  gameArea.appendChild(coin);

  setTimeout(() => {
    coin.style.left = "10px";
    coin.style.top  = "10px";
    coin.style.opacity = "0";

    setTimeout(() => {
      addGold(amount);
      gameArea.removeChild(coin);
      updateUI();
    }, 600);
  }, 10);
}

/** 몬스터 등장 주기(단계별) */
export function upgradeSpawnFrequency() {
  if (gold >= spawnCost && spawnLevel < spawnIntervals.length - 1) {
    spendGold(spawnCost);

    spawnLevel++;
    spawnDelay = spawnIntervals[spawnLevel];
    spawnCost = Math.floor(spawnCost * 2.5);

    updateUI();

    clearInterval(spawnInterval);
    spawnInterval = setInterval(spawnMonster, spawnDelay);

    if (spawnLevel === spawnIntervals.length - 1) {
      spawnUpgradeBtn.disabled = true;
    }
  }
}
import { updateMonsterListUI } from "./monsterListUI.js";
/** 몬스터 레벨 */
export function upgradeMonsterLevel() {
  if (gold >= levelCost && maxMonsterLevel < maxLevelLimit) {
    spendGold(levelCost);
    maxMonsterLevel++;
    levelCost = Math.floor(levelCost * 1.8);
    updateUI();

    // 몬스터 목록 갱신 (monsterListUI)
    updateMonsterListUI();

    if (maxMonsterLevel === maxLevelLimit) {
      levelUpgradeBtn.disabled = true;
    }
  }
}

/** 무기 데미지 */
export function upgradeWeaponDamage() {
  if (gold >= damageCost) {
    spendGold(damageCost);
    weaponDamage += 10;
    damageCost *= 2;
    updateUI();
  }
}

/** 발사 속도 */
export function upgradeAttackSpeed() {
  if (gold >= speedCost) {
    spendGold(speedCost);
    attackSpeed += 0.5;
    speedCost *= 2;
    updateUI();
    startAutoAttack();
  }
}

/** 자동 공격 */
export function startAutoAttack() {
  if (attackInterval) clearInterval(attackInterval);
  const attackDelay = 1000 / attackSpeed;

  attackInterval = setInterval(() => {
    if (monsters.length === 0 || isGameOver) return;

    let target = null;
    for (let i = 0; i < monsters.length; i++) {
      const m = monsters[i];
      if (m.isProtected) continue;

      const inFlight = projectiles.filter(p => p.target === m).length;
      const pendingDamage = inFlight * weaponDamage;
      if (m.hp > pendingDamage) {
        target = m;
        break;
      }
    }
    if (!target) return;

    spawnProjectile(target);
  }, attackDelay);
}

/** 게임오버 */
export function gameOverFunc() {
  isGameOver = true;
  gameOverMessage.style.display = "block";
  clearInterval(spawnInterval);
  clearInterval(attackInterval);
  clearInterval(moveInterval);
}
