package week10.day1;

public class JumpDP {
    static long MOD = 1234567;
    static long[] dp;

    public long solution(int n) {

        if(n == 1) return 1 % MOD;
        if(n == 2) return 2 % MOD;

        //dp[1] => 1칸에 도달할 수 있는 경우의 수
        dp = new long[n+1];
        long answer = tabul(dp, n);

        return answer;

    }

    static long tabul(long[] dp, int n){

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // if(n == 1) return dp[1] % MOD;
        // if(n == 2) return dp[2] % MOD;

        for(int i = 3 ; i <= n ; i++){
            dp[i] = dp[i-1] % MOD + dp[i-2] % MOD;
        }

        return dp[n] % MOD;
    }
}
