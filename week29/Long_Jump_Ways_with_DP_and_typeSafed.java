package week29;

public class Long_Jump_Ways_with_DP_and_typeSafed {
    public long solution(int n) {

        if(n == 1) return 1;

        //+1 or +2
        long[] dp = new long[n+1];
        dp[0] = 0; //시작점은 0
        dp[1] = 1;
        dp[2] = 2;



        for(int i = 3 ; i <= n ; i++){

            dp[i] = dp[i-1] % 1234567 + dp[i-2] % 1234567;

        }

        return dp[n] % 1234567;
    }
}
