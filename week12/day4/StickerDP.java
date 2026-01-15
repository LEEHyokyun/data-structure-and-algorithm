package week12.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StickerDP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //N크기가 10만, DFS는 아님

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] graph = new int[2][N];
            boolean[][] visited = new boolean[2][N];

            for(int i = 0 ; i < 2 ; i++){
                StringTokenizer token = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    graph[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int[][] dp = new int[3][N];

            //dp[N][0] - N"열"에서 0행 스티커를 찢을때
            //dp[N][1] - N"열"에서 1행 스티커를 찢을때
            //dp[N][2] - N"열"에서 아무것도 안뜯었을때

            dp[0][0] = graph[0][0];
            dp[1][0] = graph[1][0];
            dp[2][0] = 0;

            for(int i = 1 ; i < N ; i++){
                dp[0][i] = Math.max(dp[1][i-1] , dp[2][i-1]) + graph[0][i];  //0행선택
                dp[1][i] = Math.max(dp[0][i-1] , dp[2][i-1]) + graph[1][i];  //1행선택
                dp[2][i] = Math.max(dp[2][i-1], Math.max(dp[0][i-1], dp[1][i-1]));
            }

            int max = 0;
            for(int i = 0 ; i < 3 ; i++){
                max = Math.max(max, dp[i][N-1]);
            }
            System.out.println(max);
        }
    }
}
