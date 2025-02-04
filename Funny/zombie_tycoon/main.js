/*******************************************************
 * 전역 변수
 *******************************************************/
let gold = 0;
let weaponDamage = 10;
let attackSpeed = 1;
let isGameRunning = false;
let isGameOver = false;

// 몬스터 최대 레벨 10
let maxMonsterLevel = 1;
const maxLevelLimit = 10;
let monsters = [];

// 몬스터 이름 목록 (레벨 1~10)
const monsterNames = [
  "초보 좀비", "좀비 전사", "좀비 광전사", "좀비 암살자",
  "좀비 기사", "좀비 광기", "좀비 거인", "좀비 마법사",
  "좀비 드래곤", "좀비 왕"
];

// 몬스터 출현 간격(ms) (최소 0.1초까지 감소 가능)
let spawnDelay = 3000;
let spawnInterval = null;
const monsterSpeed = 1.2;

// 투사체
let projectiles = [];
const projectileSpeed = 30;

// 상점 비용
let spawnCost = 50;
let levelCost = 100;
let damageCost = 80;
let speedCost = 80;

// 인터벌
let attackInterval = null;
let moveInterval = null;

/*******************************************************
 * DOM 요소
 *******************************************************/
const goldDisplay     = document.getElementById("goldDisplay");
const damageDisplay   = document.getElementById("damageDisplay");
const speedDisplay    = document.getElementById("speedDisplay");
const spawnDisplay    = document.getElementById("spawnDisplay");

const shopButton      = document.getElementById("shopButton");
const shopMenu        = document.getElementById("shopMenu");
const spawnUpgradeBtn = document.getElementById("spawnUpgradeBtn");
const levelUpgradeBtn = document.getElementById("levelUpgradeBtn");
const damageUpgradeBtn= document.getElementById("damageUpgradeBtn");
const speedUpgradeBtn = document.getElementById("speedUpgradeBtn");

const spawnCostSpan   = document.getElementById("spawnCostSpan");
const levelCostSpan   = document.getElementById("levelCostSpan");
const damageCostSpan  = document.getElementById("damageCostSpan");
const speedCostSpan   = document.getElementById("speedCostSpan");

const startButton     = document.getElementById("startButton");
const gameOverMessage = document.getElementById("gameOverMessage");
const gameArea        = document.getElementById("gameArea");
const castle          = document.getElementById("castle");

/*******************************************************
 * UI 갱신
 *******************************************************/
function updateUI() {
  goldDisplay.textContent   = gold;
  damageDisplay.textContent = weaponDamage;
  speedDisplay.textContent  = attackSpeed.toFixed(1);
  spawnDisplay.textContent  = (spawnDelay/1000).toFixed(1);

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

/*******************************************************
 * 몬스터 정보 (레벨별 HP, 보상, 이름)
 *******************************************************/
function getMonsterInfo(level) {
  // HP & 보상
  const hp = 30 + (level -1)*25;
  const reward = 10 + (level -1)*5;

  // 이름 (레벨 범위 안에서 가져오기)
  const idx = Math.min(level-1, monsterNames.length-1);
  const name = monsterNames[idx];

  return { hp, reward, name };
}

/*******************************************************
 * 몬스터 스폰
 *******************************************************/
function spawnMonster() {
  if (isGameOver) return;

  const level = Math.floor(Math.random() * maxMonsterLevel) + 1;
  const { hp, reward, name } = getMonsterInfo(level);

  // 몬스터 컨테이너
  const monsterDiv = document.createElement("div");
  monsterDiv.className = "monster";

  // (1) 이름
  const nameDiv = document.createElement("div");
  nameDiv.className = "monster-name";
  nameDiv.textContent = name + " (Lv." + level + ")";

  // (2) 체력바
  const healthBar = document.createElement("div");
  healthBar.className = "monster-healthbar";
  const healthFill = document.createElement("div");
  healthFill.className = "monster-healthbar-fill";
  healthBar.appendChild(healthFill);

  // (3) 실제 몬스터 이미지
  const monsterImg = document.createElement("img");
  const imgIndex = Math.min(level, 10);
  monsterImg.src = `assets/monster${imgIndex}.png`;

  // 조립
  monsterDiv.appendChild(nameDiv);
  monsterDiv.appendChild(healthBar);
  monsterDiv.appendChild(monsterImg);

  // 위치(화면 상단)
  const startLeft = Math.random() * (gameArea.clientWidth - 80);
  monsterDiv.style.left = `${startLeft}px`;
  monsterDiv.style.top  = `-120px`;

  gameArea.appendChild(monsterDiv);

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
    y: -120
  });
}

/*******************************************************
 * 몬스터 이동 & 체력바 갱신
 *******************************************************/
function moveMonsters() {
  if (isGameOver) return;

  const castleRect = castle.getBoundingClientRect();
  const castleTop  = castleRect.top;

  for (let i = monsters.length - 1; i >= 0; i--) {
    const m = monsters[i];
    m.y += monsterSpeed;
    m.element.style.top = m.y + "px";

    // 체력바 갱신 (width: hp/maxHp * 100%)
    const ratio = m.hp / m.maxHp;
    m.healthFill.style.width = `${(ratio * 100).toFixed(1)}%`;

    // 성 도달 체크
    if (m.y + 120 >= castleTop) {
      gameOver();
      return;
    }
  }
}

/*******************************************************
 * 투사체 생성
 *******************************************************/
function spawnProjectile(target) {
  const proj = document.createElement("div");
  proj.className = "projectile";

  // 출발 위치(성 윗부분 중간)
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
}

/*******************************************************
 * 투사체 이동 & 피격
 *******************************************************/
