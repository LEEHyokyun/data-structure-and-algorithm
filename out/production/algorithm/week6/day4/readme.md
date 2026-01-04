## 1. Day4

[DFS/BFS]
- Notes
  - 연결요소 = 인접요소를 거쳐가면서 도달 가능한 점의 "집합"의 개수(=덩어리 개수)
  - 노드 개수 N ≤ 1000, 간선의 개수 M ≤ 10000 
    - "그래프 정보를 저장하는 graph" -> 반드시 기본 배열(행렬)이 아닌 arrayList로 저장한다.
    - visited -> 일반 배열(행렬) 상관없음 = 노드의 개수.
  - 변수 초기화를 전역으로 할 것 인지, bfs를 순회할 때마다 새로운 변수 리스트를 초기화 할 것인지.
  - bfs 순회조건(*경우에 따라 간결한 조건으로 구성할 것)
    - !visited -- 애초부터 방문한적이 없는 노드만 방문하거나
      - 조건을 불만족하는 경우에는 continue하는 방법(전력문제의 경우 cur - cutU, next - cutV인 경우만 가능하므로 이 경우만 continue, cur = cutV인 경우는 아예 불가능)
        - if(visited[next]) continue; && if((cur == cutU && next == cutV)) continue;
        - u,v 사이의 간선을 제거하였기에 cur의 인접노드가 curU/curV 조합이면 q에 넣으면 안되고 생략해야 함
          if((cur == cutU && next == cutV) || (cur == cutV && next == cutU)) continue;
      
[접근방향]
- BFS/DFS의 문제(연결요소 및 단지 수 등)는 웬만하면 BFS로 푸는 것을 권장
  - 두가지 방법 모두 가능한 상태에서 DFS 활용 시 메모리 문제 생길 가능성 있음.

[additional]
- this 변수에 대한 N/n(대소문자 구분)은 불가..static N -> N = n; 불가능(NPE)
- this.n = n ; (동일 변수, this로 구분하는 것은 가능)

[graph 초기화 시 NPE 발생 가능 유의]
- static List<Integer>[] graph;
- 가로 초기화 세로 초기화가 모두 필요하다.
  - graph = new ArrayList[n+1]; (행 초기화)
  - for(int i = 1 ; i <= n ; i++){
    graph[i] = new ArrayList<>();
    }
  - (열초기화)