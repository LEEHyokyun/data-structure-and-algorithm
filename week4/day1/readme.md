## 1. Day1

[Char 정렬]
- Implements : 배운점
  - Char 관련 정렬
  - Char 관련 API
  - StringBuilder를 통한 역순 정렬
  - Long 또한 parseLong 가능하다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - Character 정렬 시, toCharArray 후, String 객체로 변환 후 StringBuilder로 정렬하거나
  - toCharArray 변환 후 리스트로 삽입한 후 sort 및 Comparator 등
- Additional : 추가적인 유의점들

[Character 관련 API]

char[] ch = string.toCharArray();

ch -> Character.isDigit(ch)..ch가 숫자형 문자인지 확인

[Character에 대한 정렬 대처법]

- charArray로 변환한 후 

char[] arr = String.valueOf(n).toCharArray();

- 해당 배열을 정렬한 후에 StringBuilder 측에서 역정렬(*new String 객체화)

Arrays.sort(arr);

StringBuilder sb = new StringBuilder(new String(arr)).reverse();

[StringBuilder에서 reverse() 사용하여 정렬]

StringBuilder sb = new StringBuilder(new String(arr)).reverse();

(sb.toString();



[문자정렬을 위한 Comparator 사용법]

Arrays.sort(arr, Comparator
.comparingInt(String::length) //함수
.thenComparing(Comparator.naturalOrder())
);

comparingInt -> "함수", 비교의 "기준"이다. 요소가 아니다. 
= comparingInt(String::length);
= comparingInt(x -> x.length());

```java
Arrays.sort(arr, Comparator
        .comparingInt(s -> s.length())
        .thenComparing(Comparator.naturalOrder()));
```

new Comparator를 직접 구현하는 방법도 존재한다.

```java
String[] arr = { "apple", "kiwi", "banana", "pear" };

Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        int lenCompare = Integer.compare(s1.length(), s2.length());
        if (lenCompare != 0) return lenCompare;
        return s1.compareTo(s2); // 길이 같으면 사전순
    }
});

System.out.println(Arrays.toString(arr));
```

반환값:

- result < 0 → a < b → a가 먼저
- result = 0 → a = b → 순서 유지
- result > 0 → a > b → a가 나중

즉, 양수일 때 순서를 바꾸게 됨

[Comparator 용법]

- 클래스 자체에 compareTo를 구현하거나, new Comparable을 사용하여 compareTo를 직접 구현하거나, Comparator를 활용한 체이닝 방식
- 보통은 Comparator의 방법을 고려할 것, 그 이후에 직접 구현하는 방식을 고려할 것
- Comparator.compringInt(람다식 or 요소의 타입을 활용) / thenComparing() / reversed()

| 구분                                 | 구현 방법                  | 코드 예시                                                                                                                                         | 설명                                                  |
| ---------------------------------- | ---------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------- |
| **Comparable**                     | 클래스 자체에 `compareTo` 구현 | `java class Person implements Comparable<Person> { int age; String name; public int compareTo(Person o) { return this.age - o.age; } } `      | 객체가 자기 자신 기준으로 정렬 가능. 기본 정렬 기준을 정의할 때 사용.           |
| **Comparator (익명 클래스)**            | 외부에서 비교 로직 구현          | `java Collections.sort(list, new Comparator<Person>() { public int compare(Person p1, Person p2) { return p1.name.compareTo(p2.name); } }); ` | 기존 클래스 수정 없이 외부에서 정렬 기준 지정 가능.                      |
| **Comparator (람다식)**               | 람다로 간결하게 구현            | `java Collections.sort(list, (p1, p2) -> p1.age - p2.age); `                                                                                  | Java 8 이후 간단하게 Comparator 정의 가능.                    |
| **Comparator 체이닝 (thenComparing)** | 여러 기준을 순차적으로 비교        | `java list.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName)); `                                                       | 나이 기준 정렬 후, 나이가 같으면 이름 기준 정렬. 복합 기준 정렬 가능.          |
| **Comparator static 메서드 활용**       | Comparator 내장 메서드 활용   | `java list.sort(Comparator.comparingInt(Person::getAge).reversed()); `                                                                        | 정렬 기준 int, double 등 특정 타입에 대해 편리하게 사용. 역순 정렬 등도 가능. |
