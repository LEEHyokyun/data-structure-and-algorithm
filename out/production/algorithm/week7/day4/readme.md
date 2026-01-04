## 1. Day4

[DFS/BFS]
- DFS/BFS
  - 미로찾기(2차원 배열)과 같이 갈 수 있는 방향/인접노드가 정해져 있을때.
    - dx, dy
    - boolean을 하지 않고도, maps를 활용하여 count 바로 적용 및 이 배열 자체를 visited로 활용.
      - 다음 갈 수 있는 인접노드 = for 순회
        - for(int i = 0 ; i < 4 ; i++){
          int nx = x + dx[i];
          int ny = y + dy[i];
  - boolean[] visited 필수!
    - Arrays.fill -> 1차원 기본, 할려면 for 순회 필요
    - boolean의 기본값은 false..visited에 대해서는 별도 초기화는 필요 없다.
      - 접근
        - arr[x][y]
      - 선언
        - new int[]{1,2}
  - Network
    - static int[] graph 선언 후
    - graph = new int[][] 반드시 "정의"필요 .. NPE 발생한다.
    - 좌표 이동이 아닌, 노드 간 연결 관계면 dx/dy를 쓰지 않는다
      - 노드간 연결관계의 방문여부는 1차원으로도 충분하다.
      - queue 누적 필요X bfs 내에서 정의/선언
    - graph 정의 및 선언의 유형
      
[유의사항]

- “좌표 이동이 아닌, 노드 간 연결 관계면 dx/dy를 쓰지 않는다.
  - 노드간 연결관계의 방문여부는 1차원으로도 충분하다.
  - queue 누적 필요X bfs 내에서 정의/선언

[graph]

1. 격자기반 그래프
2. 인접리스트 그래프
3. 인접행렬 그래프

- 인접리스트 그래프
  - 인접노드의 "번호들을" 그래프화.
  - "노드번호" "인접상태가 노드번호"

1) arrayList, index = "Integer"
```java
ArrayList<Integer>[] graph = new ArrayList[n];
```

2) 각 index의 컴포넌트  = "arrayList" = ArrayList<Integer>[] / new arrayList[n]
```java
for (int i = 0; i < n; i++) {
    graph[i] = new ArrayList<>();
}
```

3) 인접노드 표현
```java
graph[u].add(v);
graph[v].add(u); // 무방향
```

- 인접 행렬 그래프
   - 조건 자체가 2차원 행렬 형태

1) 입력조건

```java
int[][] graph = new int[n][n];
```

2) 입력조건을 순회

```java
for (int i = 0; i < n; i++) {
    if (graph[cur][i] == 1 && !visited[i]) {
        ...
    }
}
```

- Queue는 보통 1차원적 요소를 넣는다.
  - Queue<Integer> q = new ArrayDeque<>();
  - 그 외 Queue<int[]> q = new ArrayDeque<>();

| 구조              | 의미      | 언제 사용   | 큐에 들어가는 것 |
| --------------- | ------- | ------- | --------- |
| `Queue<int[]>`  | 좌표/상태 큐 | 격자 BFS  | `(x,y)`   |
| `ArrayList[]`   | 인접 리스트  | 일반 그래프  | 노드 번호     |
| `int[][] graph` | 인접 행렬   | 노드 적을 때 | 노드 번호     |
| `Queue[]`       | 큐의 배열   | 특수 알고리즘 | 거의 안 씀    |

-> “좌표 문제면 Queue<int[]> / 관계 문제면 ArrayList[]”

[기본]

- Queue -> ArrayDeque / Stack -> Stack
- 정렬
  - List<Integer> -> Collections.sort
  - List<int> -> Arrays.sort

[문자 > 숫자]
- 소문자 -> 숫자 : char c - 'a'
- 대문자 -> 숫자 : char c - 'A'
- 숫자형태 : c - '0' (=숫자를 빼는 순간 숫자형태임)

[번외]
- 이중배열에 대하여
  - ArrayList<Integer>[] list = new ArrayList[];
  - for... list[i] = new ArrayList<>();

ArrayList<Integer>[] graph = new ArrayList[n];
-> 연필통 n개를 올려둘 칸만 만든 상태, 요소는 Integer, 아직 내부적인 배열은 없고 칸만 있다.
-> 배열을 여러개 만들긴 하였는데, 내부 반환형태는 어떻게 할 것인가? 구현체는 어떻게 할 것인가?

```sass
graph (배열)
├─ [0] → null
├─ [1] → null
├─ [2] → null
├─ [3] → null
└─ [4] → null
```

for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
-> 각 칸에 실제 연필통을 하나씩 붙여 놓는 것

```sass
graph
 ├─ [0] → []
 ├─ [1] → []
 ├─ [2] → []
 ├─ [3] → []
 └─ [4] → []
```

내가 처음에 생각한, ArrayList<Integer>[] list = new ArrayList[N];

```sass
graph
├─ graph[0] → List<Integer> → []
├─ graph[1] → List<Integer> → []
├─ graph[2] → List<Integer> → []
```
이 형태는 OK, 그러나 실제 메모리 상태는 다르다.

```sass
graph (배열)
 ├─ graph[0] → null
 ├─ graph[1] → null
 ├─ graph[2] → null
```

배열 상태, 껍데기만 만든다. 배열(연속적 메모리 공간)은 되었는데 내부가 null인 상태로 남아있는것.

> 따라서 arrayList<Integer>라는 완성된 알맹이를 넣어주어야 비로소 완성이다.

즉, 타입 -> 실체의 순으로 이루어진다.

```sass
List<Integer>
```
= “이 변수에는 List가 들어올 수 있다”는 약속

```sass
new ArrayList<>()
```

= 실제로 존재하는 List 한 개, 이것으로 구체화해주겠다.

Queue<int[]> -> OK
List<Integer>[] -> 순회
List<int[]>[] -> NG