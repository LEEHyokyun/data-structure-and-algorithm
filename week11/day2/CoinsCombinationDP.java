package week11.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinsCombinationDP {
    //DP이다. DFS는 무제한 선택? 시간초과 발생.
    static int[] dp;
    static int[] list;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        list = new int[N]; //coins
        dp = new int[K+1]; //dp (1~K원)

        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int result = tabul(dp, list, K);
        System.out.println(result);
    }

    static int tabul(int[] dp, int[] list, int K){
        dp[0] = 1; //i 원을 만들 수 있는 경우의 수
        //dp[1] = 1;

        //1 2 5
        //dp[10] = 9 -> +1 + 8 -> +2 5 -> +5
        //dp[5] = dp[1] + dp[1] ....

        for(int coin : list){
            for(int i = coin ; i <= K ; i++){
                //coint에 따른 경우의 수
                dp[i] = dp[i-coin] + dp[i]; //멀리뛰기와 같다. 각 coin으로 뺄 수 있는 경우의 수를 그냥 합치면 됨(거기서만 도출이 가능하니까)
            }
        }

        return dp[K];
    }
}
