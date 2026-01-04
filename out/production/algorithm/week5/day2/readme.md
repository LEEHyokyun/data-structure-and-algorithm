## 1. Day2

[Sliding Window/원형수열]
- Implements : 배운점(문제)
  - Sliding Window
    - 연속된 데이터(배열, 문자열 등)에서 고정된 범위(윈도우)를 유지한 채 위치를 한 칸씩 이동하며 값을 효율적으로 계산하는 기법.
    - 구간을 통째로 계산하지 않고 단순순회를 하지 않으며, 빠지는 값만 빼고 들어오는 값만 더하는 방식.
    - 길이 N인 배열에서 연속된 K개의 합 최대값을 구하고자 할 때,
      - O(N*K) -> O(N)
      - i-X 제거, i 추가
  - sliding window
    - 연속된 구간
    - 구간/부분배열의 크기 고정
    - 최대/최소
  - binary search
    - 답의 범위를 좁혀가거나
    - 최적의 해를 가변범위를 통해 조정해나간다.
  - 원형수열
    - 선형수열은 1번 순회로 종료, 원형수열은 1번 순회 후 이론상 인덱스의 끝이 존재하지 않는다.
    - 배열이 한번더 붙어있는 형태.
      - len = 1 ~ N-1
      - range = len ~ len + N -1
        - i - len 제거, i 추가
- Improvements : 작동원리/개선포인트(본질)
  - sliding window vs two pointer
    - sliding window는 고정길이 만큼의 합산
    - 가변길이 윈도우는 보통 "투포인터"라 불리운다.
- Additional : 추가적인 유의점들

[고정길이]

```java
int sum = 0;

// 1. 초기 윈도우 구성
for (int i = 0; i < k; i++) {
    sum += arr[i];
}

int max = sum;

// 2. 윈도우 이동
for (int i = k; i < n; i++) {
    sum = sum - arr[i - k] + arr[i];
    max = Math.max(max, sum);
}
```

[투포인터]

```java
int left = 0, sum = 0;

for (int right = 0; right < n; right++) {
    sum += arr[right];

    while (sum >= target) {
        answer = Math.min(answer, right - left + 1);
        sum -= arr[left++];
    }
}
```

[자료구조를 사용할때 원시타입 > Wrapper타입으로 변환 유의사항]

| primitive | wrapper     |
| --------- | ----------- |
| `int`     | `Integer`   |
| `long`    | `Long`      |
| `double`  | `Double`    |
| `float`   | `Float`     |
| `boolean` | `Boolean`   |
| `char`    | `Character` |
| `byte`    | `Byte`      |
| `short`   | `Short`     |
