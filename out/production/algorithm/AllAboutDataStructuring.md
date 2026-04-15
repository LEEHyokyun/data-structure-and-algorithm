## HashMap

- Key → Value 매핑, 조회/존재확인, 빈도

> get(key) > 값 조회, 없으면 null 반환(NPE..분기처리 필수)

> containsKey(key) > key 존재 여부 확인 (코테에서 가장 많이 씀)

> containsValue(value) > value 존재 여부 (시간복잡도 O(n)) (그리 많이 사용하지는 않으나 지엽적 활용 가능성)

> put(key, value) > 삽입 또는 덮어쓰기(*set이 따로 없으므로 get 이후 count++하여 다시 put)

> keySet() > 모든 key 순회용

> values() > 모든 value 순회용

## HashSet

- 중복방지, 결과 임시저장용(contains 성능 GOOD), 존재여부 확인

> add(e) > 존재 시 false, 아니면 true(즉 set 자료구조에 넣되 중복될 경우 false 반환, 중복 불허)

> contains(e) > 존재 여부 확인 (O(1)) .. 성능 GOOD, 중복방지/빈도관리가 아니라면 무조건 Set 활용

## Comparator 활용 정렬 및 람다식 기반 정렬

- 오름차순

> Collections.sort(list); / list.sort(Comparator.naturalOrder());

- 내림차순

> list.sort(Comparator.reverseOrder());

- 일반적인 정수 정렬

> list.sort((a, b) -> a - b);        // 오름차순

> list.sort((a, b) -> b - a);        // 내림차순

> list.sort(Integer::compare);

- 문자 정렬

> list.sort(String::compareTo);

- 정수/문자 동시 적용 가능

> list.sort((a,b) -> a.compareTo(b)) //a -> b 오름차순 정렬(내림차순은 b.compareTo(a))

- 객체 길이 정렬

> list.sort((a, b) -> a.length() - b.length());

- 리스트(list) > (문자열) 배열 형태로 반환

> String[] arr = list.toArray(new String[0]); //list.of("A" "B") -> ("A", "B") (문자열 배열 형태로 형변환)

## 요약본

- Map and Set

| 자료구조    | API                  | 설명              | 
| ------- | -------------------- | --------------- |   
| HashMap | get(key)             | 값 조회 (없으면 null) |  
| HashMap | containsKey(key)     | key 존재 여부       |  
| HashMap | containsValue(value) | value 존재 여부     |  
| HashMap | put(key, value)      | 삽입 / 갱신         | 
| HashMap | keySet()             | key 전체 순회       | 
| HashMap | values()             | value 전체 순회     | 
| HashSet | add(e)               | 값 추가 (중복 X)     | 
| HashSet | contains(e)          | 존재 여부 확인        | 
| HashSet | get(e)               | ❌ 존재하지 않음       |

- ArrayList

| 방식            | 코드                                     | 용도 |
|---------------|----------------------------------------|  |
| 기본 정렬         | `Collections.sort(list)`               | 오름차순 |
| 기본 Comparator | `list.sort(Comparator.naturalOrder())` | 오름차순 |
| 람다식           | `(a, b) -> return a - b`                      | 간단 정렬 |
| 문자형           | `a.compareTo(b)`                       | 정수/문자열 적용 가능 |
| 내림차순          | `list.sort(Comparator.reverseOrder())` | 역정렬 |

* 참고 : Integer::compare, String::compareTo

| 변환               | API                           |
|------------------| ----------------------------- |
| List -> String[] | `list.toArray(new String[0])` |
