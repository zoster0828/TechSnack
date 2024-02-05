const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');
const snakeSize = 20;
let snake = [{x: 160, y: 200}, {x: 140, y: 200}, {x: 120, y: 200}];
let score = 0; // 점수 변수 초기화
let food = getNewFoodPosition();
let dx = snakeSize;
let dy = 0;
let changingDirection = false;

// 스네이크 캐릭터 이미지 로드
const headImage = new Image();
headImage.src = '/Funny/SnakeGame/img/snake_head.png'; // 스네이크 머리 이미지 경로

const bodyImage = new Image();
bodyImage.src = '/Funny/SnakeGame/img/snake_body.png'; // 스네이크 몸통 이미지 경로

const tailImage = new Image();
tailImage.src = '/Funny/SnakeGame/img/snake_tail.png'; // 스네이크 꼬리 이미지 경로

document.addEventListener("keydown", changeDirection);

function main() {
  if (didGameEnd()) return;

  changingDirection = false;
  setTimeout(function onTick() {
    clearCanvas();
    drawFood();
    advanceSnake();
    drawSnake();
    drawScore(); // 점수 그리기 함수 호출
    main();
  }, 100);
}

function clearCanvas() {
  ctx.fillStyle = 'white';
  ctx.fillRect(0, 0, canvas.width, canvas.height);
}

function drawFood() {
  ctx.fillStyle = 'red';
  ctx.fillRect(food.x, food.y, snakeSize, snakeSize);
}

function advanceSnake() {
  const head = {x: snake[0].x + dx, y: snake[0].y + dy};
  snake.unshift(head);

  const didEatFood = snake[0].x === food.x && snake[0].y === food.y;
  if (didEatFood) {
    score += 1; // 먹이를 먹을 때마다 점수 1점 증가
    food = getNewFoodPosition();
  } else {
    snake.pop();
  }
}

function drawSnake() {
  snake.forEach((part, index) => {
    let img;
    if (index === 0) {
      img = headImage;
    } else if (index === snake.length - 1) {
      img = tailImage;
    } else {
      img = bodyImage;
    }
    ctx.drawImage(img, part.x, part.y, snakeSize, snakeSize);
  });
}

function changeDirection(event) {
  const LEFT_KEY = 37;
  const RIGHT_KEY = 39;
  const UP_KEY = 38;
  const DOWN_KEY = 40;

  const keyPressed = event.keyCode;
  const goingUp = dy === -snakeSize;
  const goingDown = dy === snakeSize;
  const goingRight = dx === snakeSize;
  const goingLeft = dx === -snakeSize;

  if ([LEFT_KEY, RIGHT_KEY, UP_KEY, DOWN_KEY].includes(keyPressed)) {
    event.preventDefault(); // 방향키 기본 동작 방지
  }

  if (changingDirection) return;
  changingDirection = true;

  if (keyPressed === LEFT_KEY && !goingRight) {
    dx = -snakeSize;
    dy = 0;
  } else if (keyPressed === UP_KEY && !goingDown) {
    dx = 0;
    dy = -snakeSize;
  } else if (keyPressed === RIGHT_KEY && !goingLeft) {
    dx = snakeSize;
    dy = 0;
  } else if (keyPressed === DOWN_KEY && !goingUp) {
    dx = 0;
    dy = snakeSize;
  }
}

function didGameEnd() {
  for (let i = 4; i < snake.length; i++) {
    const didCollide = snake[i].x === snake[0].x && snake[i].y === snake[0].y;
    if (didCollide) return true;
  }

  const hitLeftWall = snake[0].x < 0;
  const hitRightWall = snake[0].x > canvas.width - snakeSize;
  const hitTopWall = snake[0].y < 0;
  const hitBottomWall = snake[0].y > canvas.height - snakeSize;

  return hitLeftWall || hitRightWall || hitTopWall || hitBottomWall;
}

function getNewFoodPosition() {
  let foodX = Math.floor(Math.random() * (canvas.width / snakeSize)) * snakeSize;
  let foodY = Math.floor(Math.random() * (canvas.height / snakeSize)) * snakeSize;
  snake.forEach(part => {
    const foodIsOnSnake = part.x === foodX && part.y === foodY;
    if (foodIsOnSnake) foodX = Math.floor(Math.random() * (canvas.width / snakeSize)) * snakeSize;
    if (foodIsOnSnake) foodY = Math.floor(Math.random() * (canvas.height / snakeSize)) * snakeSize;
  });
  return {x: foodX, y: foodY};
}

function drawScore() {
  ctx.fillStyle = 'black';
  ctx.font = '16px Arial';
  ctx.fillText("Score: " + score, 8, 20);
}

main();
