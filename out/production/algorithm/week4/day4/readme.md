## 1. Day4

[Math연산과 구현/브루트포스&Stack]
- Implements : 배운점
  - 걸리는 시간을 순회하면서 이전보다 작거나 같으면 count++, 크다면 prev를 그 값으로 교체 및 count = 1 초기화.
    - 최종 count는 별도로 반영해주어야 한다.
  - arrayList와 array의 적절한 활용도 필요
- Improvements : 막혔던 지점 / 고민한 포인트
  - 걸리는 시간을 도출할떄 반드시 최종 연산에 대해 올림처리 한다(Math.ceil)
    - Math.ceil(100.0 -+/%..) -> 올림
    - Math.floor(100.0 -+/%..) -> 내림
    - Math.round(100.0 -+/%..) -> 반올림
  - 경계조건 등 막히는 부분이 생기면 쉬운 예시를 먼저 생각해보자.
    - 예를 들어, [3,1]과 같은 쉬운 예시를 생각해보자.
    - 가격이 떨어지지 않은 항목들
      - time = length - 1 - top
  - 브루트포스와 다른 효율적인 방안을 고민해야 하는 경계점은
    - N = 100,000
- Additional : 추가적인 유의점들

[Math 연산과 반환타입]

| 기능          | 메서드    | 매개변수 타입                  | 반환 타입         |
| ----------- | ------ | ------------------------ | ------------- |
| 절댓값         | abs    | int, long, float, double | 동일 타입         |
| 부호(양수/음수/0) | signum | float, double            | float, double |
| 최대값         | max    | int, long, float, double | 동일 타입         |
| 최소값         | min    | int, long, float, double | 동일 타입         |

| 기능                         | 메서드   | 매개변수 타입                    | 반환 타입      |
| -------------------------- | ----- | -------------------------- | ---------- |
| 올림(ceiling)                | ceil  | double                     | double     |
| 내림(floor)                  | floor | double                     | double     |
| 반올림                        | round | float → int, double → long | int / long |
| 소수점 버림                     | rint  | double                     | double     |
| 정수로 캐스팅과 가장 가까운 정수(double) | rint  | double                     | double     |
