## 1. Day1

[slice/정렬/Comparator]
- Implements : 배운점
  - 두 요소를 모두 비교해야 한다면 보통은 브루트포스이다.
  - 단순 요소/문자에 대한 정렬이라면 Comparator 고려한다.
    - Comparator로 정렬하면 “순서”는 만들 수 있지만, "순위"는 만들 수 없다.
    - 순위? -> brute force.
  - Comparator.comparingInt(String::length)
- Improvements : 막혔던 지점 / 고민한 포인트
  - class -> 예약어, 예약어 사용시 컴파일 오류 발생하므로 이것도 유의할 것.
  - StringBuilder에 append하는 개행은 싱글쿼터로 적용할 것.
    - sb.append('\n');
    - 더블쿼터로 입력 시 문자열로 인식해버린다.
- Additional : 추가적인 유의점들

[백준의 입력 및 출력 방법, Exception은 항상 기억에 두자.]

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
public static ... throws IOException

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
