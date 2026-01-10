
[day6]

[DFS : 조합]

- 구현 = 단순 명료하게.

- 조합
  - 기초 : StringTokenzier -> nextToken의 반환형태는 각각 문자가 1개짜리인 String이다(char 아님).
    - 문자가 하나이므로, 하나의 String을 char로 변환하여 입력하는 것이 필요 -> charAt(0)
    - 만약 이 상태에서 toCharArray ? -> nextToken 자체가 1개의 String .. 1개의 문자열 ['a'].
      - 알파벳 arr 자체가 순서를 고려하지 않은 채로 구성되어 조합이 되어야 함.
      - 그러면 i = 0 ?
        - "사전순"을 보장하기 위해 Arrays.sort를 한다.
        - 이 상태에서 순서를 보장하는 조합을 진행한다.
          - selected를 할 필요없이, i = start
        - 조합의 유효성 판단
          - 쉽게 생각하기, 문자열이 모두 만들어졌을 경우, 그 완료된 상태에서 판단, 아니라면 그대로 백트래킹하면 된다.
  - 출력을 StrinbBuilder + char[] arr 혼용 혹은 StringBuilder 단독 활용
    - 백트래킹은 "append한 StringBuilder"를 그 length 그대로 초기화 하던지, length -1까지만 두던지.
    - sb.setLength(length) -> length 길이까지만 slice하여 되돌린다.
    - sb -> 출력전용 / arr -> 상태/경로전용     
 
- 첫번째 문자열을 바꿔치기 하는 방안 -> depth를 index로 구성

```java
for(int i = start ; i < C ; i++){
    arr[count] = list[i]; //첫번째 문자열은 항상 달라질 수 있다.
        }
```

조합
- 기본 : i = 0 고정 / selected
- ? : i = start / depth i 증가(i = i + 1) / selected x

순열
- 기본 : i = start / depth 1 증가(i = i + 1) .. 항상 선택지점 다음으로 / selected o
- ? : i = start / depth 1 증가(i = i + 1) / selected x