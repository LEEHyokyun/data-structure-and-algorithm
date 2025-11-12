## 1. Day4

[Queue]
- Implements : 배운점 
  - Stack
    - 구현체 : Stack
    - 기능 : pop(), push(), peek()
  - Queue
    - 구현체 : LinkedList, PriorityQueue
    - 기능 : poll(), offer(), peek()
  - Deque
    - 구현체 : LinkedList, ArrayDeque
    - 기능 : poll(), offer(), peek(), offerFirst(), pollFirst()
  - 문자열 분리
    - StringTokenize command = new StringTokenize(String, {분리요소});, 문자열을 분리요소를 기준으로 분리한다.
    - command = nextToken, 만약 분리요소가 없어서 분리할 문자열이 없다면 NSE(No Such Element) 발생한다.
  - 
- Improvements : 막혔던 지점 / 고민한 포인트
  - 결과누적을 위해 Deque 구현체를 전역적으로 설정하고 매개변수로 전달
  - StringBuilder 출력 시 출력요소는 String, Int, Integer 모두 가능하므로 문제 상황에 맞게 구성.
  - while(i-- > 0) i회 순회, for 순회조건을 구성하는 것보다는 가독성 및 간결성에서 유리
  - switch - case
    - switch-case 문에 개별적으로 return을 두는 것이 아닌 전역적인 변수를 취하여 할당하고 최종적으로 return 하는 방식으로 진행 필요, 혹은 함수를 따로 두지말고 모든 로직을 일원화(push의 경우 문자열을 출력하지 않으므로).
    - 더 중요한 것은 switch case가 적당할 것인지, if가 적당할 것인지 구분하는 판단력.
- Additional : 추가적인 유의점들
  - java
    - 자바에서는 같은 이름의 클래스나 인터페이스가 동일한 클래스 내에 위치한다면, 현재 파일 내에서 선언(클래스화)된 이름이 우선순위를 갖는다.
    - java.util.Deque 를 그대로 쓰면 **“이 파일 안의 Deque 클래스”**를 가리키므로 저 경로를 명시하던지, 혹은 클래스 이름을 바꾸던지.
  - 유용한 사이트(반드시 참조!)
    - https://st-lab.tistory.com/186
