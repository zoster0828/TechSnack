# db solution
* 주로 많이 쓰는 DB는 MYSQL이다.
  * NOSQL은 잘 안씀
* K8S 에서는 수직적 확장이 어렵지 않음
* 주문에는 SUMMARY가 들어있다.
  * 쿠폰, 주소, 적립금.. 등등 여러가지 
* 커머스 도메인에는 쓰기는 거의 없음
  * 대부분은 READ
* MYSQL을 쓰면서도 NOSQL적인 생각을 못 버린것은 아닐까?
* @Transactional(readOnly = true) 인 경우 read db로 붙도록 설정 할 수 있음
* 캐시 만료 숫자 소수로 잡아야 동시에 만료되지 않도록 할 수 있음
  * 만료가 겹치면 동시에 DB에 몰려 들어가게 됨
* INBOX OUTBOX 패턴
  * 