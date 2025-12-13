package week6.day3;

public class DPForTriangleNums {
    public int solution(int[][] triangle) {
        int answer = 0;

        int N = triangle.length;
        int[][] dp = new int[N][N];

        dp[0][0] = triangle[0][0];

        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j <= i ; j++){
                if(j == 0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                } else if( i == j){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        for(int result : dp[N-1]){
            if(result > answer) answer = result;
        }

        return answer;
    }
}
