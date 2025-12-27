package week8.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class MiroBFS {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            String miro = br.readLine();
            for(int j = 0 ; j < M ; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(miro.charAt(j)));
            }
        }

        int path = bfs(graph, new int[]{0,0}, N, M);
        System.out.println(path);

    }

    static int bfs(int[][] graph, int[] start, int N, int M){
        int x = start[0];
        int y = start[1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[0][0] = true;

        int answer = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            if((cur[0] == N-1) && (cur[1] == M-1)){
                break;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(graph[nx][ny] == 0) continue;

                if(!visited[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[cur[0]][cur[1]] + 1;
                }
            }
        }

        return graph[N-1][M-1];
    }
}
