package week9.day5;

import java.util.ArrayDeque;
import java.util.Queue;

public class MiroLeverAndExit {
    static int[] start;
    static int[] dest;
    static int[] lever;
    static char[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(String[] maps) {

        int row = maps.length;
        int col = maps[0].length();
        graph = new char[row][col];

        for(int i = 0 ; i < row ; i++){
            graph[i] = maps[i].toCharArray();

            for(int j = 0 ; j < col ; j++){
                if(graph[i][j] == 'S') start = new int[]{i,j,0};
                if(graph[i][j] == 'E') dest = new int[]{i,j};
                if(graph[i][j] == 'L') lever = new int[]{i,j,0};
            }
        }
        //1차(S->L)
        int r1 = bfs(row, col, start, lever);
        if(r1 == -1) return -1;
        //2차(L->E)
        int r2 = bfs(row, col, lever, dest);
        if(r2 == -1) return -1;

        return r1+r2;
    }

    int bfs(int row, int col, int[] from, int[] to){

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        q.offer(from);
        visited[from[0]][from[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            if(x == to[0] && y == to[1]){
                return time;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, time + 1});

            }
        }

        return -1;
    }
}
