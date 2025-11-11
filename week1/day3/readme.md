## 1. Day2

[정렬/계수정렬(Counting Sort)]
- Implements : 배운점 
  - 입력받을때 BufferedReader = BufferedReader(new InputStreamReader(System.in)) 흐름으로 입력받는다.
  - 출력시 StringBuilder 및 System.out.println(StringBuilder) 흐름으로 출력한다.
  - char[]을 활용한 정렬일 경우(br.readLine().toCharArray()) Comparator사용불가, sort(정방향 정렬) 사용 및 자체구현한다.
  - "정렬"은 ArrayList가 편하고 성능적으로 가장 유리하다. "중복제거"라 해서 Set 자료구조를 이용하는것은 기능적/성능적으로 불리하다.
  - Arrays.sort의 평균적인 시간복잡도는 O(NlogN), 계수정렬을 사용할 경우 O(N+K)로, mot num이 작다면 Arrays.sort보다 성능적으로 유리할 수 있다.
  - 빈도 기반 통계 알고리즘(계수정렬)을 활용하는 순간, 인덱스로 인해 "값의 순서는 보장"하며 이에 따라 빈도수 및 더미값(최초 초기값 = 0)이 저장된다.
  - 중앙값과 최빈값은 계수배열의 빈도수를 활용하여 알고리즘을 구현한다. 
- Improvements : 막혔던 지점 / 고민한 포인트
  - 입출력부터 고민했는데 표준적인 방법을 알았고 이를 적극 활용하고자 함.
  - 정렬 등을 위해선 기본적으로 최대한 원시자료형(Integer보다는 int)을 활용하도록 해야 함.
    - Integer는 int를 Wrapping한 Wrapper 클래스로, 비교연산이 추가되어 오버헤드가 증가한다.
  - 계수정렬의 개념과 이를 구현하는 방법에 대해 알 수 있었음.
- Additional : 추가적인 유의점들
  - 계수정렬의 시간복잡도는 O(n+k)이고, Arrays.sort는 평균적으로 O(nlogn)), 단, n은 데이터의 개수, k는 데이터의 범위.
  - 데이터의 범위가 작다면 계수정렬이 유리할 수 있다.
