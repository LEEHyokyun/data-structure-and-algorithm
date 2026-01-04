package week10.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LionesDP {
    static long[][] dp;
    static long MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = 2;
        dp = new long[N+1][M+1];

        long answer = tabul(dp, N);

        System.out.println(answer%9901);
    }

    static long tabul(long[][] dp, int N){
        //0 -> 0열에 위치 1 -> 1열에 위치 2 -> 위치X
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for(int i = 1 ; i < N+1 ; i++){
            dp[i][0] = dp[i-1][1] % MOD + dp[i-1][2] % MOD;
            dp[i][1] = dp[i-1][0] % MOD + dp[i-1][2] % MOD;
            dp[i][2] = dp[i-1][0] % MOD + dp[i-1][1] % MOD + dp[i-1][2] % MOD;
        }

        return dp[N-1][0] + dp[N-1][1] + dp[N-1][2];
        //return dp[N][0] + dp[N][1] + dp[N][2];
    }
}
