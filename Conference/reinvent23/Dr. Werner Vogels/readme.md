* 관측 가능한 경우와 그렇지 않은 경우의 비용을 낮추는데 큰 차이가 있음
* cost/request를 계산하고 줄이기 우한 노력을 해야 함
* latency를 단순히 줄이는게 이익을 가져다 주는지 고민해 봐야함
* Know your costs
  * AWS management console upgrade - myapplication
* define your meter
  * Unobserved systems lead to unknown costs
* Cost-Aware architectures implements 
* Tunable architecture
  * like an evolutionary architecture
* 비용의 대부분은 network에서 발생하고 42% -> 27% 로 줄일 수 있음????
* 이것은 continuously optimize 되어야 함
  * We've always done it this way
    * f**k off
  * 비용과 지속 가능성을 고려하면 RUST 써라 ㅡㅡ...;;
  * 개발 생산성이 운영 비용보다 높은게 맞는지 확인해라
  * http://thefrugalarchitect.com

> 결론은 비용을 최적화하고, 비즈니스와 일치 시키기 위해 노력해야 한다, 그걸 위해서는 관측이 가능해야 한다.