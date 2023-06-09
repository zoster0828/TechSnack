# Code review

* 코드 리뷰는 작성한 코드를 베이스 브랜치에 머지하기전에 하는 행위로 개발 프로세스에서
중요한 부분
* 소프트웨어의 품질, 유지 보수 및 신뢰성을 보장하는데에 주 역할이 있음.

## 코드 리뷰가 필요한 이유
* error detection : 코드 리뷰는 초기에 버그 및 로직상 오류등을 파악할 수 있도록 한다. 
  * 여러 사람이 리뷰할수록 문제를 발견할 가능성이 높아짐.  
* quality assurance : 코드가 개발팀 내에서 정한 코딩 컨벤션을 준수하는지 확인한다. 
일관성을 지킬 수 있도록 하며 전반적인 품질 향상에 기여한다.
* maintaining codebase integrity : 베이스 브랜치가 시간이 지나더라도 무결한 상태를 유지하는 데 도움이 됨. 
  * error detection을 통해 기술 부채의 축적을 방지함

## 커뮤니케이션 측면에서 
* discussion and feedback : 팀원 간의 토론을 촉진한다. 리뷰어는 피드백을 제공하고 질문함으로써 개선 사항을 제안할 수 있음
* mentorship and learning opportunities : 팀 내 멘토링 기회를 제공한다. senior는 리뷰를 통해 피드백함으로써 모범 사례를 공유하고
junior를 멘토링할 수 있게 됨.
* building trust and accountability : 팀을 투명하고 책임감 있는 환경으로 만든다. 코드 리뷰는 서로의 작업을 리뷰하고
품질과 정확도를 확인할 수 있으므로 구성원 간 신뢰를 구축하는데 도움이 됨.
* knowledge sharing / learning : 개발자가 서로에게서 배울 수 있는 기회를 제공한다. 다른 사람의 코드를 검토함으로써 다양한 접근 방식 및 기술 패턴에 대한 통찰력을 얻는다.
  * 팀내 지식 공유를 자연스럽게 촉진하게 됨.
* peer feedback and collaboration : 개발팀 내에서 공동 작업 및 팀웤을 장려함. 리뷰어는 양질의 피드백을 제공하고 개선 사항을 제안하며 대체할 솔류션을 제공함.
    * 코드를 개선하는 데 도움이 될 뿐 아니라 지속적인 개선을 위한 문화를 만들어냄

## 그래서
* 코드 리뷰는 개발팀에서 오류를 잡거나 코드의 품질을 향상 시킬뿐 아니라 커뮤니케이션을 위한 협업 도구 역할을 함.
* 리뷰를 통한 커뮤니케이션은 쉽고 빠른 방법
* 위에서 열거된 코드리뷰의 장점을 거꾸로 읽어보면 코드 리뷰를 안 하는 팀은
  * 에러를 조기에 발견하지 못하고
  * 코드가 일관성 없이 작성한 사람에 따라 다른 스타일로 만들어지며
  * 베이스 브랜치는 시간이 지날수록 기술 부채가 쌓여가게 됨
  * 공동 작업이 어려워질뿐 아니라
  * 팀원간의 토론이 줄어들 것
  * 멘토링은 다른 방법을 이용해 진행해야 하고
  * 불투명하고 서로간의 신뢰를 구축하기 어려움
# 코드 리뷰를 잘하자.