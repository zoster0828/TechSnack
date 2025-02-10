/*******************************************************
 * main.js
 * - 초기화, 이벤트 바인딩, 실제 게임 시작 등
 *******************************************************/
import {
  gold, setGold, weaponDamage, attackSpeed,
  isGameRunning, isGameOver,
  maxMonsterLevel,
  spawnDelay, spawnInterval, moveInterval,
  spawnCost, levelCost, damageCost, speedCost,
  shopButton, shopMenu,
  spawnUpgradeBtn, levelUpgradeBtn, damageUpgradeBtn, speedUpgradeBtn,
  lotteryButton, lotteryShop, lottery100, lottery10000, lottery1000000, lottery100000000,
  startButton, gameOverMessage
} from "./gameLogic.js"; // ← 이제 state도 포함됨

import {
  initMonsterListUI, updateMonsterListUI
} from "./monsterListUI.js";

import {
  updateUI, updateProtectedZoneUI,
  spawnMonster, moveMonsters, moveProjectiles,
  startAutoAttack,
  upgradeSpawnFrequency,
  upgradeMonsterLevel,
  upgradeWeaponDamage,
  upgradeAttackSpeed,
  playLottery,
  gameOverFunc
} from "./gameLogic.js";

function init() {
  shopButton.addEventListener("click", () => {
    shopMenu.style.display = (shopMenu.style.display === "none") ? "block" : "none";
    updateUI();
  });
  spawnUpgradeBtn.addEventListener("click", upgradeSpawnFrequency);
  levelUpgradeBtn.addEventListener("click", upgradeMonsterLevel);
  damageUpgradeBtn.addEventListener("click", upgradeWeaponDamage);
  speedUpgradeBtn.addEventListener("click", upgradeAttackSpeed);

  lotteryButton.addEventListener("click", () => {
    lotteryShop.style.display = (lotteryShop.style.display === "none") ? "block" : "none";
  });
  lottery100.addEventListener("click", () => playLottery(100));
  lottery10000.addEventListener("click", () => playLottery(10000));
  lottery1000000.addEventListener("click", () => playLottery(1000000));
  lottery100000000.addEventListener("click", () => playLottery(100000000));

  startGameWithNameButton.addEventListener("click", startGame);

  initMonsterListUI();
  updateMonsterListUI();

  updateProtectedZoneUI();
  updateUI();
}
window.addEventListener("DOMContentLoaded", init);

// 플레이어 이름 저장
let playerName = "";

// DOM 요소 가져오기
const playerNameContainer = document.getElementById("playerNameContainer");
const playerNameInput = document.getElementById("playerNameInput");
const startGameWithNameButton = document.getElementById("startGameWithName");

// 게임 시작 버튼 이벤트
startGameWithNameButton.addEventListener("click", () => {
    playerName = playerNameInput.value.trim(); // 입력된 이름 저장
    if (!playerName) {
        alert("이름을 입력해주세요!");
        return;
    }
    startGame(); // 게임 시작
});


function startGame() {
  if (isGameRunning) return;
  window.isGameRunning = true;
    // 기존 interval이 있다면 제거 (중복 방지)
    clearInterval(spawnInterval);
    clearInterval(moveInterval);
    // 플레이어 이름에 따른 시작 골드 혜택 적용
    let startingGold = 1000; // 기본 1,000원

  playerNameContainer.style.display = "none";
  gameOverMessage.style.display = "none";
  window.isGameOver = false;
  // 부활 사용 여부 초기화
  window.reviveUsed = false;

  // gold는 setter
  setGold(startingGold);
  window.weaponDamage = 10;
  window.attackSpeed = 1;
  window.maxMonsterLevel = 1;
  window.spawnDelay = 3000;

  window.spawnCost = 100;
  window.levelCost = 80;
  window.damageCost = 80;
  window.speedCost = 80;

  window.monsters = [];
  window.projectiles = [];

  updateUI();

  spawnMonster();
  window.spawnInterval = setInterval(spawnMonster, window.spawnDelay);

  window.moveInterval = setInterval(() => {
    moveMonsters();
    moveProjectiles();
  }, 20);
  updateMonsterListUI();
  startAutoAttack();
}
