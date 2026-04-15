[day3]

[DFS]

- DFS도 기본적으로 방문 체크 해줘야 한다.
  - DFS / dist(DP) / BFS 모두 방문체크.
- 조합 
  - i = start -> 순서 상관없는 조합
- 순열
  - 기본적으로 8 ~ 10개 원소 개수가 매우 적음
    - 순서 고려
    - for(int .. ) -> 그대로 dfs..
    - depth만 고려하면 된다.
    - 수열에 대한 출력, 배열, 문자열 출력 등은 "StringBuilder"를 기본적으로 고려할 것.
      - StringBuilder , System.out.println은 I/O비용 및 로직구성에 대한 비용도 비용이지만,
      - 백트래킹 비용이 너무 극심하다.
        - int len = sb.length();
        - sb.setLength(len); // 백트래킹시 length 만큼 다시 생성 .. 쉽게 생각할 수 있을까?
      - 반드시 array를 활용한 sb append / arr 등을 적절히 활용해서 백트래킹 비용 최소화 할 것.
        - static 전역 arr -> 백트래킹 필요 없어짐

- 소수
  - String -> String array 혹은 int array로 효율적으로 변환할 수 있는 방법은?
  - 숫자를 arr에 저장해두었다가, 다시 합쳐서 하나의 숫자로 병합하는 방법은?
  - 소수를 판단하는, 약수를 판단하는 효율적인 방법은?

[출력]

- 필요 조건에 따라 StringBuilder에 모든 내용을 저장
- 최종적으로 System.out.print(sb) 형태로 출력

[순열/조합]

- 순열 : 순서 고려, i = 0 고정 , selected
- 조합 : 순서 고려하지 않음, i = start, selected

[문자열 > int[]]

```java
char[] c = numbers.toCharArray();
int digit = c[i] - '0';
```

[arr에 저장한 숫자를 하나의 숫자로]

- 아이디어가 그리 좋은 방향은 아니다.
- 차라리 String 문자열을 두고, 이 문자열에 붙이는 형식으로 진행
  - StringBuilder
  - 백트래킹이 조금 아쉽다 -> len = sb.length(); -> 백트래킹 시 sb.setLength(len)
    - String.length(), sb.length()
    - Integer = parseInt(sb.toString())
- int num = Integer.parseInt(String)
  - 이 시점에서 이미 011 11 같은 수로 고려됨

[소수/약수판별]

- 약수는 제곱근까지
  - 약수 : for int i = 1 i * i <= n ; i++
  - 소수 : for int i = 2 i * i <= n ; i++

[자료구조 활용]

- 결과의 중복 방지? -> Set 반드시 활용
  - set.contains
  - set.add   (완전탐색에서, 전체 결과에 대한 중복 불허 혹은 조건을 만족하였을때 중복 불허)