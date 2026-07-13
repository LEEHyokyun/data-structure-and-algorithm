package week29;

import java.util.ArrayDeque;
import java.util.Queue;

public class Minumum_Distance_bfs {
    /*
     * bfs
     * - 거리 누적, 이미 지나간 곳은 진행하지 않는다.
     */

    static int[][] graph;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;

        distance = new int[m][n];
        graph = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            graph[i] = maps[i];
        }

        return bfs(new int[]{0,0}, m, n);
    }

    static int bfs(int[] start, int m, int n){

        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i < 4 ; i++){

                int x = cx + dx[i];
                int y = cy + dy[i];

                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                if(visited[x][y]) continue;
                if(graph[x][y] == 0) continue;

                q.offer(new int[]{x,y});
                visited[x][y] = true;

                distance[x][y] = distance[cx][cy] + 1;

            }

        }

        return (distance[m-1][n-1] == 0) ? -1 : distance[m-1][n-1] + 1;
    }
}
