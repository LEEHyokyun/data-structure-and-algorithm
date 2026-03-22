package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RetirementDP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(token.nextToken());
            P[i] = Integer.parseInt(token.nextToken());
        }

        //상담 하는 경우 : 수익 = max(dp[i + T[i]], dp[i] + P[i])
        //상담 안하는 경우 : 수익 = max(dp[i], dp[i+1])

        //최대연산100만회 - forward DP
        dp[0] = 0;

        //끝나는 날이 N+1
        for(int i = 1 ; i <= N ; i++){

            //i번째 날에서 상담하느냐, 하지 않느냐

            //상담함
            if(i + T[i] <= N+1){ //끝나는날
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

            //상담안함
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }


        System.out.println(dp[N+1]);
    }
}
