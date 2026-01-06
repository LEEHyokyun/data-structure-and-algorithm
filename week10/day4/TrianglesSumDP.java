package week10.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TrianglesSumDP {
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        dp = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < i+1 ; j++){
                graph[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(tabul(graph, dp, N));
    }

    static int tabul(int[][] graph, int[][] dp, int N){
        //i -> i번째 행에서 최대값
        dp[0][0] = graph[0][0];
        for(int i = 1 ; i < N ; i++){
            //1층 -> 0,1
            //2층 -> 0,1,2
            //3층 -> 0,1,2,3
            for(int j = 0 ; j < i+1 ; j++){
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + graph[i][j];
                }
                else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + graph[i][j];
                }
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + graph[i][j];
            }
        }

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }
        return answer;
    }
}
