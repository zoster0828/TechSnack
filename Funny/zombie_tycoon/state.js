/*******************************************************
 * state.js
 * - 전역 변수, 상수, DOM 요소 참조
 *******************************************************/

// 기본 게임 상태
export let gold = 0;
export function setGold(value) {
  gold = value;
}
export function addGold(value) {
  gold += value;
}
export function spendGold(value) {
  gold -= value;
}
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


// 몬스터 등장 주기 단계별 (3초 → 0.1초)
export const spawnIntervals = [3000, 2200, 1600, 1200, 900, 700, 500, 300, 200, 100];
export let spawnLevel = 0; // 현재 단계
export let spawnDelay = 3000; // 현재 등장 간격 (ms)
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
