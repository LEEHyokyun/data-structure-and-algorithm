## 1. Day3

[최대힙/우선순위큐]
- Implements : 배운점(문제)
  - 30만개 : 배열 OK
  - 100만개 : ArrayList OK
    - 최대힙 자료구조를 그대로 이용하기
    - 우선순위큐 + 시뮬레이션(시간흐름) + 구현(로직구현)
      - Heap의 구현체인 PriorityQueue를 그대로 사용한다.
        - 최소힙 : PriorityQueue
        - 최대힙 : PriorityQueue(Collections.reverseOrder())
      - 우선순위큐를 사용하여 작업소요시간 > 요청시각 순으로 요소를 정렬해놓는다.
        - 비교기법 중요(lambda/Comparator/Comparable)
      - 큐에 넣어진 시각이 겹쳐도 어차피 처리하는 항목은 겹치지 않는다 = 시간누적
        - time = time + job[1]
        - 반환시각을 구하고 이를 누적, 최종적으로 평균치 산출
- Improvements : 작동원리/개선포인트(본질)
  - Heap
    - 완전이진트리 형태를 만족하면서 부모/자식 및 서브트리 간 규칙(정렬) 규칙을 만족하는 자료구조
      - 삽입 및 삭제 : O(logN), 최댓값 및 최솟값 조회 : O(1)
      - 최소힙/최대힙/우선순위힙 자료구조에 따라 정렬 및 순서 달라진다.
        - 구현체는 PriorityQueue로 제공.
- Additional : 추가적인 유의점들

[min Heap / max Heap / Priority Heap]

- 최소힙 - 루트노드가 최소값, 부모노드가 자식노드보다 값이 작다(즉 밑으로 내려갈수록 오름차순)
- 최대힙 - 루트노드가 최대값, 부모노드가 자식노드보다 값이 크다(즉 밑으로 내려갈수록 내림차순)

| 종류            | 규칙          | 루트 노드  | 대표 활용          |
| ------------- | ----------- | ------ | -------------- |
| Min Heap      | 부모 ≤ 자식     | 최소값    | Dijkstra, 스케줄링 |
| Max Heap      | 부모 ≥ 자식     | 최대값    | Top-K, 최대값 추적  |
| Priority Heap | 사용자 정의 우선순위 | 기준에 따름 | 복합 조건 정렬       |
| Bounded Heap  | 크기 제한 힙     | 상황별    | 상위 K개 유지       |
| Dual Heap     | Min + Max   | 둘 다 조회 | 중앙값 문제         |

[Heap 구현체 = PriorityQueue]

| 메서드         | 설명         | 시간복잡도    |
| ----------- | ---------- | -------- |
| `offer(x)`  | 삽입         | O(log N) |
| `poll()`    | 루트 제거 후 반환 | O(log N) |
| `peek()`    | 루트 조회      | O(1)     |
| `size()`    | 요소 개수      | O(1)     |
| `isEmpty()` | 비었는지 확인    | O(1)     |

[자료구조 별 구현체사용]

- 최소힙 : PriorityQueue<Integer> minHeap = new PriorityQueue<>();
- 최대힙 : PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

[유의사항]

| 구조      | 접근       | 삽입       | 특징      |
| ------- | -------- | -------- | ------- |
| Heap    | 루트만 O(1) | O(log N) | 우선순위 특화 |
| 정렬 배열   | O(1)     | O(N)     | 정적 데이터  |
| TreeSet | 범위검색 가능  | O(log N) | 중복 ❌    |

[다양한 우선순위 정렬]

- 2차원배열일 경우에는 람다식 및 요소간 비교를 직접 작성

```java
Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
```

```java
Arrays.sort(jobs, new Comparator<int[]>() {
    @Override
    public int compare(int[] a, int[] b) {
        return a[0] - b[0];
    }
});
```

```java
class JobStartComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}
```

- 1차원배열일 경우에는 체이닝 방법을 많이 활용

```java
Arrays.sort(jobs,
            Comparator.comparingInt(a -> a[0])
        );
```

- a - b -> 음수면 a -> b 순, 양수면 b -> a

| 반환값    | 의미     | 결과                       |
| ------ | ------ | ------------------------ |
| 음수 (-) | a < b  | a가 **앞에 온다**             |
| 0      | a == b | **순서 유지** (stable sort면) |
| 양수 (+) | a > b  | a가 **뒤에 온다**             |
