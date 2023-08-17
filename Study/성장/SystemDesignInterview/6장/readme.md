# 6장 키-값 저장소 설계
* Key - value store
* dynamo, memcached, redis

## 문제 이해 및 설계 범위 확정
* 키-값 쌍의 크기는 10KB 이하
* 큰 데이터도 저장 가능
* 고가용성
* 쉬운 확장
* CONSISTENCY 조정 가능
* 짧은 latency

## 단일 서버 키-값 저장소
* 메모리에 올리는 것
  * hashmap
* 메모리 부족을 개선하기 위한 방법
  * 압축
  * 일부만 memory에 나머지는 디스크에

## 분산 키-값 저장소
* 분산 해시 테이블
### CAP 정리
* consistency,, availability, partition tolerance를 만족하는 시스템을 설계하는 것은 불가능하다
* 데이터 일관성 : 어느 노드에 접근하든지 같은 데이터
* 가용성 : 일부에 장애가 있어도 전체는 동작한다
* 파티션 감내 : 네트워크에 파티션이 생기더라도 시스템은 동작한다
* 두가지를 충족하면 한가지는 반드시 희생됨

* 이상적으로는 네트워크는 파티션 되지 않고 데이터는 잘 복제되어 일관성과 가용성 모두 만족
* 일부 파티션에 문제가 생기면
  * 일관성과 가용성 중 하나를 선택한다
  * N3가 죽었다면 N3에 있는 데이터가 N1,N2로 복제되지 않았을 경우 오래된 사본을 갖고 있게 된다
  * 가용성을 희생한다면
    * N1/N2에 대해 쓰기 연산을 중단한다
  * 일관성을 희생한다면
    * 읽기 연산을 허용하고 N1/N2 에 쓰기도 허용한다, 데이터는 일관성이 깨졌지만 시스템에는 문제가 없다

## 시스템 컴포넌트
### 데이터 파티션
* 전체 데이터를 한대 서버에 넣는것은 불가능, 데이터를 여러개의 파티션으로 분할 저장한다
  * 데이터를 고르게 분산할 수 있는가
  * 노드가 추가 삭제될 때 데이터의 이동을 최소화할 수 있는지
  * 예제에는 없지만 KAFKA의 파티션 전략도 해시링으로 보임
    * 초기에는 해시 테이블이었으나, 해시링으로 변경한듯
### 데이터 다중화
* 가용성을 위해 REPLICATION이 필요(일반적으로 3, S3는 6이라고 함)
* 가상 노드로 인해 중복된 물리서버에 저장되지 않도록 해야 함

### 데이터 일관성
* REPLICATION된 데이터는 동기화가 되어야 함
  * Quorum consensus 이용하여 읽기 쓰기 연산에 일관성을 보장한다
  * W 쓰기 연산에 필요한 정족수
  * R 읽기 연산에 대한 정족수
  * N이 3이면 
  * 일관성 중시인 경우 보통 W는 2(2대의 서버에 쓰여야 함), R도 2
  * 읽기가 많은 경우 W2 R1
* Strong consistency : 항상 정확한 데이터를 응답
* weak consistency : 읽기가 부정확할 수 있음
* eventual consistency : 최종적으로만 동기화

* Strong은 비싸고 느림, eventual은 싸고 빠름
  * 최악의 경우 dynamo에서 15분까지 데이터 지연을 본 적 있음
* 버저닝
  * conflict 났을 경우 어떻게 할 것인가?
* 벡터 시계
  * 3 way merge를 클라이언트에서 수행 
  * 아마존 ddb 그런적 없음, 동시에 발생해야 하므로
    * https://www.allthingsdistributed.com/files/amazon-dynamo-sosp2007.pdf

### 장애 처리
* heart beat 이용
> * spring actuator는 mysql과 같은 뒷단의 다른 물려있는 서버의 상태도 같이 체크 하기 때문에 안 쓰는게 어떨까란 얘기를 들엇다.
>   * 그런데 mysql까지 붙은게 서버의 정상 상태로 봐야 되는것 아닐까?
>   * 일리가 있는데 mysql이 서버 전체의 장애랑 상관 없는 시스템인 경우에도 에러가 발생하면 안되지 않나?
>   * 만약 로깅 db라면.. 서버가 살아있는데 autoscailing 됐다.
>   * 그런데 요란하게 실패하는게 더 낫지 않을까요? 어쨌든 문제를 알 수 있는 포인트 아닐까
>   * 웹서버라면 사용자 입장에서 하얀 화면을 보게될수도 있다
>   * 상황에 따라 적용하는게 좋겠다.

---
* [rate limit 관련 링크가 있어 공유드립니다~](https://www.mimul.com/blog/about-rate-limit-algorithm/)
* [redis의 lua script 활용](https://dev.gmarket.com/69)
* [[우아한테크토크] 엔드게임 이벤트 긴급 대응기 개발자 어!셈블?](https://youtu.be/uWcn7omddxs)
* [spring cloud gatway 처리율 제한 글입니다~](https://spring.io/blog/2021/04/05/api-rate-limiting-with-spring-cloud-gateway)
* [우아한테크세미나 191121 우아한레디스 by 강대명님](https://youtu.be/mPB2CZiAkKM)
* [Production-ready Features](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints.health.auto-configured-health-indicators)
* [애플 한 주가 고객에게 전달 되기까지]( https://toss.im/slash-22/sessions/2-7)
* [CRDT VS OT](https://channel.io/ko/blog/crdt_vs_ot)
* [머클 트리의 구조와 용도](https://www.lesstif.com/security/merkle-tree-125305097.html)