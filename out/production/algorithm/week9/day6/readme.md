## 1. Day6

[BFS]

- 주어진 두 점, 한 점을 이동시킬때 두 점이 만나는 가장 빠른 시간과 그 경로의 개수
  - 점이 10만 이내, 모든 경로를 찾는 DFS가 아니다.
  - 최단시간, 그 경로의 개수 = BFS
    - 최단 ? -> 거의 BFS라 간주하자.
  - DFS 시도 시 stackoverflow 발생함.
  - 2차원 BFS가 아닌, 1차원 BFS.
    - Queue<int[]>가 아닌 Queue<Integer> 이 차이.
    - 이외는 동일.
  - 최초 방문과 최단 시간에 따른 방문 분기를 나누는 것이 중요
    - 최초 방문 : dist[K] == -1    (K : 0 ~ 10만) .. dist갯수 -> 10만 + 1
    - 동일 시간 방문 : dist[K] == dist[cur] + 1, 이에 따른 경로갯수(way)도 증가
      - 그 target인 dist / ways가 K일때의 값을 보면 된다.
      - BFS이기에 방문 시 최소시간은 보장가능.
        - 겹쳤을때 ways += ways[cur], 겹치지 않았다면 ways = ways[cur]

- 단어변환
  - "최소" 몇 번 = BFS
    - 구성 아이디어
      - 방문 : boolean[] visited
      - 인접단어 : Queue<String>
      - depth : Queue<Integer> -> 이게 핵심

[for 반복문에서 배열 자체를 new int[]{}로 두고 순회하는 방법도 존재]

```java
for(int next : new int[]{cur -1, cur +1, cur * 2}){
        ...
        }
```

[방문여부를 -1,1 등으로 구성하는 방법도 존재]

```java
int[] dist = new int[MAX+1];
Arrays.fill(dist, -1);
```