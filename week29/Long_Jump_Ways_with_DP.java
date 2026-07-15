package week29;

public class Long_Jump_Ways_with_DP {
    public long solution(int n) {

        if(n == 1) return 1;

        //+1 or +2
        int[] dp = new int[n+1];
        dp[0] = 0; //시작점은 0
        dp[1] = 1;
        dp[2] = 2;



        for(int i = 3 ; i <= n ; i++){

            dp[i] = dp[i-1] + dp[i-2];

        }

        return dp[n];
    }
}
