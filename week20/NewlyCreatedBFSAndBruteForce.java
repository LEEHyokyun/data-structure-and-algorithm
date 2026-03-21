package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class NewlyCreatedBFSAndBruteForce {
    static int N,M;
    static int[][] graph;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        graph = new int[N][M];

        //L ->  육지 W -> 바다
        //bfs의 최대 거리를 구하라
        for(int i = 0 ; i < N ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < M ; j++){
                graph[i][j] = (input.charAt(j) == 'L') ? 0 : -1;
            }
        }

        int max = 0;

        //시작할 수 있는 모든 경로에 대해 추적해야 함
        //한번 bfs돌면 visited, graph 모두 초기화. 다시 처음 상태에서 시도해야 함
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(graph[i][j] == -1) continue;

                dist = new int[N][M];
                visited = new boolean[N][M];

                max = Math.max(max, bfs(new int[]{i,j}));
            }
        }

        System.out.println(max);
    }

    static int bfs(int[] start) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (visited[x][y]) continue;
                if (graph[x][y] == -1) continue;   //최단경로가 아니면 visited로 막힘, 고려할 필요가없다.

                q.offer(new int[]{x, y});
                visited[x][y] = true;
                dist[x][y] = dist[cur[0]][cur[1]] + 1;
                count = Math.max(count, dist[x][y]);
            }
        }

        return count;
    }
}
