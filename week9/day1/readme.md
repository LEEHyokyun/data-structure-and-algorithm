## 1. Day1

[binary search]

- 예산
  - 이진탐색 범위 갱신 시 left, right 기준이 아니라 mid를 기준으로!!
    - if(sum > K) right = mid - 1; //감소 시 상한선을 mid - 1
      else left = mid + 1;         //증가 시 하한선을 mid + 1
  - 단순히 로직을 구성하는 것이 아니라, 정답을 무엇을 어떻게 출력할 것인지도 고민
    - if(sum > K) right = mid - 1;
      else {
      answer = mid;
      left = mid + 1;
      }
    - 즉 예산이 k조건을 만족하였을때만 정답 후보군으로 저장해야한다.