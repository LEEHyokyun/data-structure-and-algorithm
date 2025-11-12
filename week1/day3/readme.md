## 1. Day3

[괄호(스택)]
- Implements : 배운점 
  - sb.append(this.isBalanced(br.readLine())).append('\n'); -> !error: non-static variable this cannot be referenced from a static context
  - 문자열 - String, 단일문자 추출 - charAt, 단일문자 - char(원시) / Character(참조)
    - char 비교는 == 'c', character 비교는 equals(Object).
  - Stack 자료구조에는 참조자료형만 가능하며, 원시자료형인 char에 대해 Character 참조자료형을 사용한다.
  - BufferedReader를 사용할때 throws IOException을 자꾸 누락하는데 이 점 유의한다.
  - 더 복잡한 조건에서 분기처리를 어떻게 해야 하는가, else if에 조건을 넣으면 나머지 조건은 "무시"한다.
  - br.readLine()을 중복 호출하면 누락 발생..!(line=br.readLine())로 선언 및 변수할당 동시에, 그리고 그 할당 문자열을 그대로 활용한다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - JVM이 main을 실행하기위한 객체를 만들 시간이 없다.
    - 그렇기에 main은 static, 이에 대한 모든 함수는 static으로 호출해야 가능.
    - non static = 인스턴스 메서드, 지금 인스턴스가 없으니까? 오류 발생한다.
  - Stack 자료구조를 사용하라.
    - pop(), push(), peek() (*맨 위의 요소를 확인)
- Additional : 추가적인 유의점들
  - main은 객체 없이 실행되는 static 메소드로, main 내부에서 직접 호출하려면 그 호출 함수도 무조건 static이어야 하며, 당연히 this를 통한 접근도 불가능하다(애초에 객체가 아니므로). 
  - public "static" void main
    - 나는 지금 이 함수를 "객체 없이" 부르고 있는가? → 그렇다면 static
    - 나는 이 함수를 "객체에서 수행되는 기능"으로 사용하려는가? → 그렇다면 non-static
    - main은 static이므로 객체 없고 this 없음 → static 아닌 메서드를 쓰려면 객체를 만들어야 함
    - non-static을 호출한다는 것 자체가 그 객체의 "상태"를 정의하는 행위, static은 객체없이 호출하므로 non static한 함수를 호출하는 것은 모순.
  - 원시자료형은 비교시 ==, 참조자료형은 비교시 equals

| 타입                | 예시                                       | 비교 권장 방식                      | 이유                                                                 |
| ----------------- | ---------------------------------------- | ----------------------------- | ------------------------------------------------------------------ |
| `char` (기본형)      | `'('`, `'A'`                             | `==` 사용                       | 원시타입은 값 비교 → `==`가 정확하고 빠름                                         |
| `Character` (참조형) | `Character ch`, `Character.valueOf('A')` | **가능하면 `==`, 필요시 `equals()`** | 오토박싱된 Character는 내부 캐싱 때문에 `==`로 비교 가능. 하지만 캐시 범위 밖이면 equals가 안전함. |

| 질문                  | 답                                                     |
| ------------------- | ----------------------------------------------------- |
| 왜 static을 붙여야 해?    | main은 객체 없이 실행되므로, main 내부에서 직접 호출하려면 함수도 static이어야 함 |
| 언제 static을 쓰는가?     | **객체에 속하지 않고, 클래스 차원에서 공통적으로 쓰일 때**                   |
| 언제 non-static을 쓰는가? | **객체가 고유하게 가지는 상태(state)나 행동을 나타낼 때**                 |

참고로 이런 호출 방법도 있음(static main에서 main 객체를 만들고 이 메인 객체에서 만든 함수를 non-static하게 호출)

```java
public static void main(String[] args) {
Main m = new Main();
sb.append(m.isBalanced(br.readLine()));
}
```

static 함수로 설계하는 것은 상태(state)가 필요 없는 로직성 함수일 때.
반대로, 상태(필드, 누적값, 방문 배열 등) 를 유지해야 한다면 → 클래스 필드 + non-static 메서드 조합으로 바꿔야 함.

이외 유사한 패턴 : 문자열처리(후위표식/문자열뒤집기), 오큰수/오큰등수, 계산기 구현

| 유형     | 예시 문제          | 핵심 아이디어                      |
| ------ | -------------- | ---------------------------- |
| 괄호 유효성 | `()` `[()]` 등  | 여는 괄호 push, 닫는 괄호 시 pop      |
| 문자열 처리 | 후위표기식, 문자열 뒤집기 | 임시 저장 및 역순 처리                |
| 수열 문제  | 오큰수, 오등큰수      | "이전 값보다 큰/작은 값"을 찾기 위한 보조 기억 |
| 계산기 구현 | 수식 계산          | 연산자 우선순위 판단용                 |
