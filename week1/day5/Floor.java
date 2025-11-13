package week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floor {
    static int dp[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
         * bottom - top(tabulation)
         */

        //arr(계단숫자) : 1 ~ 300층
        arr = new int[N+1]; //arr[0] 포함하여 N+1 size 배열 필요함
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //dp(계단을 건넜을 때의 숫자합) : 1 ~ 300층
        dp = new int[N+1]; //dp[0] 포함하여 N+1 size 배열 필요함
        dp[0] = arr[0];
        dp[1] = arr[1];

        if(N >= 2)
            dp[2] = arr[1] + arr[2];

        //for(int i = 3 ; i <= N ; i++){
        //    dp[i] = Math.max(dp[i-2] , dp[i-3] + arr[i-1]) + arr[i];
        //}

        System.out.print(memo(N));
    }

    public static int memo(int N){
        //memoization 기저조건
        if(N==1) return dp[1];
        if(N==2) return dp[2];
        if(dp[N] != 0) return dp[N];

        dp[N] = Math.max(memo(N-2), memo(N-3) + arr[N-1]) + arr[N];

        return dp[N];
    }
}
