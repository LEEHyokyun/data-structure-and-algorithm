## 1. Day6

[Greedy/stack]
- Implements : 배운점
  - k개의 수를 제거하여 큰 값 만들기
    - 단순 비교로 할 경우 O(N^2), 주어진 값의 크기가 매우 커서 적절하지 않은 방법인 것을 파악한다.
  - 일전과 마찬가지로, "이전의 값"과 비교하기 위해서 stack.push는 비교 이후에 진행한다.
  - 알파벳 만들기
    - 최종적으로는 상하/좌우 각각의 비용의 최소값을 추출하여 더하면 된다.
      - 알파벳 거리 계산 후 최소값 선택
        - A에서 시작하여 오름차순으로 탐색하느냐, Z에서 시작하여 내림차순으로 탐색하느냐.
      - A구간은 단순한 커서 이동이 핵심
        - 이미 이 단계에서 알파벳을 모두 바꾼 상태라 가정하고, 훑는 경우의 수에 대해 생각하는 것이다.
          - 단순히 정방향으로 건너뛰느냐, 역방향으로 턴해서 탐색하느냐.
          - minMove는 “여러 가능한 전체 경로(전략)”들 각각의 총비용을 계산해서 그중 최솟값을 저장하는 것이다.
            각 i는 서로 다른 전체 경로 전략(“i까지 진행한 뒤 꺾는 전략”) 하나를 대표하므로, i를 순회하며 어떤 i에서든 더 작은 총비용이 나오면 그 전략이 전체에서 더 낫다는 뜻이다. 그래서 교체하는 것이 맞고, 어떤 i가 무조건 배제되는 일은 없다 — 모든 i에 대해 비교하기 때문이다.
          - 모든 경로를 비교(탐색)하기도 하고, 그 i는 이전의 최적해를 반영할 수 있기에 min값으로 대체하는 것이 올바른 방향이다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - Stack -> String
    - 단순히 for(char num : stack) StringBuilder.append(num);
    - 이후 sb.toString()을 활용하여 결과 출력한다.
- Additional : 추가적인 유의점들

> char ch가 주어졌을때

[frequently]

- 해당 문자가 숫자인가 : char.isDigit(ch);
- 문자의 A 혹은 Z로부터 떨어진 거리를 숫자화 : Math.min(c - 'A', 'Z' - c + 1)
- 문자의 숫자화 : Integer.parseInt(c - '0')
- char를 숫자만큼 밀어내기 : c - 'a' + n or c - 'A' + n or 'Z' - a + n + 1

[단일 숫자문자를 숫자화]

int num = c - '0';

[알파벳 인덱스의 정수화]

- int idxLower = c - 'a'; // 소문자
- int idxUpper = c - 'A'; // 대문자

[알파벳 n만큼 밀기]

- char shifted = (char)((c - 'A' + n) % 26 + 'A');

[문자를 숫자로 해석. '0'~'9', 'A'~'Z' 등 모두 지원]

- int num = Character.getNumericValue('7'); // 7

[지정한 진법(radix) 기준으로 문자 숫자를 파싱]

- int num = Character.digit('F', 10); // 6

[문자열을 이용한 변환]

- int num = Integer.parseInt(String.valueOf(c));
- int num = c - '0';   // 숫자 문자일 때만 가능 (0~9)

[ASCII]

- int code = (int) c; // ASCII 또는 Unicode
- (int) 'A' = 65

| 사용 방식                              | 예시          | 설명                    |
| ---------------------------------- |-------------| --------------------- |
| `c - '0'`                          | 숫자 문자 → 0~9 | 가장 빠름                 |
| `c - 'A'`                          | 알파벳 인덱스     | A=0~Z=25              |
| ` c - 'a' + n or c - 'A' + n`              | 밀기(숫자)      | 시저 암호                 |
| `(c - 'A' + n)%26 + 'A'`           | 밀기(알파벳)     | 시저 암호                 |
| `Character.getNumericValue(c)`     | `'A' → 10`  | 문자 숫자 전부 지원           |
| `Character.digit(c, radix)`        | 16진수 등      | 진법 지원                 |
| `Integer.parseInt(String.valueOf(c))` | 문자열 기반      | 느리지만 범용               |
| `(int)c`                           | 코드 값        | ASCII/Unicode 값 직접 사용 |
