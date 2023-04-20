# Kafka

### Chat gpt가 말하는 Kafka
Apache Kafka는 고성능 데이터 파이프라인, 스트리밍 분석, 데이터 통합 및 미션 크리티컬 애플리케이션을 위해 수천 개의 회사에서 사용하는 오픈 소스 분산 이벤트 스트리밍 플랫폼입니다.

Kafka는 고성능 TCP 네트워크 프로토콜을 통해 통신하는 서버와 클라이언트로 구성된 분산 시스템입니다. 온프레미스 및 클라우드 환경의 베어메탈 하드웨어, 가상 머신 및 컨테이너에 배포할 수 있습니다.

Kafka는 다음과 같은 용도로 사용됩니다.

이벤트 스트림을 게시하고 구독합니다. Kafka는 다른 시스템에서 데이터를 지속적으로 가져오고 내보내는 것을 포함하여 이벤트 스트림을 게시하고 구독하는 데 사용할 수 있습니다.
원하는 기간 동안 지속적이고 안정적으로 이벤트 스트림을 저장합니다. Kafka는 원하는 기간 동안 지속적이고 안정적으로 이벤트 스트림을 저장할 수 있습니다.
발생 시 또는 소급하여 이벤트 스트림을 처리합니다. Kafka는 발생 시 또는 소급하여 이벤트 스트림을 처리할 수 있습니다.
Kafka는 다양한 데이터 스트리밍 문제를 해결하는 데 사용할 수 있는 강력한 도구입니다. 확장 가능하고 안정적이며 사용하기 쉽습니다. 데이터 스트리밍 요구 사항에 대한 솔루션을 찾고 있다면 Kafka가 훌륭한 옵션입니다.

다음은 Kafka 사용의 이점 중 일부입니다.

확장성: Kafka는 확장성이 뛰어나고 대량의 데이터를 처리할 수 있습니다.
신뢰성: Kafka는 신뢰성이 높고 장애를 견딜 수 있습니다.
내구성: Kafka는 데이터를 내구성 있고 안정적으로 저장합니다.
사용 용이성: Kafka는 사용하기 쉽고 다양한 시스템과 통합될 수 있습니다.
강력하고 안정적인 데이터 스트리밍 솔루션을 찾고 있다면 Kafka가 훌륭한 옵션입니다.

### Kafka란?
* 고성능 TCP network을 기반으로 구성된 분산 message queue

### Kafka의 구성
* Producer - Broker - Consumer로 구성된 pub sub 구조

### Kafka의 장점
* 확장에 용이
* 신뢰도가 높음
* 사용하기 쉬움
* 그럼에도 빠르다.

### Kafka는 어떻게 동작하나
* Kafka 내부 로직 + Zookeeper 활용하여 현재 활성화된 broker를 모니터링 하고, leader를 선출하고
broker에 이상이 발생한다면 제거하는 방식으로 유지됨.
* replication factor를 통해 replication 될 갯수를 topic 별로 지정할 수 있고, 더 많은 복제본을 가질수록
고가용성이 높아진다.
* 이미 가지고 있는 data가 매우 큰 경우 신규 broker를 붙이는것은 시간이 다소 걸릴수는 있음.
* 기본적으로 데이터를 local disk에 유지하기 때문에 file io에 영향을 받지만 Zero copy를 통해 성능을 향상시켰음.

### Partition - Replication의 동작 방식
* kafka는 여러개의 topic으로 구성되고 각 topic은 여러개의 partition으로 구성됨.
* 각 topic은 독립적인 partition / replication 갯수를 가질 수 있음.
* 5개 broker가 있고 5개의 partition 3개의 replication을 가지는 topic이 있다면
  * 각 broker는 1개씩의 leader partition을 할당 받음
  * replication은 3이기 때문에 2(*5개의 partition)개의 복제본을 추가 할당 해야함
  * 아래와 같은 형태로 할당됨 - ()안의 숫자는 broker의 number
    * topic1 partition1 : leader(1) / replication(2,3)   
    * topic1 partition2 : leader(2) / replication(3,4)
    * topic1 partition3 : leader(3) / replication(4,5)
    * topic1 partition4 : leader(4) / replication(5,1)
    * topic1 partition5 : leader(5) / replication(1,2)
  * 따라서 broker 3은 topic1의 leader partition 3과 1,2번 partition의 replication을 갖게 됨. 
  * 따라서 broker 3이 다운된다고 하더라도 3번 partition은 broker4 또는 5가 leader가 되어 유지됨

### 데이터 복구
* data는 disk에 써있기 때문에 disk가 파괴되지 않았다면 복구할 수 있다.
* system을 다시 올렸을때 broker가 자신이 돌아왔음을 cluster에 알림
* cluster는 돌아온 broker가 없었던 동안 생기거나 삭제된 offset에 대한 동기화를 시작함.
* 동기화가 완료되면 broker는 다시 cluster에 복귀하여 동작하게 됨.

### Consumer가 데이터를 읽어가는 방법
* Consumer는 kafka의 topic에 붙어서 데이터를 읽어가게됨
* topic의 partition별로 읽어가게 됨.
* 각 partition에는 group id 별로 consumer의 offset이 기록되게 됨.
* 따라서 consumer group 별로 별도의 offset을 가지고 개별로 동작함.
* pub/sub 구조이기 때문에 source는 하나지만 여러개의 consumer가 별도의 group으로 읽어갈 수 있음.
* 읽어가더라도 message가 삭제되는것은 아님.
* message의 삭제는 topic의 retention 주기를 따르게 됨.

### 순서
* queue 형태로 FIFO 입출력 이루어짐.
* 그러나 Partition별로 data가 들어가고 partition을 지정할 수 없기 때문에 
* 0~9의 message를 보냈을때 먼저 들어간 순서로 나오지만 그것으로 순서를 보장할 수 없음(대개 013246987 이런 형태로 나오게 됨)
* 해결을 위해 partition을 1개만 쓰거나 키, timestamp등을 쓰는 방법이 있으나 성능이 매우 떨어지게 됨
* 순서가 중요하다면 consumer 이후에 memory base의 queue를 하나 더 둬서 해결하는 방법이 있을 수 있음(redis와 같은)