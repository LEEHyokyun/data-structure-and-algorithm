package week8.day5;

public class TriangleSumTheBiggestNumberDP {
    public int solution(int[][] triangle) {

        int N = triangle.length;
        int[][] dp = new int[N][N];

        //dp -> depth = i일때의 합
        dp[0][0] = triangle[0][0];


        for(int i = 1 ; i < N ; i++){

            //d1) 0 -> 0,1
            //d2) 0 -> 0,1 / 1-> 1,2
            //d3) 0 -> 0,1 / 1-> 1,2 / 2-> 2,3
            //d4) 0 -> 0,1 / 1-> 1,2 / 2-> 2,3 / 3-> 3,4
            for(int j = 0 ; j < i+1 ; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1] , dp[i-1][j]) + triangle[i][j];
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
