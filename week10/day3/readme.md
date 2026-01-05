[day3]

[BFS]
- 다른건 모두 동일한데, 누락한 사항 상기차원에서 정리
  - 강수량을 최소, 최대 -1까지 bfs 모두 순회
    - 강수량 범위 자체를 "아예 오지 않은 경우"도 포함해야 한다.
      - min - 1 
      - min부터는 잠길 수 있으므로, min ~ max - 1(모두 잠기는 건 의미 없음)
        - bfs를 진행하는 조건 : 방문하지 않았고, 강수량이 0 초과일 경우에만
          - if(!visited[i][j] && graph[i][j] - k > 0){
            count++;
            bfs(visited, graph, new int[]{i,j}, k, N);
            }
        - continue 하는 조건
          - 기본 : 범위/방문여부
            - if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
              if(visited[nx][ny]) continue;
          - 인접범위의 마을이 물에 잠겨져 있는 경우 
            - if(graph[nx][ny] - K <= 0) continue;
        - 강수량 조건은 bfs진행하는 조건, bfs 내부 continue 조건에 모두 넣어야 함

- 전력망 나누기
  - 단순 2차원 그래프가 아닌 "연결관계" "트리"
    - list[] .. list[i] = new ArrayList<>();
  - graph 
    - 기존 2차원 -> 1차원 List<Integer>[] + graph[i] = new ArrayList<>();
    - 노드 u에 대한 인접노드 v .. n+1
  - visited
    - 노드 u 지나쳤는지 .. n+1
    - 어찌되었든 visited 방문여부는 반드시 필요하다.
  - for 순회
    - 끊어졌을때의 관계, 인접노드의 관계가 끊어짐의 관계라면 continue
  - 최종 도출 시 인접노드 개수 도출하고, 차이점은..n-count가 아니라, n-2count 형태이다.