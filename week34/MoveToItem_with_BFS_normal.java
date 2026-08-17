package week34;

import java.util.ArrayDeque;
import java.util.Queue;

public class MoveToItem_with_BFS_normal {
    //static boolean[][] visited;
    //static int[][] graph;

    static int[][] graph = new int[102][102];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        /*
         * 초기캐릭터위치 -> 아이템 위치로 가는데 필요한 최단 거리
         * 전형적인 BFS
         */
        /*
         * 그래프를 만들고 테두리를 만들었을때
         * 직사각형의 테두리로만 이동 가능하다.
         * 좌표 2배 = 기존 표현할 수 없었던 겹치는 부분을 정의할 수 있다(좌표체계를 2배로).
         */
        characterX = characterX * 2;
        characterY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;

        //그래프 표현
        for(int[] r : rectangle){

            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for(int x = x1 ; x <= x2 ; x++){
                for(int y = y1 ; y <= y2 ; y++){
                    graph[x][y] = 1;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        int[][] distance = new int[102][102];
        boolean[][] visited = new boolean[102][102];

        q.offer(new int[]{characterX, characterY});
        distance[characterX][characterY] = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            if(x == itemX && y == itemY){
                return (distance[x][y]) / 2;
            }

            for(int i = 0 ; i < 4 ; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == 0) continue;

                distance[nx][ny] = distance[x][y] + 1;
                q.offer(new int[]{nx,ny});

            }

        }

        return -1;
    }
}
