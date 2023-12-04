# Warhammer

* 백엔드팀이 없었고 멀티 플레이어 게임을 만들기 위해서 해야 하는 일들이 있었음
## 요구사항
* Server authoritative game to avoid players being able to disrupt the quality of other people;s games
* First game launch on AWS needs to be cost effective
* Mass join of new players shold ..

## The challenge
* Big game launch, dedicated servers suport 4 players per vCPU
* Challenging to predict number of actual players at launch, necessitating scalabitlity
* peak traffic within the first few hours of release

### Solving the unpredicatable traffic chanllenge
* Architecture 는 갑작기 2배 이상 증가하는 traffic을 따라 잡을 수 있어야 함
* 거기에 필요한 요구사항이 3가지가 있음
* Implement rate control for players
* Rate control must be capable of burst scailing
* Provide infromation on how many players are actively trying to play

### Player journey
* Login -> Prologue -> Hub -> Match-making -> Mission
* Mission -> Hub infinitely

## Login and authentication
* Client -> Cloud front -> Lambda function -> Service API* 
* login에 대한 영역을 자유롭게 확장할 수 있음

## Messaging

## Good to know: Session-based dedicated game servers
* EC2 하나에서 게임 서버 프로세스를 별도로 돌릴 때

## Latency calculation and matchmaking
* Client -> AWS Fargate : UDP
* Client -> AWS Global Accelerator
* AWS Global Accelerator -> AWS Fargate
* message가 유실될 경우를 대비해 짧은 시간 dynamo db에 저장

## Results and next steps for Fatshark
* Always design for scaling
* Serverless by defaut
* Technical service boundaries
* Cost is tied to architecture
* Jitter(?)
> Lambda에 대한 사용이 아주 많은데, 어떤 용도로 쓸 수 있는지 알아보면 좋을듯
> 생산성에 큰 도움이 되는듯함
> 
> Queue processor : AWS Fargate
> 
> cache에 대한 비상용 dynamo db
> 
> Observability가 key이다. 보이지 않는 것은 고칠 수 없음
> 
> 소규모 팀이라면 aws의 managed service를 적극적으로 사용할 필요가 있음
> 
> aws에 게임을 위한 solution도 많이 있음
