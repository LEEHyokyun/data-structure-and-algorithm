## 1. Day1

[DP / brute force + DP]
- 퇴사 
  - 요소의 개수가 15개라서 완전탐색으로 풀 수는 있겠으나, 완벽하지는 않다.
  - 최적의 상태에서 풀려면 DP를 도출하여 푸는 것.
    - dp[i] = i일부터 시작했을 때의 최대 수익
      - 상담기간 = T[i][0], 상담보수 = T[i][1] 
        - 상담종료, 상담확보는 최대 N+1일째에.
      - 상담기간 for T, 상담보수 for P
      - dp -> i일로부터 상담시작시 얻을 수 있는 최대 보수 
        - 상담안하면 i+1 수익 = i 수익과 동일
        - 상담하면 끝나는 날에 수익 반영
- 모비스 인원 배치
  - 유형이 k개 총 상담원 수가 n
  - 각 유형 i에 x[i]명 배정 - (x[1] + x[2] + ... + x[k] = n)

```java
dp[i][j] = 
  i번째 상담 유형까지 고려했을 때
  상담원 j명을 배치한 최소 대기 시간
```
```java
dp[i][j] =
  min over x ( dp[i-1][j-x] + cost[i][x] )
```
- cost[i][x] = i번 유형에 상담원 x명을 배정했을 때 발생하는 총 대기시간

```java
for(int day = 1 ; day <= N ; day++){
dp[day + 1] = Math.max(dp[day+ 1 ], dp[day]);

int endDay = day + T[day];
            if(endDay <= N + 1){
dp[endDay] = Math.max(dp[endDay], dp[day] + P[day]); //보수 누적
            }
                    }
```

[정의/구현]

- 정의 : 주소잇기

```java
List<int[]>[] byType = new ArrayList[k + 1];
        for(int i = 1 ; i <= k ; i++){
            byType[i] = new ArrayList<>(); //정의
        }
```

- 구현 : 형태에 맞게(Integer? int[]?)

```java
for(int[] r : reqs){
            int start = r[0];
            int duration = r[1];
            int type = r[2];
            
            byType[type].add(new int[]{start, duration});
        }
```

[int 오버플러우]

static final int INF = Integer.MAX_VALUE;

오버플러우 -> 음수가능성 존재함.