package week8.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ResignTabulation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //init
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];  //상담기간
        int[] P = new int[N+1];
        int[] dp = new int[N+2];

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(input.nextToken());
            P[i] = Integer.parseInt(input.nextToken());
        }

        System.out.println(tabul(dp, T, P, N));
    }

    static int tabul(int[] dp, int[] T, int[] P, int N){

        for(int day = 1 ; day <= N ; day++){
            dp[day + 1] = Math.max(dp[day + 1], dp[day]);

            int endDay = day + T[day];
            if(endDay <= N + 1){
                dp[endDay] = Math.max(dp[endDay], dp[day] + P[day]); //보수 누적
            }
        }

        return dp[N+1];
    }
}
