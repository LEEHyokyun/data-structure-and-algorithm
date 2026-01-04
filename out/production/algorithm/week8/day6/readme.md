## 1. Day6

[BFS/DFS]
- 색깔영역
  - BFS의 횟수를 묻고있다.
    - 정상 -> R/G/B
    - 적녹 -> R=G/B
  - continue 조건 자꾸 누락한다. 누락하지 않도록 유의한다.
    - if(x < 0 || y < 0 || x >= N || y >= N) continue;
      if(visited[x][y]) continue;

- 공항경로 DFS 탐색하기
  - 다음의 선택하는 경로가 알파벳 순을 보장해야 한다.
    - 이걸 함수화 하지말고 애초에 "사전순으로 정렬한다"
  - 결과가 배열 형태이다.
    - answer = ArrayList
      - length X size() (0)
        - answer.ToString() -> "[A, B, C]" 실제 출력은 [A,B,C]로 배열 형태, 다만 문자열 배열 형태가 아님.
        - answer.toArray(new String[0]) -> ["A", "B", "C"] 실제 출력이 비로소 "문자열 배열" 형태.
    - 출발지점, 도착지점 모두 알파벳 순 정렬
      - a[0].compareTo(b[0])
        - a[0] - b[0] -> a[1] -> b[1]
    - dfs 건너뛰기 조건 항상 염두에 둘 것!!
      - visited true -> continue;
      - dx dy < 0 >= n -> continue;
      - !start.equals(cur) -> continue;
  - 백트래킹은 모든 경로를 탐색하기 위한 것 
    - + 실패하였을때이다.
    - 아래 ASIS/TOBE 로직 반드시 이해하고 넘어갈 것.

[Set]
- 기본적으로 wrapper 클래스만 자료구조에 활용 가능
  - Set<Character>
  - HashSet<>()

[q.poll()의 올바른 사용]
- 배옇형태일때 q.poll[0] 이런식으로 바로 접근하면 안됨
  - int[] cur = q.poll() 변수 할당 후
    - cur[0], cur[1]로 각각 좌표 적용

[toCharArray를 활용한 graph 입력 효율화]

- 기존

```java
for(int i = 0 ; i < N ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < N ; j++){
                graph[i][j] = input.charAt(j);
            }
        }
```

- 개선(하나의 행을 toCharAray로 그대로 입력)

```java
for(int i = 0 ; i < N ; i++){
            graph[i] = br.readLine().toCharArray();
        }
```

[사전순 정렬을 보장 필요할 경우]

- comparable, compareTo .. 사전순으로 정렬해보자.
  - 숫자라면? 그대로 a - b a[0] - b[0]
  - 알파벳/문자라면? a.compareTo(b) a[0].compareTo(b[0])

[배열 형태를 출력하고자 할 경우]
- answer.toString() -> "[A, B, C]"
- answer.toArray(new String[0]) -> ["A", "B", "C"] (String[])

[ASIS/TOBE]

조건을 만족한다고 해서 DFS 방법이 모두 적용되지는 않는다.

```java
tickets =
[
  ["ICN", "A"],
  ["ICN", "B"],
  ["B", "ICN"]
]
```

의 예시를 들면, 정렬 후

```java
["B", "ICN"]
["ICN", "A"]
["ICN", "B"]
```

ICN 출발 -> 최초 A선택 .. 그런데 A로 가는 선택지가 존재하지 않는다.

> 이때 백트래킹 로직이 필요하다.

```java
["ICN", "A", "B", "ICN"]
```

즉, 조건을 맞게 answer를 구성하는 것이 실패할 수도 있기에 복구하는 작업이 필요하다.
- 경로제거, visited 복구, count 횟수 감소(--)

```java
["ICN", "B", "ICN", "A"]
```
이 경우, 해당 경로에서 제거 후 다음 순회에서 경로를 찾으면 됨