## 1. Day4

[BFS/Binary Search]
- miro
  - graph, boolean
  - 제한조건 및 벽조건 반드시 생각하기
    - if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
      if(graph[nx][ny] == 0) continue;
  - 최단경로 
    - 단순 answer ++는 방문횟수
    - 최단 경로는 그래프의 이전 경로에서 누적.

- 인출의 의미?
  - 한번 인출해서 얼마나 많이 사용할 수 있는가. 오래 사용할 수 있는가.
    - 인출을 최소화하여 사용할 수 있는가.
      - K가 작을수록 → 자주 인출 → 인출 횟수 커짐
      - K가 클수록 → 덜 인출 → 인출 횟수 작아짐
        - 전형적인 이분탐색
          - 최초시작값 = left = Math.max(left, days[i]);              //용돈 최소값 = 최대값
            최대값 = right = right + days[i];                     //용돈 최대값 = 모든 용돈의 합

- 이분탐색의 또다른 생각해야 할 점
  - "단조"의 최소값과 최대값
    - 인출 -> 가장 큰 값 ~ 모든 값을 더한 값
    - 입국 -> 최소값 = 1시간, 최대값 * n명시간 ("처리가능한 사람")
      - 처리가능한 사람의 수 >= n -> true

```scss
처음에 K원 인출
↓
하루하루 쓰다가
↓
잔액 < 오늘 쓸 돈 이면
→ 다시 K원 인출 (인출 횟수 +1)
```

[graph 입력]

- ASIS

```java
for(int i = 0 ; i < N ; i++){
            String miro = br.readLine();
            for(int j = 0 ; j < M ; j++){     
                graph[i][j] = Integer.parseInt(String.valueOf(miro.charAt(j)));
            }
        }
```

- TOBE

[chatAt - '0'으로 바로 int형으로]

```java
for (int i = 0; i < N; i++) {
String line = br.readLine();
    for (int j = 0; j < M; j++) {
graph[i][j] = line.charAt(j) - '0';
        }
        }

```

[br.readLine().toCharArray를 char[]배열에 저장해두고 row[i] - '0' 활용]

```java
for (int i = 0; i < N; i++) {
    char[] row = br.readLine().toCharArray();
    for (int j = 0; j < M; j++) {
        graph[i][j] = row[j] - '0';
    }
}

```