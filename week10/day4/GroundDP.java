package week10.day4;

public class GroundDP {
    static int[][] dp;

    int solution(int[][] land) {
        int N = land.length;
        int M = 4;
        dp = new int[N][4];

        return tabul(land, dp, N, M);
    }

    static int tabul(int[][] land, int[][] dp, int N, int M){
        //경우의 수가 4가지, 어느 땅을 밟았느냐.
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];

        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][j];
                }
                else if(j == 1){
                    dp[i][j] = Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][j];
                }
                else if(j == 2){
                    dp[i][j] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3])) + land[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + land[i][j];
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < M ; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }

        return answer;
    }
}
