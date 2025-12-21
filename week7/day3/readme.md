## 1. Day3

[DFS/BFS]
- DFS/BFS
  - 미로찾기(2차원 배열)과 같이 갈 수 있는 방향/인접노드가 정해져 있을때.
    - dx, dy
    - boolean을 하지 않고도, maps를 활용하여 count 바로 적용 및 이 배열 자체를 visited로 활용.
      - 다음 갈 수 있는 인접노드 = for 순회
        - for(int i = 0 ; i < 4 ; i++){
          int nx = x + dx[i];
          int ny = y + dy[i];
  - boolean[] visited 필수!
    - Arrays.fill -> 1차원 기본, 할려면 for 순회 필요
    - boolean의 기본값은 false..visited에 대해서는 별도 초기화는 필요 없다.

[유의사항]
- Queue -> ArrayDeque / Stack -> Stack
- 정렬
  - List<Integer> -> Collections.sort
  - List<int> -> Arrays.sort