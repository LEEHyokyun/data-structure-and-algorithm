package week26_exercising;

public class Triangle_DP {
    public int solution(int[][] triangle) {

        int N = triangle.length;
        int[][] dp = new int[N][N];

        //dp[i][j] = i층 j번째까지의 합의 최대값
        dp[0][0] = triangle[0][0];

        //1 -> 0,1
        //2 -> 0,1,2
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j <= i ; j++){

                if(j == 0){
                    //왼쪽 끝 = 왼쪽 끝
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == i){
                    //오른쪽 끝 = 오른쪽 끝
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else {
                    //나머지 = 그 전의 층 왼쪽 대각선 위 / 오른쪽 대각선 위 합 중 최대로
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }

        return answer;
    }
}
