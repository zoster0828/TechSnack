> 이 세션은 recap에서 이해 못한 부분을 다시 채워넣어야 함

## 왜 마이크로 서비스를 해야 되는가
?
## Techincal Problems
* Monolicthic codebase - difficult to change, hard to test
* Tight coupling, no separtation of concerns 
* Techincal debt and performance issues
* maintenance difficulties
* data tier complexities and lots of undifferencetiated heavy things

## Characteristics of microservices
* databases are hidden inside the service boundary
* Principles of information hiding
* communicate with each other via networks
* Independently deployable services that work together, modeled around a business domain.


## Why refactor to microservices
* Reduced deployment scope of impact
* Functional autonomy, single responsibility
* Increased development velocity
* Focused scalability
* Service separation by business function - domain-driven design

## That sounds great, but ...
* It takes too long
* It's too expensive
* I dont have the AWS knowledge
* I have to change my organization first

* Launch a new feature, fast
* Refactor incrementally
* Refactor an application's account structure first

## Modernize with the strangler fig pattern
### Benefits
* Agility
* Frequent release
* Lowers risk
* Immediate benefits
* Easier rollback
> how to determine we are ready to change

## Refactor Spaces
* Aws transit gateway 통해서 구 accoutn에 있는 monolith instance에서
* 신규 account에 있는 application으로 방향을 틀어서 strangler fig 패턴을 적용한다

## Customer story - Affinidi
* decentralized identity
* Holistic identity for developers
* Monlith로 시작해서 가치를 빠르게 증명하고 refactor to microservice
* Serverless microserivice라는데 무슨 의미인지 확인 필요함
  https://www.affinidi.com/developer
* 그래서 어떤 business 가치를 얻었는가
  * sde 50% 효율 증가
  * lead time new service 가 1주에서 10분?
  * 비용적 이익
> business 가치를 만들어 낼 수 있는가가 중요, lead time도 중요한 가치다
> 어떻게 측정할 수 있을까
### idea
* prx에서 틀지 않고 transit gateway 같은걸 이용해서 gpds를 redirection 할 수 있을것 같다
* + lambda
* POST /A body a -> /B body a'