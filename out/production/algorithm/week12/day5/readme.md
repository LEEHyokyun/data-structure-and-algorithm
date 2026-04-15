[day5]

- N개의 수 중 M개를 뽑아서 수열 만들기
  - 출력의 문제
    - int[] / char[] path -> stringBuilder 하는 방안
    - path를 순회하면서 수열 원소를 추출하고, 이를 그대로 sb에 append
  - arrayList<String>을 String[] 형태로 바꾸려면?
    - list.toArray(new String[0])
  - 중복처리의 경우
    - 중복 허용 -> 지금처럼 조건 만족하는대로 출력
    - 중복 불허 -> 중복 불허 조건 추가
      - prev 처리로 중복 처리 가능?
      - 정렬하면 중복처리 무조건 가능.
  - 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    - Arrays.sort 처리

- 단품 메뉴를 코스요리로 "조합"하기
  - dfs : 조합이므로, selected 필요없이 start 단계를 이전 단계에서 + 1
  - 조합 접근은 확실하고, 모든 내역에 대해 "동일한 조합 기준을 판별하기 위해서는 정렬 기준이 모두 동일해야 한다."
    - 즉, Orders의 모든 문자열은 반드시 같은 사전순 정렬이 되어야 DFS했을때 동일한 조합결과 반환가능하다.
    - 조합의 기준을 일관성있게 정립.  

- 조합
  - 숫자 조합 -> path[index] -> path 순회하면서 StringBuilder
  - 문자 조합 -> String -> s.charAt(i) 추출 원소를 str + char -> str
    - str.length() 비교 등(depth와 같은 매개변수 최소화)
  - String + char => String
  - char[] -> new String(char[] ch) -> 즉 new String의 생성자를 char[]로 할 경우 String 형태로 변환됨. 

- map
  - map.get
  - map.put
  - map.getOrDefault

[사전순 배열]
- 조건 자체의 사전순 배열
- 결과의 사전순 배열