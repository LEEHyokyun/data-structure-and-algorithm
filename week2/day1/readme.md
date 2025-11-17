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
    - 불필요한 for문을 남발하지 않는다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - 2중순회를 할 필요없이 1중 순회로도 충분하다.
    - 1중 순회 후 각 배열의 크기는 3개로 항상 고정
  - Comparing 활용방안은 반드시 기억해두어야 한다(모르고있으면 구현 감이 아예 오지 않음)
    - Arrays.sort({raw_array}, Comparator.naturalOrder())
    - Arrays.sort({raw_array}, (s1, s2) -> {
        if(s1.charAt(n) == s2.charAt(n))
          return s1.compareTo(s2)
      })
    - charAt은 인덱스가 아닌 몇번째 자리 그자체를 의미한다.
- Additional : 추가적인 유의점들
  - 정렬기준(charAt / thenComparing)
    - Arrays.sort(strings, Comparator.comparing((String s) -> s.charAt(n))
      .thenComparing(s -> s));
