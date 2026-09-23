package week35;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecochatRobotByBFS_장애물_만날때까지_계속_이동하기 {
    static boolean[][] visited;
    static int[][] graph;
    static int[] start;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(String[] board) {
        /*
         * R -> 시작 위치
         * G -> 목표 위치
         */
        int row = board.length;
        int col = board[0].length();

        visited = new boolean[row][col];
        graph = new int[row][col];

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                char ch = board[i].charAt(j);

                if(ch == 'D') graph[i][j] = -1; //장애물
                else if(ch == 'R') start = new int[]{i,j}; //목표지점
                else if(ch == 'G') graph[i][j] = 2;
                else continue; //0
            }
        }

        return bfs(start, row, col);
    }

    static int bfs(int[] start, int row, int col){

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int res = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(graph[x][y] == 2) return count;

            for(int i = 0 ; i < 4 ; i++){

                int nx = x;
                int ny = y;

                while(true){

                    int nnx = nx + dx[i];
                    int nny = ny + dy[i];

                    //못가면 다른 방향으로 이동해야 함(현재 위치 그대로 유지, nx:ny)
                    if(nnx < 0 || nny < 0 || nnx >= row || nny >= col) break;
                    if(graph[nnx][nny] == -1) break;

                    //아니면 그대로 누적
                    nx = nnx;
                    ny = nny;

                }

                if(nx == x && ny == y) continue; //못가면 다음 방향
                if(!visited[nx][ny]) {
                    //갔으면 q.offer
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, count + 1});
                }
            }

        }

        return -1;
    }
}
