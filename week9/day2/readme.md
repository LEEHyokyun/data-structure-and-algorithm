## 1. Day2

[DP]

- 사탕
  - 최적화 경로 ? DP
    > 합산의 최대? -> 정방향이 아닌 "역방향"을 고려하라.
      - DFS로 이동, 각 개수 누적 및 max 비교하기, DP를 통한 최적화!
        - BFS + visited -> 더 좋은 경로가 나오면 최적화 경로 추출이 불가능하다.
        - 반드시 DFS로 진행해야 최적화 경로 추적이 가능!
      - 출발점은 항상 0,0으로 고정, 순환 BFS를 통한 완전탐색은 하지 않아도 무방하다.
      - queue 넣기전에 유효성 검증 누락하지 말기
        - if(visited[x][y]) continue;
          if(x < 0 || y < 0 || x >= N || y >= M) continue;
      - 정방향이 아니라 역방향..
        - 역방향, 이미 합산한 상태를 가정하고, 이 이전방향(위/왼쪽/대각선위)의 최대 값을 pick
        - 정방향 pick? 보장불가. 역방향 pick? 보장가능.

[삼항연산 -> if 필요없이 조건문 괄호 배치 및 삼항연산배치]

- (condition) ? X : Y;

```java
int up = (i > 0 )? graph[i-1][j] : 0;
                int left = (j > 0 )? graph[i][j-1] : 0; 
                int upLeft = (i > 0 && j > 0 )? graph[i-1][j-1] : 0;
```

[N,M 크기를 보았을때 힌트]

- N, M = 1000? -> 이중 탐색을 통한 DP OK.

[ArrayIndexOutOfRange]

- graph[x][y]에서 x,y가 범위 밖의 인덱스일경우
- 검증순서 중요함
  - if(visited[x][y]) continue;
    if(x < 0 || y < 0 || x >= N || y >= M) continue; -> 범위체크를 먼저 해야한다.
  - if(x < 0 || y < 0 || x >= N || y >= M) continue;
    if(visited[x][y]) continue;   -> 범위체크 먼저 하고 그 다음에 방문여부 체크
    
