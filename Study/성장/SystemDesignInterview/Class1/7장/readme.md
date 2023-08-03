# 7장 분산 시스템을 위한 유일 ID 생성기 설계
## 1단계 - 요구사항
* ID는 유일하다
* 숫자로만 구성된다
* 64비트
* 발급날짜 정렬
* 초당 1만개의 id 생성

## 2단계 - 개략적 설계
### 다중 마스터 복제
* Auto increment 사용
* db 의 수만큼 n * increment
* 규모 확장 어려움
* 추가 삭제시 중복되지 않도록 세팅 해야 함
* 발급날짜 정렬 불가능

### UUID
* 서버 간 조율 없이 만들 수 있음
* 규모 확장 쉬움
* 128비트, 요구사항 충족 못함
* 발급날짜 정렬 불가
* 숫자 아닌 값 포함

### Ticket server
* Ticket을 발급하는 서버를 두고 발급하도록
* 구현이 쉽다
  * 이걸 위해 web server를 만들어야 하는데 왜 쉬운건지?
* 티켓 서버가 SPOF가 됨

### [SNOW FLAKE](https://github.com/twitter-archive/snowflake)
* twitter에서 공개한 open source id 생성기
* 64비트로 구성
* 1비트는 sign
* 41비트는 epoch timestamp(millis)
* 5비트는 data center id
* 5비트는 server id
* 12비트는 counter
> timestamp + random string(10) + counter 사용중

## 3단계 - 상세설계
...
## 4단계 - 마무리
* NTP 통해 timestamp의 동기화를 보장해야함