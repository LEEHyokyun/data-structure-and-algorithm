package week3.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumSumCases {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //DP
        //dp size <= 10
        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1; //1
        dp[2] = 2; //1+1/2
        dp[3] = 4; //1+1+1/1+2/2+1/3

        //int num = Integer.parseInt(br.readLine());
        //더 효율적으로 : 일단 채워놓는다.
        //반복문마다 채우는 과정 반복
        for(int j = 4 ; j <= 10 ; j++){
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
        }

        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}
