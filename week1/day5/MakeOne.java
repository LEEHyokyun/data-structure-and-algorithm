package week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        //확실히 DP
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1]; //초기화
        dp[0] = 0;
        dp[1] = 0;


        //12
        //12 / 3 -> dp[4] + 1
        //4 / 2 -> (dp[2] + 1)
        //2-1 -> (dp[2])

        //13
        //13 - 1 -> dp[4] + 1
        //12/3 -> dp[2] + 1
        //4/2  -> dp[2] + 1
        //2-1  -> dp[2]
        System.out.print(tabulation(N));

    }

    static int tabulation(int N){
        /*
        * 2로 나누어 떨어지는 경우
        * 3로 나누어 떨어지는 경우
        * 6로 나누어 떨어지는 경우
        * 모두 고려할 것.
        * */
        for(int i = 2 ; i <= N ; i++){
            if(i == 2) dp[i] = 1;
            else if(i % 2 == 0 && i % 3 == 0 )
                dp[i] = Math.min(dp[i-1], Math.min(dp[i/3],dp[i/2])) + 1;
            else if(i % 3 == 0)
                dp[i] = Math.min(dp[i/3],dp[i-1]) + 1;
            else if(i % 2 == 0)
                dp[i] = Math.min(dp[i/2],dp[i-1]) + 1;
            else
                dp[i] = dp[i-1] + 1;
        }

        /*
        *
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;       //1을 뺀 경우에서 +1
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);    //2로 나눈 경우에서 +1 한 것과 비교
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        * */

        return dp[N];
    }
}
