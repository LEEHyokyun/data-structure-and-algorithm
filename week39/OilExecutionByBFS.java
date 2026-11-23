package week39;

import java.util.ArrayDeque;
import java.util.Queue;

public class OilExecutionByBFS {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(int[][] land) {
        /*
         * 세로 n 가로 m(n*m)
         * 시추관을 단 하나만 뚫을 수 있고, 가장 많은 석유 영역을 뽑을 수 있는 연속 구간 중 하나에.
         */

        /*
         * 한번 훑고 지나가면서 닿는 영역에 대해 bfs를 진행하고 그 영역 수를 모두 합하고, 이 중 최대.
         */
        int depth = land.length;
        int range = 0;

        graph = new int[depth][];
        visited = new boolean[depth][];

        for(int i = 0 ; i < depth ; i++){
            graph[i] = land[i];
            //visited[i] = new boolean[land[i].length];
            range = land[i].length;
        }

        int answer = 0;
        for(int i = 0 ; i < range ; i++) {

            int amount = 0;
            visited = new boolean[depth][range];

            for(int j = 0 ; j < depth ; j++){
                if(visited[j][i]) continue;
                if(graph[j][i] == 0) continue;
                amount += bfs(j, i, range, depth);
            }

            answer = Math.max(answer, amount);
        }

        return answer;
    }

    static int bfs(int depth, int range, int maxRange, int maxDepth){

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{depth, range});
        visited[depth][range] = true;

        int count = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= maxDepth || ny >= maxRange) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                count++;
            }
        }

        return count;
    }
}
