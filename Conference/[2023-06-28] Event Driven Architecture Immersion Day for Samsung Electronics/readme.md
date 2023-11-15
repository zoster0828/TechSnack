https://yeonuklim.notion.site/2023-06-28-Event-Driven-Architecture-Immersion-Day-for-Samsung-Electronics-fb7c1f9fd08e43ef902ce08ff1fba467


* 하나로 커플링 된 시스템 분리 어려움
  * task | ticket 분리?

# 질문
* Kafka를 이미 구축해서 사용하고 있는데 sqs를 써야 하는 이유가 있는지?
  * message 단위 과금으로 메시지가 작은 경우 kafka (5)를 구축하고 운영하는 비용을 사용하지 않을 수 있음
* sqs와 eventbridge가 똑같은거 아닌가?
  * ~~consume 하는 것이 아닌가?~~
  * 메시지가 복제되어 나갈 수 있음
  * kafka의 consumer group 개념이 rule로 작동할 수 있음
* ochestration / queue base의 차이는 flow를 ochestrationdㅔ 줄 것이냐 각각의 application의 결합을 통해 이해할 것이냐
  * ochestration tool이 spof가 되지 않나?
    * 맞는데 고가용성이 높고, 도메인 베이스에서만 사용하길 권장 전체로 확대는 하지말자
* kinesis의 고가용성은 kafka replication factor 3 과 같음
* EventBridge -> SQS



ApiUrl	https://4fowhn05y8.execute-api.us-west-2.amazonaws.com/Prod/	API Gateway endpoint URL	-
CognitoPassword	C3LGwqsDwy9LCzEODJWLSn9qncbc9vq8	Event Generator password for use with Event Generator and Wild Rydes SaaS Playground	-
CognitoUsername	user	Cognito username for use with Event Generator and Wild Rydes SaaS Playground	-
EventGeneratorConfigurationUrl	http://event-generator.awsworkshops.io/#/?userPoolId=us-west-2_F6YNraVUY&appClientId=bbb8q2nlu7h8msvifbbv85q8o&cognitoIdentityPoolId=us-west-2:4751eb18-7507-4706-955b-2c97d9eee673	Event Generator configuration link	-
WildRydesSaasPlaygroundConfigurationUrl	http://saas.wildrydes.com/#/?userPoolId=us-west-2_F6YNraVUY&appClientId=bbb8q2nlu7h8msvifbbv85q8o&cognitoIdentityPoolId=us-west-2:6bd247be-8d9b-4f60-afab-2275f4edb6a9	Wild Rydes Saas Playground configuration link

arn:aws:sns:us-west-2:559629930400:Orders:ece52f83-1ef6-4a1c-93a0-8d9c6f8656cc
arn:aws:sns:us-west-2:559629930400:Orders
arn:aws:sqs:us-west-2:559629930400:OrdeersTopicDLQ