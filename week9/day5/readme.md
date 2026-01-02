## 1. Day5

[BFS]

- 체스 나이트
  - visited true를 하는 로직이 중복누적될 경우 메모리 초과 오류 발생할 수 있다.
    - 처음에 1번, 순회 직전에 1번
    - DFS처럼 path를 누적하는 상황?
      - new int[]{x,y,path} 처럼 아예 3개를 전달하는 것도 방법이다.
- 미로 탈출
  - 항상 먼저 "초기화"한 이후에 할당해줄 것.
    - graph = new char[row][col];
      for(int i = 0 ; i < row ; i++){
      graph[i] = maps[i].toCharArray();

            for(int j = 0 ; j < col ; j++){
                if(graph[i][j] == 'S') start = new int[]{i,j,0};
                if(graph[i][j] == 'E') dest = new int[]{i,j};
                if(graph[i][j] == 'L') lever = new int[]{i,j};
            }
      }
  - > BFS의 핵심 BFS 1번 = 그 지점 > 지점의 최소경로/최소시간만 보장, 만약 거치는 경로가 n회? bfs n회 진행 필요하다. 
  - 이동하지 못하는 경우는 어떻게 판단해야 하는가?
    - 도착했을때 isFounded =  true..이 boolean 변수로 판단하자(간단하게)
    - 레버를 돌렸다고 하더라도 " 다시 지나갈 수 있다는 것"이 핵심이다. "다시 지나갈 수 있다"
      - START -> LEVER -> time 누적 OK
      - LEVER -> EXIT -> 여기서부터 새롭게 해서, 사실상 새로운 visited 상태로 time 누적해야함
        - 즉 S > L 의 bfs 결과와 L > E 의 결과를 각각 누적해야한다.
        - 당연히 visited도 이에 따라 새로 갱신해주어야 한다.
          - 어느 지점이든 "여러번 지나갈 수 있다"가 핵심.
    - bfs의 return 형태는 int .. 구하였으면 return (dfs가 아니므로 백트래킹 고려 X)
      - 만약 위 경로를 다했음에도 return 못했다? 경로 못찾은 것, -1 반환
        - (S > L or L > E) 둘 중 하나라도 -1 반환? return -1.

- String[] maps
  - maps.length  (String[])
  - maps.length() (String)

[전역 변수 남발 금지]

- ASIS : 레버위치를 찾았다고해서 이를 전역변수를 true로 고치면 안됨, 하나로 이어지는 경로에 대해서만 관리해야 한다.
  - 전역적으로 관리할 경우 경로관리가 안된다. 반드시 한 경로당 하나의 변수로만 관리할 것.

```java
if(x == lever[0] && y == lever[1]){
                isFinished = true;
            }
            
            if(x == dest[0] && y == dest[1] && isFinished){
                answer = time;
                isFounded = true;
                return;
            }
```