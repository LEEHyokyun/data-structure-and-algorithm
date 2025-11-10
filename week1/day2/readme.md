## 1. Day2

[단어정렬/정렬]
- Implements : 배운점 
  - 입력받을때 BufferedReader = BufferedReader(new InputStreamReader(System.in)) 흐름으로 입력받는다.
  - 출력시 StringBuilder 및 System.out.println(StringBuilder) 흐름으로 출력한다.
  - String을 활용한 정렬일 경우 Comparator(Override 패턴 및 Builder 패턴)을 적극 활용한다.
  - char[]을 활용한 정렬일 경우(br.readLine().toCharArray()) Comparator사용불가, sort(정방향 정렬) 사용 및 자체구현한다.
  - 각 기능별 모듈경로보다는 통합적인 모듈경로를 사용한다(import java.io.*, import java.util.*와 같이)
  - String - length(), 이외 int/Integer/char[]/Character 모두 length
  - "정렬"은 ArrayList가 편하고 성능적으로 가장 유리하다. "중복제거"라 해서 Set 자료구조를 이용하는것은 기능적/성능적으로 불리하다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - 입출력부터 고민했는데 표준적인 방법을 알았고 이를 적극 활용하고자 함.
  - 정렬 등을 위해선 기본적으로 최대한 원시자료형(Integer보다는 int)을 활용하도록 해야 함.
  - String, char에 대한 정렬기준을 세울 수 있었음.
  - Comparable(implements하여 내부적으로 정렬기준 구현), Comparator(외부에서 주입하는 정렬기준)의 개념과 사용방법에 대해 구분할 수 있었음.
  - Comparator 사용 시 체이닝을 활용하여 ComparingInt . thenComparing(Comparator.naturalOrder()) 등으로 더 간결하게 작성 가능하였음.

- Additional : 추가적인 유의점들

| 구조         | 정렬 적합성   | 이유                                             |
| ---------- | -------- | ---------------------------------------------- |
| ArrayList  | 👍 매우 적합 | **연속된 메모리 → Random Access 빠름 → 정렬 알고리즘과 잘 맞음** |
| LinkedList | 👎 부적합   | 노드 이동이 빈번해 정렬 알고리즘과 매우 비효율적                    |
| HashSet    | 정렬 불가    | 정렬 정보가 없음                                      |
| TreeSet    | 정렬 가능    | 하지만 삽입할 때마다 정렬 유지 → **비용이 더 큼**                |
