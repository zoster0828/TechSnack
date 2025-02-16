// monsterListItems: 레벨별 DOM 항목 저장
export let monsterListItems = [];

// 몬스터 목록 UI 생성
export function initMonsterListUI() {
  const container = document.getElementById("monsterListContainer");
  container.innerHTML = ""; // 초기화

  // row1 (1~10), row2 (11~20)
  const row1 = document.createElement("div");
  row1.className = "monster-list-row";
  const row2 = document.createElement("div");
  row2.className = "monster-list-row";

  for (let lv = 1; lv <= 20; lv++) {
    const item = document.createElement("div");
    item.className = "monster-list-item locked"; // 처음에는 locked
    // 이미지
    const img = document.createElement("img");
    const imgIndex = Math.min(lv, 20);
    img.src = `assets/monster${imgIndex}.png`;
    // 레벨/이름 표시는 간단히 레벨만
    const label = document.createElement("div");
    label.textContent = `Lv.${lv}`;

    item.appendChild(img);
    item.appendChild(label);

    // 1~10 -> row1, 11~20 -> row2
    if (lv <= 10) row1.appendChild(item);
    else row2.appendChild(item);

    monsterListItems[lv] = item; // 배열에 저장
  }

  container.appendChild(row1);
  container.appendChild(row2);
}
import { maxMonsterLevel } from "./gameLogic.js";

export function updateMonsterListUI() {
  // lv: 1..maxMonsterLevel 까지는 unlocked
  for (let lv = 1; lv <= 20; lv++) {
    const item = monsterListItems[lv];
    if (!item) continue;
    if (lv <= maxMonsterLevel) {
      // 보여주기
      item.classList.remove("locked");
    } else {
      // 숨기거나 잠금
      item.classList.add("locked");
    }
  }
}
