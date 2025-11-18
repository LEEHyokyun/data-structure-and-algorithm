## Day3

[HashMap/ArrayList]
- Implements : 배운점
  - Queue를 이용하여 최초 풀었지만, LinkedList 구현체의 탐색 기능이 좋지 않다는 것에 유의한다.
    - linkedList.contains(num) -> O(N)
    - HashSet / Stream 사용하여 -> O(1)로 성능 개선 가능
      - q.offer, q.poll(num)
  - Stream을 활용하면 한 줄로, 성능도 가장 좋게 도출할 수 있으므로 우선적으로 생각해보는 연습을 하자.
  - ArrayList를 활용하였을때 당황하지 말자.
    - 최종적인 raw 배열 형태인 int[]로 바꿔준다(for 순회).
  - 사고력 키우기
    - for 순회
    - for(int i = 1 ; i < buildTimes.length ; i++){
      if(buildTimes[i] <= prev){
      count++;
      }else{
      result.add(count);
      count = 1;
      prev = buildTimes[i];
      }
      }

      //마지막 그룹을 반드시 넣어주어야 한다(클때만 "이전 그룹을" 추가하기에).
      result.add(count);
    - 로직을 구현하기위한 아이디어는 좋았으나 아직까지 구현이 미숙하기에 연습 필수. 
- Improvements : 막혔던 지점 / 고민한 포인트
- Additional : 추가적인 유의점들

[기본적으로 stream API의 toArray는 raw array 형태 그대로 반환한다.]
toArray();

[중복 제거 후 바로 배열(int[])로 반환해주는 API]
Arrays.stream(arr).distinct().toArray();

[필터링(이전 요소값을 기억하고, stream 돌면서 prev값이 다를 경우에 prev 대체)]
int prev = -1
Arrays.stream(arr)
.filter(n -> n != (prev = (prev == n ? prev : n))
.toArray();

[Math 연산]
- int/int = int 
  - int a = 7 / 2;
    System.out.println(a); // 3

- int/double = double
  - double x = 7 / 2.0;   // 3.5
    double y = (double)7 / 2; 

- 연산을 위해 연산요소의 형변환 및 연산결과의 형변환이 필요하다.

| 기능    | API                                     | 설명               |
| ----- | --------------------------------------- | ---------------- |
| 올림    | `Math.ceil`                             | double 기반 반환     |
| 내림    | `Math.floor`                            | double 기반 반환     |
| 반올림   | `Math.round`                            | long 반환          |
| min   | `Math.min(a,b)`                         | 두 값 중 작은 값       |
| max   | `Math.max(a,b)`                         | 큰 값              |
| 절대값   | `Math.abs(x)`                           | 음수 → 양수          |

[array/stream]

| API                           | 설명             | 예제                 |
| ----------------------------- | -------------- | ------------------ |
| `Arrays.sort(arr)`            | 오름차순 정렬        | int[], String[] 모두 |
| `Arrays.sort(arr, comp)`      | 커스텀 comparator | 문자열 문제 자주 등장       |
| `Arrays.copyOfRange(a, s, e)` | 구간 복사          | slice 기능           |
| `Arrays.equals(a, b)`         | 배열 비교          | BFS 방문 체크 등        |
| `Arrays.stream(arr)`          | 스트림 변환         | distinct, filter 등 |
