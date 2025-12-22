package week7.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Miro {
    static boolean[][] visited;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        int[][] miro = new int[N][M];
        visited = new boolean[N][M];

        for(int[] arr : miro){
            String str = br.readLine();
            for(int i = 0 ; i < M ; i++){
                arr[i] = str.charAt(i) - '0';
            }
        }

        //bfs
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(miro[nx][ny] == 0) continue;

                if(!visited[nx][ny]){
                    q.offer(new int[]{nx, ny});
                    miro[nx][ny] = miro[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }

        int result = miro[N-1][M-1];
        System.out.println(result);
    }
}
