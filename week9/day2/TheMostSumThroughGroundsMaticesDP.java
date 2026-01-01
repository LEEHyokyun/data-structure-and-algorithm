package week9.day2;

public class TheMostSumThroughGroundsMaticesDP {
    int solution(int[][] land) {
        int N = land.length;
        int[][] dp = new int[N][4];

        //init
        for(int i = 0 ; i < 4 ; i++){
            dp[0][i] = land[0][i];
        }

        //dp
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < 4 ; j++){
                dp[i][j] = land[i][j] + Math.max(
                        //j를 제외한 나머지
                        dp[i-1][(j+1)%4],
                        Math.max(
                                dp[i-1][(j+2)%4],
                                dp[i-1][(j+3)%4]
                        )
                );
            }
        }

        int answer = 0;
        for(int i = 0 ; i < 4 ; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }

        return answer;
    }
}
