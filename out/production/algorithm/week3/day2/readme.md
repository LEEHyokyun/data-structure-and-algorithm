## 1. Day2

[그리디/투포인터]
- Implements : 배운점
  - 다음 단계로 진행하는 과정/기준이 복잡하지 않다면 그리디를 먼저 생각할 것.
    - 이를 통해 최종적으로 도출한 해가 최적의 해라면 그리디가 확실하다.
    - 브루트포스처럼 보이지만 조건이 복잡하지 않고 요소를 동시비교를 하지 않기에 그리디.
  - 정규식을 사용하지 않는 이상, 내부적으로 패턴 객체를 생성하는 split보다 StringTokenizer가 유리할 수 있음.
    - StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
      int score1 = Integer.parseInt(tokenizer.nextToken());
      int score2 = Integer.parseInt(tokenizer.nextToken());
  - 조건을 만족하는 두개의 요소를 찾기 - "투포인터"
    - 배열을 정렬한다.   -> O(NlogN)
    - 각 끝 인덱스를 시작점/종점으로 하여 현재의 합을 기준으로 작으면 left를 증가하고 크면 right를 감소하는 방식으로 두 수를 찾아내는 방식
    - 현재의 합이 같다면 양쪽 포인터를 이동시킨다.
    - 한번의 스캔으로 끝나기에 O(N)의 시간복잡도를 가진다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - 브루트포스? 그리디?
    - 두 요소를 동시적인 비교 -> 브루트포스
    - 하나의 요소만 순차적 비교 -> 그리디
      - String str = "hello hello"; -> str.split(" ");
      - String str = "hello hello"; -> StringTokenizer(str, " "); -> token.nextToken(); + token.nextToken();
  - 투포인터 -> left = 0 index / right = N-1 index.
    - 현재 합이 X보다 작으면 left 증가,
      현재 합이 X보다 크면 right 감소,
      현재 합이 X와 같으면 count++ 후 양쪽 포인터 이동.
    - 한 번 스캔으로 끝나는 O(N) 알고리즘
- Additional : 추가적인 유의점들

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
