### Introduction
* Cloud + Focus : Cloocus
* 도입시에는 뭐든지 대답해줄 것을 기대하지만, 할루시네이션으로 인한 오답을 내는 경우가 많음
### Generative AI 도입 과정
* Act 1. Generative AI 도입
  * 어떻게 할 수 있을까?
* Vertex AI Search : Google 수준의 검색 품질의 applicationd을 몇분만에 배포
* 내부의 데이터를 활용한 검색 결과를 만들고 싶다면?
* BQML 이용하여 GEN AI를 통해 모델을 만들 수 있음
  * 분석 대상 데이터가 저장된 곳에서 바로 ML을 실행하기 때문에 데이터 거버넌스 문제 해결
* 회사 데이터로 GENAI를 만들고 싶으면 fine tuning 통해서 만들어야 하는데
* fine tuning을 위한 데이터 셋이 잇다면 
  * GCP에서 제공하는 Foundation Models을 Generative AI Studio에서 튜닝할 수 있음
  * RLHF 또는 PEFT 방식
* 없다면
  * RAG 통해서 만들어야 함~
* LLM + neo4j
  * 유사도 매칭 같은 기능이 있기 때문에 사용하기 좋은 DB가 됨
  * 전처리한 데이터를 neo4j 에 넣고 자연어로 응답을 받을 수 있는 아키텍처 구성 가능
