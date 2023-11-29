# Coinbase: Building an ultra-low-latency crypto exchange on AWS

## why does latency matter?
* latency가 다르면 시장 참여자가 unfair 하게 됨

## Low-latency applications in the cloud
* light speed to moving 150 miles

## Exhange와 같은 빠른 latency를 필요로 하는 경우
* m5zn : networking-optimized
* R7iz : memory optimized
* z1d : instance store volumes - coinbase use this

## Amazon EC2 cluster placement groups
* AZ 달라지면 latency가 늘어남
* cluter placement group 통해서 보완할 수 있음

## Round-trip latency
* p99가 under 1ms


## Environments
* Personal dev env
* UAT: Integration testing

dev

---
prod

* UAT : Sandbox
* UAT : Shadow production
  * Production traffic mirror
  * Ghost stack
* Production

## Production environment design
* Performance
  * Capacity planning
    * 처리 시간이 network 지연에 depend 되어서 단일 az에 전부 다 배포 했었음
    * cluster placement group을 쓰면 여기서 자유로울 수 있음(?)
  * 짧은 latency를 위해 os level의 조정이 필요함 , 여기 사용하는 여러가지 기술이 있음
* Reliability
  * DR considerations
    * az를 단순히 나누면 느려지므로
      * request의 일부를 복제하여 다른 regiond으로 보냄 (?)
        * 뭔지 알것 같은데 명확하지 않음
* Security


> FIX, HTTP에서 FIX가 뭐지?
> 
> Raft cluster는 뭔가
> 
> 결국 아키텍처는 어떤 문제를 해결하기 위한 것이고, 그걸 해결하기 위한 가장 좋은 방법을 찾아야 함
> 
> data를 stream으로 보내는것과 archive로 보내는것이 있고
>
> real-time에서 stream으로 받은것 중 일부가 안보일 수 있지만
> 
> eventually consistency를 제공함(fill from archive data)
> 
> shadow production 좋아보임
> 
> 