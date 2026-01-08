package week11.day2;

/*
* 효율성테스트까지 합
* 계산 중간, 계산 결과 모두 MOD를 나눠주어야 한다.
* */
public class ToSchoolDP2 {
    public int solution(int m, int n, int[][] puddles) {

        //m -> 가로 열 수
        //n -> 세로 행 수
        //최단경로 -> BFS .. "개수" -> DP

        int answer = tabul(m, n, puddles);
        return answer;
    }

    static int tabul(int m, int n, int[][] puddles){
        int MOD = 1000000007;
        int count = 0 ;
        int[][] dp = new int[n+1][m+1]; // i to j

//         boolean[][] blocked = new boolean[n+1][m+1];
//         for(int i = 0 ; i < puddles.length ; i++){
//             int px = puddles[i][1];
//             int py = puddles[i][0];

//             blocked[px][py] = true;
//         }

        //dp[0][0] = 1;
        //i,j -> from 왼쪽, from 위
        dp[1][1] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){

                //if(i == 0) dp[i][j] = 1; continue;
                //if(j == 0) dp[i][j] = 1; continue;

                if ((i == 1 && j == 1)) {
                    continue;
                }

                if(isInPuddles(i,j,puddles)){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = dp[i-1][j] % MOD + dp[i][j-1] % MOD;
            }
        }


        return dp[n][m] % MOD;
    }

    static boolean isInPuddles(int i, int j, int[][] puddles){

        //puddles의 x와 puddles y는 .. 2차원 배열에서는 반대로 두어야 한다.
        //즉 그림상 2,3 => 배열상에서는 [3][2] 이다.

        for(int p = 0 ; p < puddles.length ; p++){
            int py = puddles[p][0] ;
            int px = puddles[p][1] ;

            if(i == px && j == py) return true;
        }

        return false;
    }
}
