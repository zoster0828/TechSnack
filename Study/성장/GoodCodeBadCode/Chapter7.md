# 7. 코드를 오용하기 어렵게 만들라
* 비합리적이거나 애매한 가정에 기반해서 작성되거나 잘못 사용 하는것을 막지 못하면 오용되기 쉽다.
  * 잘못된 input
  * 부수 효과
  * 함수의 순서
  * 가정과 맞지 않는 수정
* 사용하기는 쉽고 오용하기는 어려워야 한다
### 7.1 불변 객체로 만드는 것을 고려하라
* 가변 객체는 값을 예상하기 어렵다
* 가변 객체는 다중 스레드에서 문제가 발생할 수 있다
### 7.1.1 가변 클래스는 오용하기 쉽다
### 7.1.2 해결책: 객체를 생성할 때만 값을 할당하라
* setter 함수는 잘못 사용하기 쉽다
> test를 위한 setter는 허용되어야 하는지?
> reflection을 통한 해결?

### 7.1.3 해결책: 불변성에 대한 디자인 패턴을 사용하라
* @Builder
* copy on write
  * > 예상하기 어려운 함수 사용법 아닌가?
### 7.2 객체를 깊은 수준까지 불변적으로 만드는 것을 고려하라
* deep mutability
### 7.2.1 깊은 가변성은 오용을 초래할 수 있다
* List<Enum> 
### 7.2.2 해결책: 방어적으로 복사하라
* get을 List 복사를 통해 반환
  * 복사의 비용 발생하는 문제가 있음
  * 복사가 완전한 불변성 보장을 하는 것은 아니다
### 7.2.3 해결책: 불변적 자료구조를 사용하라
* Guava의 ImmutableList와 같은 list 불변 라이브러리 사용

### 7.3 지나치게 일반적인 데이터 유형을 피하라
* primitive 타입 사용을 자제하자
### 7.3.1 지나치게 일반적인 유형은 오용될 수 있다
* List<List<Double>> 로 위도 경도 표시는 갯수 보장이나 위치 보장이 안됨
* 이러한 패러다임은 쉽게 전파된다
### 7.3.2 페어 유형은 오용하기 쉽다
* List<Pair<Left, Right>> 도 마찬가지로 위치를 헷갈릴 수 있다
* 가독성이 낮다
### 7.3.3 해결책: 전용 유형 사용
* lat long 객체를 만들어서 사용하여 오용을 방지한다
> Domain 객체의 모든 값을 객체로 만들어서 사용하는 경우 너무 많은 작업이 필요하지 않은지
### 7.4 시간 처리
* 시간을 다룰 때 혼동하고 잘못 사용할 여지가 많다
### 7.4.1 정수로 시간을 나타내는 것은 문제가 될 수 ㅣㅇㅆ다
* 일반적으로 unix의 epoch을 long 으로 많이 사용함
* 시간의 양인지, 어떤 시간을 가르키는지 애매할때가 있음
* 단위가 애매함
* > 일반적으로 time_millis, time_seconds와 같은 형태로 사용하기도 함
* UTC GMT9 등의 기준 표현의 애매함
### 7.4.2 해결책: 적절한 자료구조를 사용하라
* Library 사용하여 Instant와 Duration등의 클래스를 사용하여 명확히 구분한다
* 단위의 표현도 제공
* 시간대의 처리에 대한 것도 제공
> Library 일반적으로 잘 사용하지 않으며, 시간대는 UTC로 기본 통일, KR인 경우를 예외적으로 표현 하는 편
> Instant는 거의 사용하지 않으며 기본은 Duration, Instant인 경우 명확하게 표기
> 단위는 variable 명으로 표현

### 7.5 데이터에 대해 진실의 원천을(source of truth) 하나만 가져야 한다
### 7.5.1 또 다른 진실의 원천은 유효하지 않은 상태를 초래할 수 있다
### 7.5.2 해결책 : 기본 데이터를 유일한 진실의 원천으로 사용하라
* 계산이 필요한 경우 클래스 내부에서 기본 데이터를 가지고 계산하자
* 데이터 계산 비용이 크다면 캐싱하자

### 7.6 논리에 대한 진실의 원천을 하나만 가져야 한다
### 7.6.1 논리에 대한 진실의 원천이 여러 개 있으면 버그를 유발할 수 있다
* 직렬화 역직렬화가 두개의 클래스에 있다면 다른 형태로 변환될 수 있다
### 7.6.2 해결책: 진실의 원천은 단 하나만 있어야 한다
* 클래스 하나에 모아놓자