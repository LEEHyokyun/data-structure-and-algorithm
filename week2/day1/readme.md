## 1. Day1

[slice/정렬]
- Implements : 배운점
  - Arrays.copyOfRange(array, from, to) : array배열을 from번째(from-1 인덱스)부터 to이전(to-1 인덱스)까지
  - 배열 정렬 시 Array.sort(array) or Arrays.sort(Comparator.naturalOrder())
    - Arrays.sort(arr, Comparator
      .comparingInt(String::length)
      .thenComparing(Comparator.naturalOrder())
      );
    - char[] ch = br.readLine().toCharArray();
- Improvements : 막혔던 지점 / 고민한 포인트
  - 2중순회를 할 필요없이 1중 순회로도 충분하다.
    - 1중 순회 후 각 배열의 크기는 3개로 항상 고정
- Additional : 추가적인 유의점들
  - 