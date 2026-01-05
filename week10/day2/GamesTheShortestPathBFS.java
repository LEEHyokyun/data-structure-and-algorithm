package week10.day2;

import java.util.ArrayDeque;
import java.util.Queue;

public class GamesTheShortestPathBFS {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int answer = 0;
        visited = new boolean[n][m];

        //bfs
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;

            int x = cur[0];
            int y = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue; //제한조건
                if(maps[nx][ny] == 0) continue; //벽

                if(maps[nx][ny] == 1){ //방문가능
                    if(!visited[nx][ny]){
                        maps[nx][ny] = maps[x][y] + 1; //경로누적
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }

                }
            }

        }

        answer = maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];

        return answer;
    }
}
