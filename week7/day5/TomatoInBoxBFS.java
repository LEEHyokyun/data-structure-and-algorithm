package week7.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoInBoxBFS {
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        box = new int[M][N];
        visited = new boolean[M][N];
        for(int[] row : box){
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < N ; i++){
                row[i] = Integer.parseInt(input.nextToken());
            }
        }

        //bfs
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(box[i][j] == 1){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(box[nx][ny] == -1) continue;

                if(!visited[nx][ny]){
                    box[nx][ny] = box[x][y] + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

        }

        int max = 0;
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if(max < box[i][j]) max = box[i][j];
            }
        }

        System.out.println(max-1);
    }
}
