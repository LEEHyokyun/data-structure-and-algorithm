## 1. Day4

[BFS]
- miro
  - graph, boolean
  - 제한조건 및 벽조건 반드시 생각하기
    - if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
      if(graph[nx][ny] == 0) continue;
  - 최단경로 
    - 단순 answer ++는 방문횟수
    - 최단 경로는 그래프의 이전 경로에서 누적.


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