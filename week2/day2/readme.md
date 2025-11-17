## Day2

[HashMap]
- Implements : 배운점
  - HashMap이 성능적/구조적으로 훨씬 유리하며, getOrDefault/get/put/keySet/values/entrySet 등의 다양한 API 사용가능하다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - 최대한 여러가지 방안을 생각해본다.
    - for문을 계속 사용하기보다는 Arrays.sort 등을 이용해 푸는 방법도 있다.
- Additional : 추가적인 유의점들

[HashTable vs HashMap]

HashTable은 synchronized처리(동기화)로 인하여 put,get,containsKey의 API 호출 시 락을 건다.
따라서 단일스레드 환경에서 불필요한 오버헤드(성능저하)가 발생하여, 기본적인 성능차이가 발생한다.

HashMap은 Thread-unsafe하지만 유연하게 동기화 처리를 선택할 수 있다(Collections.synchronizedMap)
또한 공식적인 문서에서도 HashTable이 아닌 HashMap 혹은 concurrentHashTable 사용을 권장하고 있다.

또한 null 허용에 대한 차이도 존재한다.

| 자료구조          | null key  | null value |
| ------------- | --------- | ---------- |
| **HashMap**   | 1개 가능     | 여러 개 가능    |
| **Hashtable** | ❌ 지원하지 않음 | ❌ 지원하지 않음  |

이외 알아두면 좋을 API(코딩테스트에서 유용하게 사용 가능!)

| 기능               | **HashMap API**                  | **Hashtable API**                      | 차이                                        |
| ---------------- | -------------------------------- | -------------------------------------- | ----------------------------------------- |
| 값 추가             | put(K, V)                        | put(K, V)                              | 동일                                        |
| 값 읽기             | get(K)                           | get(K)                                 | 동일                                        |
| 기본값 포함 읽기        | getOrDefault(K, default)         | ❌ 없음                                   | HashMap만 제공                               |
| 키 존재 확인          | containsKey(K)                   | containsKey(K)                         | 동일                                        |
| 값 존재 확인          | containsValue(V)                 | contains(V) ← (구식 네이밍)                 | Hashtable은 containsValue의 옛날 이름이 contains |
| 삭제               | remove(K)                        | remove(K)                              | 동일                                        |
| 크기               | size()                           | size()                                 | 동일                                        |
| 비었는지             | isEmpty()                        | isEmpty()                              | 동일                                        |
| 전체 지우기           | clear()                          | clear()                                | 동일                                        |
| 키 Set            | keySet()                         | keySet()                               | 동일                                        |
| 값 Collection     | values()                         | elements() (Enumeration 리턴) / values() | Hashtable의 elements는 오래된 API              |
| 엔트리 Set          | entrySet()                       | entrySet()                             | 동일                                        |
| forEach          | forEach(BiConsumer)              | ❌ 없음                                   | HashMap만 제공(JDK1.8+)                      |
| null key         | 가능                               | 불가능                                    | 차이                                        |
| null value       | 가능                               | 불가능                                    | 차이                                        |
| 동기화              | ❌ 기본 비동기                         | ✔ 모든 메서드 동기화                           | 큰 차이                                      |
| 생성 시 초기화         | new HashMap<>()                  | new Hashtable<>()                      | 동일                                        |
| thread-safe로 만들기 | Collections.synchronizedMap(map) | 이미 동기화됨                                | HashMap이 유연                               |
