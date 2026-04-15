[day5]

[DFS : 조합 -> DP]

- 구현 = 단순 명료하게.

- 연속 수의 합
  - 처음 시작부터 원소개수를 보고 DP 의심을 해야한다.
    - 결과 저장 자료구조 : Set - HashSet
    - 원소개수가 많아서 DFS를 통한 완전탐색 시 메모리 오류 발생
    - 원소 개수 많을 경우
      - DP
      - 음수인 경우도 모두 고려해야 한다.
      - 점화식 세우고 + result = Math.max(result, dp[i]);를 통해 매 순회마다 최대값 교체 필요.

- 최대값, 최소값
  - String을 int처럼 다루기
    - 양수만으로 이루어진 String > chars + charAt() - '0' or chars[i] - '0'
    - 음수/양수로 이루어진 String > 공백/분리기준으로 나누고 String[] > String[] s = string.split("")
      - String[] 이면 연산이 쉬워진다 > 
      - for(String s : ss){
        int val = Integer.parseInt(s);
        } -> 가능해진다.
        - 최대 -> Math.max
        - 최소 -> Math.min

```java
dp[i] = Math.max(list[i], dp[i-1] + list[i]); 
//여기서 음수일때 연속합 하지 않고 양수일때 연속합 하는 의도가 모두 들어가있다.
```

[HashSet]

- 결과누적 : set.add
- 중복판단 : set.contains
- 결과순회 : 결과누적 시 Math.max(answer, result) 진행, 이것이 힘들다면 최종 결과에서 순회
  - Object[] set.toArray
  - iterator<Integer> iterator = set.iterator(); / while(iterator.hasNext())

[String]

- String + " " + int 형태 가능
- int + " " + int 로 이어붙여서 String 형태 가능