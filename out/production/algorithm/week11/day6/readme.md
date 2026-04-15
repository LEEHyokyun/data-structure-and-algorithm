
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
 
- 조합
  - AB, BA는 다른 메뉴조합이 아닌, 동일한 메뉴조합으로 간주하는 조합문제.
  - 각 단품의 조합 코스는 반드시 사전순으로 배열해야 한다.
  - 한번 선택하고 다시는 선택하지 않는다, 다음 단계로 넘어간다.

```java
for (int i = start; i < len; i++) {
    arr[depth] = chars[i];
    dfs(i + 1, depth + 1);
}
```

  - 결과의 크기가 정해져있다면 String[], char[] OK
  - 하지만 지금의 경우처럼 결과의 크기가 결과에 따라 자연스럽게 정해지는 경우라면 List<String> list = new ArrayList
  - 조합 코스요리에 대한 빈도수를 확인하기 위해 Map 자료구조를 이용하는 방안까지는 괜찮았다.
    - 각 course target을 설정할때마다 map clear를 하는 생각
      - for(int target : course){
        map.clear();
        }
    - dfs단위 : orders 순회하면서 각 order.
    - 각 String order를 char[]로 변환한 후 사전순 정렬을 위해 array.sort
      - char[] chars = order.toCharArray();
        Arrays.sort(chars);
    - 그 후 dfs 적용
      - chars[] arr -> 조합한 내역을 string으로 : stringBuilder.append(arr)
      - StringBuilder sb -> String(sb.toString())
    - 해당 target에 대해서 최빈도를 찾아야 한다.
      - map 순회하면서 탐색하기
        - key -> keySet, values -> values
          - String key : keySet() -> 최빈도에 부합하는 문자열 조합(key) list.add 
          - map.values() -> 최빈도 찾기
    - 그 후 최종 결과까지 sort
      - list.sort
      - Collections.sort(list);
    - 최종 결과 : 리스트형태를 문자열 배열 형태로(toArray(new String[0]))
      - list -> String[] : list.toArray(new String[0])

> 순열이라면, 순서가 같다. 즉 한번 선택했어도 다른 경우로 취급(1,2 != 2,1) 따라서 시작점은 항상 고정
> 그대신 selected 사용

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

[정렬]

- arrayList 정렬
  - Collections.sort
  - list.sort(Comparator.naturalOrder())
    - list.sort((a,b) -> return a.length() - b.length() return a.compareTo(b)) (길이 > 사전순 정렬)
      - a, b는 char이기 때문에, 사전순 배열을 해야한다면 comparTo.
    - 여기서는 길이 상관없이 사전순 배열만 필요하기에 a.compareTo(b)면 충분하다.
  - list.sort(Comparator.reverseOrder())

[map 연산]