package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class MiroBFS {
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        //1,1
        //N,M
        //이동할때 지나야 하는 최소의 칸 수

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i ++){
            String input = br.readLine();
            for(int j = 0 ; j < M ; j++){
                //string > int
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        int answer = bfs(new int[]{0,0});
        System.out.println(answer);
    }

    static int bfs(int[] start){
        visited[start[0]][start[1]] = true;

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(start);

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == N-1 && cur[1] == M-1) break;

            for(int i = 0 ; i < 4 ; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x < 0 || y < 0 || x >= N || y >= M) continue;
                if(graph[x][y] == 0) continue;
                if(visited[x][y]) continue;

                q.offer(new int[]{x,y});
                visited[x][y] = true;
                graph[x][y] = graph[cur[0]][cur[1]] + 1;
            }
        }

        return graph[N-1][M-1];
    }
}
