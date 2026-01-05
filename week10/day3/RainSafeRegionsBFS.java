package week10.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class RainSafeRegionsBFS {
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = 0;
        graph = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                graph[i][j] = Integer.parseInt(token.nextToken());
                min = Math.min(min, graph[i][j]);
                max = Math.max(max, graph[i][j]);
            }
        }

        int count = 0;
        int answer = 0;

        for(int k = min - 1 ; k < max ; k++){
            count = 0;
            boolean[][] visited = new boolean[N][N];
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!visited[i][j] && graph[i][j] - k > 0){
                        count++;
                        bfs(visited, graph, new int[]{i,j}, k, N);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    static void bfs(boolean[][] visited, int[][] graph, int[] start, int K, int N){

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] - K <= 0) continue;

                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
    }
}
