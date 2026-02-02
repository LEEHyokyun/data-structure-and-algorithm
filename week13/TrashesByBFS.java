package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class TrashesByBFS {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token1.nextToken());
        M = Integer.parseInt(token1.nextToken());
        K = Integer.parseInt(token1.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < K ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(token2.nextToken());
            int Y = Integer.parseInt(token2.nextToken());

            graph[X-1][Y-1] = 1;
        }

        //bfs
        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){

                if(graph[i][j] == 0) continue;

                if(!visited[i][j]) answer = Math.max(bfs(new int[]{i,j}), answer);
                else continue;
            }
        }

        System.out.println(answer);
    }

    static int bfs(int[] start){

        //매개변수로 굳이 전달X
        int count = 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        //넣는 시점에
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            //visited[cx][cy] = true;

            for(int i = 0 ; i < 4 ; i++){
                int x = cx + dx[i];
                int y = cy + dy[i];

                if(x < 0 || y < 0 || x >= N || y >= M) continue;
                if(visited[x][y]) continue;
                if(graph[x][y] == 0) continue;

                q.offer(new int[]{x,y});
                //넣는 시점에
                visited[x][y] = true;
                count++;
            }
        }

        return count;
    }
}
