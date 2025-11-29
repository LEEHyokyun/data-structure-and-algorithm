## 1. Day2

[Char 연산]
- Implements : 배운점
  - char 관련 api 
  - char를 int로 바꾸거나 연산
  - "약수"하면 제곱근을 생각하기
    - for 순회를 1부터 진행, i*i or i < Math.sqrt(n)
    - 중근은 i*i == n 조건
    - 제곱근의 개수가 약수의 개수이다.
      - 이때 중근이 존재하면 무조건 홀수개, 존재하지 않으면 짝수개이다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - 약수개수는 두가지
    - Math.sqrt
    - 중근존재하는가

- Additional : 추가적인 유의점들

[char의 대문자/소문자 확인]

isUpperCase/isLowerCase

[char to int]

char c;

c - '0' -> char to int

[char 수(n)만큼 밀어내기]

char c;

- 소문자 : (c - 'a' + n) % 26 + 'a'
- 대문자 : (c - 'A' + n) % 26 + 'A'