## 1. Day4

[BFS]
- Implements : 배운점(문제)
  - 인접노드간 거리를 int[], 도시/도로의 숫자가 크므로 그래프는 단순 배열이 아닌 List<Integer>[] graph = new ArrayList[N+1];
    - for..graph[i] = new ArrayList<>();
  - 마찬가지로 큐 구현체를 사용하는데 도시/도로의 숫자가 크므로 ArrayDeque로 성능이점 확보.
  - graph를 구성하는 방법
    - arrayList 구성은 OK
      - 첫번째 케이스 : 양방향 모두 있으므로 그대로 arrayList로 구성
      - 두번째 케이스 : 단방향 정보만 존재..arrayList 구성할때 쌍방향으로 구성 
- Improvements : 작동원리/개선포인트(본질)
  - BFS : 간선비용이 모두 동일할때 최단거리 혹은 인접노드 탐색하기
    - Queue 사용 - 구현체는 mot이 적으면 LinkedList, 크면 ArrayDeque 활용할 것.
    - Queue 구현체의 내부적인 동작 원리 비교 - https://ittrue.tistory.com/322#google_vignette
  - 결론적으로는 구현체는 Queue / Stack / Deque 전부 ArrayDeque 하나로 통일하는 것이 권장됨.
- Additional : 추가적인 유의점들

[BFS vs 다익스트라]

- BFS : 간선비용이 동일할때 최단거리
  - 거리가 몇 칸인가
    - 모든 간선 비용이 1(또는 동일) 이면 → 먼저 도착한 경로가 항상 최단 경로
- 다익스트라 : 간선비용이 다를때 최단거리
  - 거리가 얼마의 비용인가
    - 경로 길이가 짧아도 비용이 클 수 있음 → 늦게 도착해도 총 비용이 더 작을 수 있음
    - 음수 가중치가 있다면 벨만포드 알고리즘.

| 구분       | BFS      | 다익스트라         |
| -------- | -------- | ------------- |
| 간선 가중치   | 모두 동일    | 서로 다름         |
| 핵심 자료구조  | Queue    | PriorityQueue |
| 탐색 기준    | 거리(레벨)   | 누적 비용         |
| 최단 경로 보장 | O (무가중치) | O (양수 가중치)    |
| 시간 복잡도   | O(V + E) | O(E log V)    |
| 대표 문제    | 미로, 칸 이동 | 비용, 시간, 연료    |
| 음수 가중치   | 해당 없음    | ❌ 불가          |

[Queue]

- FIFO

| 구현체                       | 내부 구조                    | 주요 API                      | 특징 / 주의점                    |
| ------------------------- | ------------------------ | --------------------------- | --------------------------- |
| **LinkedList**            | Doubly Linked List       | `offer()` `poll()` `peek()` | Deque도 같이 구현, 중간 삽입/삭제 O(1) |
| **ArrayDeque** ⭐          | Dynamic Array (circular) | `offer()` `poll()` `peek()` | **가장 권장**, null 불가          |
| **PriorityQueue**         | Heap                     | `offer()` `poll()` `peek()` | 우선순위 기반, FIFO ❌             |
| **ConcurrentLinkedQueue** | Lock-free linked         | `offer()` `poll()`          | 멀티스레드 안전                    |

[Stack]

- LIFO

| 구현체              | 내부 구조         | 주요 API                    | 비권장 사유           |
| ---------------- | ------------- | ------------------------- | ---------------- |
| **Stack** ❌      | Vector (동기화)  | `push()` `pop()` `peek()` | Legacy, 성능↓      |
| **ArrayDeque** ⭐ | Dynamic Array | `push()` `pop()` `peek()` | **사실상 표준 Stack** |
| **LinkedList**   | Linked List   | `push()` `pop()`          | 성능 예측 어려움        |

[Deque]

- Queue + Stack

| 구현체                       | 내부 구조          | 주요 API | 특징             |
| ------------------------- | -------------- | ------ | -------------- |
| **ArrayDeque** ⭐          | Circular Array | 대부분 사용 | 성능 최고, null 불가 |
| **LinkedList**            | Doubly Linked  | 전체 API | 메모리 비용 큼       |
| **ConcurrentLinkedDeque** | Lock-free      | 멀티스레드  | 동시성 환경         |

[상황별 적절한 자료구조]

| 목적       | 추천 구현체                  | 이유         |
| -------- | ----------------------- | ---------- |
| 일반 큐     | `ArrayDeque`            | 빠름, 메모리 효율 |
| 스택       | `ArrayDeque`            | Stack 대체   |
| BFS/DFS  | `ArrayDeque`            | 양방향 사용 가능  |
| 슬라이딩 윈도우 | `Deque`                 | 앞/뒤 제어     |
| 우선순위     | `PriorityQueue`         | 힙 기반       |
| 멀티스레드    | `ConcurrentLinkedQueue` | Lock-free  |
