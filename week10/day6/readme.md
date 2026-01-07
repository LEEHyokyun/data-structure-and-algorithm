[day6]

- 치킨집
  - 모든 경우의 수, DFS
  - graph에 대한 DFS가 아닌, 치킨집을 선택하는 경우에 대하여 DFS를 건다.
    - for(int i = start, i < chickens.size() ; i++){
      selected[i] = true;
      dfs(i+1, count+1);
      selected[i] = false;
      }
    - 치킨집 조합에 대한 DFS, DFS의 핵심은 시작점의 조정이다.
  - 기본 유의사항
    - List<int[]> .. List type
  - 거리 구하기
    - 치킨집 하나만 선택하는 것이 아니다.
    - 각 집에서, 가장 가까운 거리의 치킨집을 선택하는 것이 핵심, 따라서 순회 기준은 치킨이 아닌 집이 되어야 맞다.

- 던전 피로도
  - 기본적으로 순회하는 start가 증가하는 등 "동적으로" 모든 요소에 대해 탐색가능해야 한다.
    - dfs(start, ...) -> dfs(start + 1)
      - for(int i = start)
      - 이 경우 전체순회 불가( i = 1 ~ 2 일 경우 i = 0 에 대한 dfs 판단이 불가능해짐)
    - dfs(visited, ..) -> start를 지정할 경우 특히 배열의 상황에서 전체순회가 불가능 할 수 있음, visited로 판단필요.
      - for(int i = 0 , ..)
      - visited로 판단
        - 다음의 순회에서 현재의 i 이전의 i를 start 지점으로 갈 수 있는가
  - 가독성 있게 if true () {} 형태가 아니라, if false continue 형태로 작성하는 것이 좋을 듯.