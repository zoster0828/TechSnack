# Migration to modernization
* Windows VMware에서 구동되는 monolith service
* move to Amazon EC2 Windows server(rehost)
* move to Amazon EC2 Linux server(38% cost saving)
  * windows 종속성이 있었지만 비용 절감을 위해 리팩토링 진행함
* Amazon ECS Tasks(75% cost saving)
  * k8s를 운영도 하지 않고 사용하는 방법인듯
  * EKS Blueprints 라고도 부르는것 같음
  * full managed EKS

## Move to cloud native
* Mono to Micro(Loosley coupled)
* Microservices design pattern
  * leave and layer or strangler-fig

## vFunction
* https://vfunction.com/products/architectural-observability-manager/
* “By 2026, 80% of technical debt will be architectural technical debt.”
  * AI 기반의 modernization을 진행해주는 솔루션
  * cli tool 이용해서 legacy code를 자동으로 리팩토링(!?)
    * requirements를 만족했는지 확인할 수 있는가?

## Takeaways
* Modernization is incremental journey through adopting multiple pathways for value realization
* use modernization pathways to help customers answer "Where do I start, and what do I use?"
* //todo 여기 채워넣으셈