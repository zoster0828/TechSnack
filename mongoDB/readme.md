# MongoDB
* document model
  * schemaless?
  * json 형태로 저장
  * ? json이라서 ui의 데이터가 그대로 db에 들어갈 수 있다?
    * json 이기 때문에 depth를 가질 수 있음
  * row에 field명 포함됨
    * dynamo와 동일하지 않은지?
  * 데이터 티어링 가능함
    * hot / cold
    * managed 기능인듯
  * cursor의 페이징 처리
    * 원하는 갯수의 listing의 처리를 페이징 단위로 수행할 수 있다.
      * 페이지이 끝인지는 어떻게 알지?
  * sql의 where절은 구의 구현돼있음

## managed에는 shard 구성 등도 해줌
## atlas shape
* serverless
* cloud 벤더간 데이터 이동시 별도의 조치 필요 없음
* downtime 없이 scailing 가능
* atlas cloud가 따로 있고 우리 계정을 거기에 붙이는게 아니고 atlas에 aws base로 만들더라도 다른 vpc에 생성되고 거기에 대한 peering 제공
* replication 정책 kafk와 유사

## embedding
* usr 1:N car
  * car를 여러명이 소유한 경우 데이터 중복
  * 조인 없이 usr에서 car도 꺼낼 수 있음
  * car만 꺼낼순 없음
* extended reference pattern
  * task - user (region)에 사용하기 좋아보임
## index
* Compound index는 순서가 중요
  * cassandra와 동일
* query에 대한 index hit율과 같은 것들도 모니터링 가능
  * managed 에서만 가능한 건지 확인 필요
## aggr
* bucket이라는 이름의 window 기능이 있음


---
* cassandra 상위호환, 완성형
* 운영, 통계 위한 많은 기능이 제공
* 운영에 대한 manual한 처리들이 필요
* 자잘한 편의기능들이 많은듯
* json으로 인한 depth 가질 수 있는것이 dynamo와의 가장 큰 차별점
* 비용 이점
  * rds m7.large 기준 0.337 USD
  * atlas 0.1 USD -? 이게 어느정도 크긴지 모르겠음
---
* 데이터 사이즈가 거대한 클러스터에 새로운 노드 추가시 예상 시간
* 문제 있을 수 있는 거대 쿼리 들어왔을 시 클러스터 보호 가능한지
