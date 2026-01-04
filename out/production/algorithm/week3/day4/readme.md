## 1. Day4

[BFS/DFS]
- Implements : 배운점
  - key point : 2차원 배열이 아닌 1차원 배열로만 문제조건이 주어졌을때 연결정보를 표현하는 방법
    = arrayList가 요소인 배열
    = static ArrayList<Integer>[] graph;
  - 최초 시작점은 제외한 나머지 인접노드의 개수를 파악하는 것이다.
    - 최초 count = 0 , dfs 진입했을때 count++
  - 잊지말기..Queue의 구현체는 LinkedList.
  - BFS? for, DFS? recursion.
    - 자료구조도 중요하지만 본질에 접근하자.
- Improvements : 막혔던 지점 / 고민한 포인트
  - 이번 문제를 풀때 유의할 점은 count의 초기화와 누적(단지의 시작점에서 count 초기화 후 다시 시작!) 
    - 최초 시작지점은 count = 0으로 초기화해준다. 누적하면 안된다.
      count = 0;
      DFS(i, j , N);
  - String -> int
    - map[i][j] = line.charAt(j) - '0';
  - 항상 느끼는 것이지만 기본적인 static 사용방법은 익숙해질 필요가 있다.
    - 전역변수가 있으면 애초에 매개변수를 전달할 필요가 없다.
    - static boolean[] visited;
      static ArrayList<Integer>[] graph;
      static int count = 0;
    - 이후 반드시 초기화 필요하다.
      - graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
      - graph[u].add(v);
        graph[v].add(u);
    - 인접노드 방문은 for 순회
      - for(int next : graph[start])
    - 깊이 파고들때는 재귀순회
      - Stack이 아니더라도 방문/다음 인접노드를 방문하도록 재귀순회하면 가능
- Additional : 추가적인 유의점들

| 기준       | DFS                        | BFS            |
| -------- | -------------------------- | -------------- |
| 구현 난이도   | 재귀로 간단                     | 큐로 구현          |
| 방문 순서    | 깊이 우선 → 한 경로 끝까지 탐색 후 다음   | 너비 우선 → 레벨별 탐색 |
| 시간복잡도    | O(V+E)                     | O(V+E)         |
| 메모리      | 재귀 스택                      | 큐 사용           |
| 이 문제 적합성 | ✔ 둘 다 가능, 노드 개수가 작아서 재귀 가능 | ✔ 둘 다 가능       |


| 항목          | DFS             | BFS              |
| ----------- | --------------- | ---------------- |
| 구현          | 재귀              | 큐 사용             |
| 방문 순서       | 깊이 우선           | 너비 우선 (레벨별)      |
| 방문 시점 count | 재귀 진입 시         | 큐에서 꺼낼 때         |
| 특징          | 코드 간결, 스택 한계 주의 | 코드 길이 조금 길지만 안정적 |
