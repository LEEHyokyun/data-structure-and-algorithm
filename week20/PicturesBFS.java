package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class PicturesBFS {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] graph;
    static boolean[][] visited;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){

            StringTokenizer token2 = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < M ; j++){
                graph[i][j] = Integer.parseInt(token2.nextToken());
            }
        }

        int max = 0;
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(visited[i][j]) continue;
                if(graph[i][j] == 0) continue;

                count++;
                max = Math.max(max, bfs(new int[]{i,j}));
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static int bfs(int[] start){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        int count = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x < 0 || y < 0 || x >= N || y >= M) continue;
                if(visited[x][y]) continue;
                if(graph[x][y] == 0) continue;

                q.offer(new int[]{x,y});
                visited[x][y] = true;
                count++;
            }
        }

        return count;
    }
}
