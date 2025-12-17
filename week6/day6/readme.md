## 1. Day6

[우선순위큐 다익스트라]
- Notes
  - 가중치가 있는 그래프의 최단경로
    - 방향이 있고 가중치가 있다.
    - 정점수 및 간선 수에 따라 일반적인 다익스트라가 아닌 PQ(우선순위큐) 다익스트라 적용 필요
    - int[] dist = new int[V + 1];
      Arrays.fill(dist, INF);
      dist[K] = 0;
      - 방문거리 배열을 INF로 채우고, 최초 시작점을 0으로 초기화.
    - 순회기준 = Node(시작점에서 해당 지점까지의 거리) / 경로누적 = Edge(*인덱스 = from)/->graph
      - Node = 현재, Edge = 인접
        - 순회정보
          - graph -> List[] -> Edge정보, index에서 to로 갈때의 가중치 정보 보유
            - 양방향 -> 모든 인덱스(노드번호)에 대한 가중치 저장
            - 단방향 -> 단일 인덱스에 대한 가중치 저장
          - dist -> int[] (1차열 배열, 결과를 저장하는 배열 그 자체)
            - dist[1] (시작점) = 0
          - PriorityQueue -> Node 정보, 시작점에서 해당 지점으로 가는 거리(가중치의 합)
            - v, dist
            - 최초 시작점 1 -> Node(1,0) (1->1 = 0)
          - 경로누적의 조건
            - if(cur.dist <= dist[cur.v]){ -> 반드시 동일조건 붙여야 dist 갱신가능(if의 경우)
            - or cur.dist > dist[cur.v] -> continue -> 아예 "클(초과)" 경우에는 갱신X
  - 가중치가 모두 동일하다면?
    - BFS
  - 다익스트라 -> PriorityQueue, BFS -> Queue

[2차행렬의 행선언/열선언]

```java
List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++){
graph[i]=new ArrayList<>();
        }
```

[우선순위큐에 2차원 배열 및 우선순위를 적용할때]

```java
PriorityQueue<Node> pq = new PriorityQueue<>();

(a, b) -> a.dist - b.dist

Comparator<Node> comp = new Comparator<>() {
  @Override
  public int compare(Node a, Node b) {
    return a.dist - b.dist;
  }
};
```

[인접노드로 이동하면서 이동가중치 계산 및 거리표 업데이트]

```java
while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.dist > dist[cur.v]) continue;

            for (Edge e : graph[cur.v]) {
                int cost = cur.dist + e.weight;
                if (cost < dist[e.to]) {
                    dist[e.to] = cost;
                    pq.offer(new Node(e.to, cost));
                }
            }
        }
```

이때,

```java
//인접노드로
            for(Edge e : graph[cur.v]){
int cost = cur.dist + e.weight;   //현재노드에서 인접노드로의 가중치 합(경로)
                if(cost < dist[e.to]){  //현재의 가중치 값보다 작은가 
dist[e.to] = cost; //작으면 갱신
                    pq.offer(new Node(e.to, cost)); //인접노드 정보 넣기
        }
        }
```

= 시작점 → 현재 정점(cur.v)까지의 최단거리 + 현재 정점 → 인접 정점(e.to)로 가는 간선 비용

```java
while(!pq.isEmpty()){       
            Node cur = pq.poll();  //순회기준 = pq우선순위 = 노드
            
            if(cur.dist < dist[cur.v]){               //dist[v] -> v로의 거리 -> Node.  
                for(Edge e : graph[cur.v]){ //경로 누적 = 그래프 = edge
                    int cost = cur.dist + e.w; //Node -> 현재, Edge -> 인접
                    if(cost < dist[e.to]){
                        pq.offer(new Node(e.to, cost));
                        dist[e.to] = cost;
                    }
                }
            }
        }
```

- pq -> Node = 경로누적
- graph -> index(u)에서 v로가는 가중치
- 1) v로가는 최단 거리를 확인하고(cur.dist < dist[cur.v]) 2) 경로누적(for Edge)

[2차원 배열에서 조건에 따른 정렬순서를 정의하고자 할 때]

Comparator의 규칙(a<b -> a우선, a>b -> b우선)
- 음수 반환 → a가 b보다 우선
- 0 반환 → 같음
- 양수 반환 → b가 a보다 우선

[다익스트라는 PriorityQueue]

다음의 인접노드 가줃치 합이 최소 가중치임을 보장해야 한다. 
- 이를 위해서는 반드시 우선순위 큐를 활용한 그래프 정보 저장이 진행되어야 한다.

```sass
1 --(10)--> 2
1 --(1) --> 3 --(1)--> 2
```

시작: 1
- 큐에 넣음: 2(10), 3(1)
- 2를 먼저 꺼냄
- dist[2] = 10 (확정처럼 처리됨)

> 반드시 가중치가 적은 순서대로 진행 필요, 그렇지 않으면 짧은 경로(3 → 2)가 뒤늦게 발견됨