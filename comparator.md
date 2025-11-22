[arr자체를 비교.. 비교대상은 "(s1, s2)"의 배열. / 각각의 요소 및 배열차원에 따른 적절한 Comparator 사용하기]

Arrays.sort(arr, (a, b) -> a[0] - b[0]);  //즉 a와 b는 각각 배열, 이 중 인덱스 0을 비교하여 오름차순 (a<b -> a-b).
Arrays.sort(arrInteger, (a, b) -> a - b); // 이는 1차원에서도 유지, 각각의 요소는 최초, 그 다음 "요소"를 의미
Arrays.sort(arr, (a,b) -> a.length() - b.length()) //arr가 String[]이라면 가능하다, 이 외 원시타입은 불가.

//정수배열에 대한 특별한 적용
Arrays.sort(arr, Comparator .comparingInt(String::length) //함수 .thenComparing(Comparator.naturalOrder()) );
Comparator를 사용한다면 "규칙" 과 "함수" "기준"를 기술하라.
- Comparator.comparingInt(String::length) -> 이 경우 각각의 요소 1개씩의 비교 기준
- Comparator.comparingInt(x -> x.length())
- Comparator......thenComapring(Comparator.naturalOrder())

[Comparator는 반드시 객체형태만 지원, 원시형태라면 참조형태로 변경 필요하다]

- String[]
    - 오름차순/단어순
        - Arrays.sort(arr, Comparator.comparingInt(String::length));
        - Arrays.sort(arr, Comparator.comparingInt(s -> s.length()));
        - Arrays.sort(arr); // 기본 오름차순
        - Arrays.sort(arr, Comparator.naturalOrder());
    - 역순(오름차순 배열 후 reversed)
        - Comparator.comparingInt(String::length).reversed()

- int[]
    - Comparator 사용하고 싶다면 Integer[]로 먼저 바꿔라.
        - 오름차순
            - Arrays.sort(arr); // 오름차순, 기본 제공
            - Integer[] arr = {3, 1, 5};
              Arrays.sort(arr, Comparator.comparingInt(x -> x)); // 가능
        - 내림차순
            - Arrays.sort(arr, Comparator.comparingInt(x -> x).reversed());
