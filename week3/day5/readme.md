## 1. Day5

[백트래킹]
- Implements : 배운점
  - 백트래킹 : 말 그대로 돌아온다는 의미이다.
    - 가능한 모든 경우를 탐색하되, 중간에 더 진행해도 답이 안 나오는 가지(branch)는 중간에 잘라내고(Pruning) 돌아오는 방식
    - 하나 선택 → 다음 선택 → 실패하면 돌아가기 
  - 조합을 고정된 배열로 표현한다? 백트래킹 의심.
  - arr[i](배열)형태를 사용하거나 arrayList(리스트) 형태를 사용하거나.
  - Comparator 사용 방법은 계속 보는 것이 좋겠다. 
- Improvements : 막혔던 지점 / 고민한 포인트
  - 백트래킹의 구현은 DFS이다. BFS가 아니다.
    - DFS의 일종으로 보면 됨(백트래킹은 DFS의 특수한 형태).
  - 조합 + DFS
    - static void dfs(int start, int depth){ //N개 중에 M개(=depth)
      //backtracking
      if(depth == M){
      for(int x : arr) System.out.print(x + " ");
      System.out.println();
      return;
      }

      //dfs
      /*
      * 시작점 : start부터
      * 조합의 가지 수 : depth까지
      * 각 층마다 arr를 채우고 층이 넘어가면 다시 초기화해서 채우는 방식
        */
        for(int i = start ; i <= N ; i++){
        arr[depth] = i; //다음 순회 depth = 0
        dfs(i+1, depth+1);
        }

      //처음(1~2)
      //arr[0] = 1
      //arr[1] = 2
      //depth = 2 ->
      //재귀 종료 다음 조합으로 넘어간다.

      //이후(2~)
      //arr[0] = 2
      //..
      }
  - new Comparator
    - new Comparator<String>(){
      public int compare(String a, String b){
      //길이
      if(a.length() != b.length())
      return a.length() - b.length(); // 0보다 작으면 a-b순, 0보다 크면 b-a순

                          //숫자합
                          int sumA = sumDigits(a);
                          int sumB = sumDigits(b);
                          if(sumA != sumB)
                              return sumA - sumB;
                          
                          //단순비교 : compareTo
                          return a.compareTo(b);
                      }  
  - String > characters : toCharArray()
    - Character.isDigit(c) //숫자형태의 문자인가?
      - sum = sum + (c - '0') **숫자형태 = char - '0'
  - Comparator 체이닝도 숙지 필요함
    .comparingInt(String::length)
    .thenComparingInt(Comparator1::sumDigits) --> (Main::api)
    .thenComparing(Comparator.naturalOrder())
- Additional : 추가적인 유의점들

[백트래킹/DFS]

```java
DFS(node):
for next in 후보:
DFS(next)
```
```java
Backtracking(node):
if 더 진행해도 답이 안됨:
return   // 가지치기

    for next in 후보:
        선택
        Backtracking(next)
        선택 취소 (원상복구)
```

[백트래킹]

백트래킹이 필요한 문제 =
상태 하나 선택 → 그 다음 상태 선택 → 불가능하면 돌아가는 구조가 필요한 문제

[브루트포스 vs 백트래킹]

“가능한 모든 경우를 탐색한다”는 관점은 동일하다
→ 하지만 동작 방식(Pruning 여부) 가 결정적인 차이를 만든다.

브루트포스:
가능한 모든 경우를 끝까지 전부 탐색한다.
가지가 말도 안 되는 방향이어도 끝까지 간다.

백트래킹:
가능한 모든 경우를 탐색하되,
중간에 불가능한 경우는 더 이상 내려가지 않고 가지를 잘라낸다 (Pruning).
그래서 훨씬 효율적이다.

즉, 
“모든 경우의 수 탐색”이라는 큰 틀은 같다.
하지만 동작 방식에서 가지치기(Pruning)가 추가된 것이 백트래킹이다.

| 구분                | 브루트포스 (Brute Force)         | 백트래킹 (Backtracking)                                  |
| ----------------- | --------------------------- | ---------------------------------------------------- |
| **정의**            | 가능한 모든 경우를 전부 탐색하는 방식       | 가능한 경우를 탐색하되, **유망하지 않은 경우는 미리 가지치기(pruning)** 하는 방식 |
| **탐색 범위**         | 전체 경우의 수 (Full Search)      | 가지치기를 통한 부분 탐색 (Pruned Search)                       |
| **효율성**           | 매우 비효율적. 시간복잡도: O(N!) 등이 흔함 | 브루트포스보다 훨씬 효율적. pruning 효과에 따라 매우 빨라짐                |
| **가지치기(Pruning)** | 없음                          | 있음 → 불필요한 경로는 즉시 중단                                  |
| **대표 문제**         | 순열/조합 생성, 간단한 완전탐색          | N-Queen, 부분집합 합 문제, DFS 기반 조합/순열 최적화                 |
| **구현 난이도**        | 매우 쉬움                       | 상대적으로 어려움 (조건 검사 + 백트래킹 구조 필요)                       |
| **사용 목적**         | 전체 탐색이 가능할 정도로 입력 크기가 작을 때  | 모든 경우를 보면 터지는 문제를 빠르게 탐색해야 할 때                       |
| **시간 절약 여부**      | 없음                          | 조건을 만족하지 않은 경로는 즉시 포기 → 시간 대폭 절약                     |
| **동작 방식**         | 무식하게 끝까지 다 가봄               | DFS 기반으로 내려가다가 조건 위반 시 되돌아옴(Backtrack)               |
| **예시 코드 구조**      | 단순 반복/재귀로 모든 경우 탐색          | 재귀 + 조건 검사 + 되돌리기(undo)                              |
