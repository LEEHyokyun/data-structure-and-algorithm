package week38;

public class TriangleSumOfNumsByDPMemoizationRefactored {
    public int solution(int[][] triangle) {
        /*
         * 거쳐간 숫자의 최댓값
         * 오른쪽 = 오른쪽 대각선 수의 합
         * 왼쪽 = 왼쪽 대각선 수의 합
         * 나머지 = 그 이전의 합 중 최대
         */
        int length = triangle.length;
        int[][] dp = new int[length][];

        dp[0] = new int[triangle[0].length];
        dp[0][0] = triangle[0][0];

        for(int i = 1 ; i < length ; i++){
            dp[i] = new int[triangle[i].length];

            for(int j = 0 ; j <= i ; j++){
                if(j == 0) dp[i][j] = dp[i-1][0] + triangle[i][j];
                else if(j == i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;

        for(int i = 0 ; i < length ; i++){
            answer = Math.max(answer, dp[length-1][i]);
        }

        return answer;
    }
}
