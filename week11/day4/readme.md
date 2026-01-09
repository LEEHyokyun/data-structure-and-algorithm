[day4]

[Binary Search]

- 나무자르기
  - 기존의 개념을 바로잡자.
  - mid는 해를 도출하는 판단 기준일 뿐, 그 이상 그이하도 아니다.
  - 최종 max 자체가 마지막 조건을 거쳐, 최종 가공된 해이다.

| 변수    | 의미                 |
| ----- |--------------------|
| `max` | 조건을 만족하는 최대 높이 (해) |
| `min` | 조건을 처음으로 깨는 높이     |

- 징검다리
  - 판단기준 세우기
  - 중요한건, mid, max의 차이를 정확히 이해하는 것.
    - mid가 target ? -> mid 기준
    - mid가 범위탐색을 위한 기준, 해의 상한선 ? -> max 기준
  - 징검다리 조건 : s - mid <= 0 -> 0일때도 못건넌다? (X) 0일때도 포함해야 한다.
    - 3이라면, 건널 수 있는 사람의 수는 1,2,3명, 즉 0까지도 포함됨
    - 못건너는 경우의 수는 그 이후부터, 즉 0보다 작을때부터이다.

[int > long]

해가 충분히 커질 상황이라면 계산 형태를 int가 아닌 long으로 고려


```java
long heights = 0;
            
            for(int i = 0 ; i < N ; i++){
                if(trees[i] > cur) heights += trees[i] - cur;
```

[MOD]

해가 충분히 클때, 계산 시, 계산 후 모두 MOD 처리

```java
long an = a1 % MOD + a2 % MOD;
return an % MOD
```

[연속된 0의 돌 개수를 판단하는 구현방안]

```java
for(int s : stones){
    if(s - n <= 0) cnt ++, if(cnt >= k) return false
    else cnt = 0     
        }
```

단순히 0이하의 경우에만 cnt++ 하다가 0초과 만나면 cnt = 0 초기화..
단순하게 생각하자.

