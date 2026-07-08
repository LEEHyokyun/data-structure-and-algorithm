package week28;

public class Ground_Maximum_Sums_DP {
    int solution(int[][] land) {
        //N * 4, 같은 열을 연속해서 밟을 수 없다.
        //4가지 경우의 수
        int N = land.length;
        int[][] dp = new int[N][4];

        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];

        for(int i = 1 ; i < N ; i++){
            //System.out.println("행 : " + i);
            for(int j = 0 ; j < 4 ; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][j];
                    //System.out.println("dp값 확인 " + dp[i][j]);
                }else if(j == 1){
                    dp[i][j] = Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][j];
                    //System.out.println("dp값 확인 " + dp[i][j]);
                }else if(j == 2){
                    dp[i][j] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3])) + land[i][j];
                    //System.out.println("dp값 확인 " + dp[i][j]);
                }else {
                    dp[i][j] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + land[i][j];
                    //System.out.println("dp값 확인 " + dp[i][j]);
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < 4 ; i++){
            answer = Math.max(answer, dp[N-1][i]);
            //System.out.println("dp 값 확인 : " + dp[N-1][i]);
        }


        return answer;
    }
}