function moveProjectiles() {
  if (isGameOver) return;

  for (let i = projectiles.length - 1; i >= 0; i--) {
    const p = projectiles[i];
    const t = p.target;
    // 이미 제거된 몬스터?
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
      hitMonster(t, i);
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

/**
 * 몬스터가 피격되었을 때 처리
 * - 몬스터가 죽으면: 해당 몬스터 타겟팅 중인 모든 투사체 제거
 */
function hitMonster(monster, projIndex) {
  removeProjectile(projIndex);

  monster.hp -= weaponDamage;
  if (monster.hp <= 0) {
    gold += monster.reward;

    // (중요) 몬스터가 죽었으면
    // 이 몬스터를 향해 날아가던 투사체 모두 제거
    for (let i = projectiles.length - 1; i >= 0; i--) {
      if (projectiles[i].target === monster) {
        removeProjectile(i);
      }
    }

    gameArea.removeChild(monster.element);
    monsters.splice(monsters.indexOf(monster), 1);
  }
  updateUI();
}

function removeProjectile(idx) {
  const p = projectiles[idx];
  if (!p) return;
  gameArea.removeChild(p.element);
  projectiles.splice(idx, 1);
}

/*******************************************************
 * 자동 공격
 * - "예상 데미지" 계산하여, 죽을 몬스터는 추가 발사하지 않음
 * - 살아있어도, 이미 날아가는 투사체로 죽을 예측이면 다음 몬스터로
 *******************************************************/
function startAutoAttack() {
  if (attackInterval) clearInterval(attackInterval);
  const attackDelay = 1000 / attackSpeed;

  attackInterval = setInterval(() => {
    if (monsters.length === 0 || isGameOver) return;

    // 순서대로 몬스터를 확인, "기존 투사체로 죽을 예정"이 아닌 몬스터를 찾는다
    let target = null;
    for (let i = 0; i < monsters.length; i++) {
      const m = monsters[i];
      // 현재 m을 향해 날아가는 투사체 수
      const inFlight = projectiles.filter(p => p.target === m).length;
      const pendingDamage = inFlight * weaponDamage;

      // 현재 HP보다 pendingDamage가 작다면, "아직 죽지 않을 몬스터"이므로 타겟!
      if (m.hp > pendingDamage) {
        target = m;
        break;
      }
      // pendingDamage >= m.hp => 이미 죽을 예정, 스킵하고 다음 몬스터 확인
    }

    if (!target) {
      // 모든 몬스터가 이미 "기존 투사체로 죽을 예정"이거나 없음
      return;
    }

    // 선택된 타겟에게 투사체 발사
    spawnProjectile(target);

  }, attackDelay);
}

/*******************************************************
 * 업그레이드 (0.1초 제한, 레벨 10 제한)
 *******************************************************/
function upgradeSpawnFrequency() {
  if (gold >= spawnCost && spawnDelay > 100) {
    gold -= spawnCost;
    spawnDelay = Math.max(100, spawnDelay - 500);
    spawnCost *= 2;
    updateUI();

    clearInterval(spawnInterval);
    spawnInterval = setInterval(spawnMonster, spawnDelay);

    if (spawnDelay === 100) {
      spawnUpgradeBtn.disabled = true;
    }
  }
}

function upgradeMonsterLevel() {
  if (gold >= levelCost && maxMonsterLevel < maxLevelLimit) {
    gold -= levelCost;
    maxMonsterLevel++;
    levelCost *= 2;
    updateUI();

    if (maxMonsterLevel === maxLevelLimit) {
      levelUpgradeBtn.disabled = true;
    }
  }
}

function upgradeWeaponDamage() {
  if (gold >= damageCost) {
    gold -= damageCost;
    weaponDamage += 10;
    damageCost *= 2;
    updateUI();
  }
}

function upgradeAttackSpeed() {
  if (gold >= speedCost) {
    gold -= speedCost;
    attackSpeed += 0.5;
    speedCost *= 2;
    updateUI();
    startAutoAttack();
  }
}

/*******************************************************
 * 게임 오버
 *******************************************************/
function gameOver() {
  isGameOver = true;
  gameOverMessage.style.display = "block";
  clearInterval(spawnInterval);
  clearInterval(attackInterval);
  clearInterval(moveInterval);
}

/*******************************************************
 * 게임 시작
 *******************************************************/
function startGame() {
  if (isGameRunning) return;
  isGameRunning = true;

  startButton.style.display = "none";
  gameOverMessage.style.display = "none";
  isGameOver = false;

  gold = 1000;
  weaponDamage = 10;
  attackSpeed = 1;
  maxMonsterLevel = 1;
  spawnDelay = 3000;

  spawnCost = 50;
  levelCost = 100;
  damageCost = 80;
  speedCost = 80;

  monsters = [];
  projectiles = [];

  updateUI();

  spawnMonster();
  spawnInterval = setInterval(spawnMonster, spawnDelay);

  moveInterval = setInterval(() => {
    moveMonsters();
    moveProjectiles();
  }, 20);

  startAutoAttack();
}

/*******************************************************
 * 초기화
 *******************************************************/
function init() {
  shopButton.addEventListener("click", () => {
    if (shopMenu.style.display === "none") {
      shopMenu.style.display = "block";
    } else {
      shopMenu.style.display = "none";
    }
    updateUI();
  });
  spawnUpgradeBtn.addEventListener("click", upgradeSpawnFrequency);
  levelUpgradeBtn.addEventListener("click", upgradeMonsterLevel);
  damageUpgradeBtn.addEventListener("click", upgradeWeaponDamage);
  speedUpgradeBtn.addEventListener("click", upgradeAttackSpeed);

  startButton.addEventListener("click", startGame);

  updateUI();
}
init();
