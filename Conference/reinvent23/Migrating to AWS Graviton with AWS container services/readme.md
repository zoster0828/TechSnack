# Pod to Graviton
* Graviton cost up to 20 % less than others
* uses up to 60% less eneergy than others
* Containers on graviton run your way. any ohter types
* k8s 에 올리게 되면서 graviton을 안 쓸 이유가 딱히 없지 않나?
  * > 운영팀에 한번 물어보면 좋을것 같음
* > build를 emulate 해야 되는건 조금 단점인듯
* > devops 코드가  Hardware에 dependency가 생기는것 아닌가?
  * flexible deployment가 가능함
  * build코드에 생기긴 하지만, multiple로 많은것 중 하나가 추가되는 개념
  * build를 여러번 해야 되는건 좀 단점이긴 한듯
* 원래 모든 dodkcer resgitry에서 multi architecture는 지원하고 있고 별도의 문제는 없음
* > 그런데 k8s를 옮긴다면 그 동안 설정한 security 같은건 어떻게 하지? migration 할 수 있나?
  > 다른 cluster로의 전환을 k8s에서 제공하는 기능인가
  > 
  > A: graviton을 node 자체에 포함 시키고 selector 통해서 node를 고르라는 의미
  > 이건 좀...최소한 자동으로 되는지?
  > eks의 경우 autoscailing 개념도 일반적이지 않은데, 그만큼의 비용 절약이 의미가 있는지
  > 
  > 예를들면 많이 쓰는 곳에서는 graviton 인스턴스를 그만큼 확보할 수 있는지
  > 
  > 반대로 적게 쓰는 곳에서는 굳이 graviton을 쓸 필요 있는지?
* ServiceBiz 팀에서 Graviton cluster로 모두 변경 했는데
  * 얻은 비즈니스 가치
    * 15 % cost savings
    * improved API server response latency P90이 48.2% 감소했다고 함
      * > ? what it is