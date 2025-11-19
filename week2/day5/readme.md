## day5.

[스택(괄호)/타겟넘버(DFS/BFS)]
- Implements : 배운점
  - 문제를 푸는 "감"은 슬슬 오는 것 같은데 아직 구현능력은 좀 더 연습할 필요가 있다.
    - Stack을 활용한다.
    - 처음부터 )일 경우, return 이 없다면 이 분기를 타게되어 오류 발생(비어있는데 pop)..return false를 바로 진행한다.
- Improvements : 막혔던 지점 / 고민한 포인트
  - BFS와 DFS의 방안을 모두 고려할 수 있는 역량이 필요하다는 것을 느꼈음.
    - BFS로 풀 경우 Queue에 "이후 단계/인접 요소의 결과"와 필요 시(지금처럼) "기저조건 및 인덱싱"을 넣는다.
      - while(!q.isEmpty())
      - 어떠한 요소를 넣어야 하는지
        - 단일 요소를 넣는다면 q.offer(Integer)
        - 다중 요소(배열)을 넣는다면 q.offer(new int[]{0,0}) 
    - DFS로 풀 경우
      - while이 아닌 기저조건
      - top-bottom(재귀적 상향)인지, bottom-top인지 판단
      - bfs가 while문안에 단계적인 로직 수행, dfs는 재귀를 통해 단계적인 로직 수행
- Additional : 추가적인 유의점들
  - "DFS", "BFS"의 본질에 대해 먼저 느끼는 것이 중요하다.
  - BFS - Queue, DFS - Stack이 본질이 아니라, 단계적으로 어떠한 방법으로 수행하는지가 더 중요한 본질이다.
