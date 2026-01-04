## 1. Day2

[Greedy]
- 동전의 개수는 무제한 사용 가능하다.
- 동전 적절히 사용하여, 가치의 합을 특정한다.
  - 가장 큰 동전부터 선택하는 것이 곧 최적의 해
    - 큰 동전 선택 -> K / coins[i]
    - 나머지를 작은 동전으로 선택 -> k % coins[i]

[Comparator]
- (a,b) return a-b 사용하려면 반드시 Wrapper class 형태의 배열 사용 필요하다.
  - List<Integer> (o) List<int> (x)
- 이 외 활용방법
  - (a,b) -> b - a  (람다, 2차원 배열)
  - (a,b) -> {      (return, 중괄호({}))
    return b - a;
    }