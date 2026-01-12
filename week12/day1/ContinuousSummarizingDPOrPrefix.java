package week12.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSummarizingDPOrPrefix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //수 N개, i번째 수 ~ j번째 수까지의 합
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        //list = new int[N];
        StringTokenizer token2 = new StringTokenizer(br.readLine());

        int[] dp = new int[N+1]; //i번째 까지의 누적합

        for(int i = 1 ; i <= N ; i++){
            dp[i] = dp[i-1] + Integer.parseInt(token2.nextToken());
        }

        for(int i = 0 ; i < M ; i++){
            //list의 from ~ to까지의 합 (=from -1 index ~ to-1 index)
            StringTokenizer input = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(input.nextToken());
            int to = Integer.parseInt(input.nextToken());
            int answer = 0;

            //from부터 to 까지의 합산.
            //dp[to] - dp[from -1]
            answer = dp[to] - dp[from - 1];

            System.out.println(answer);
        }

    }
}
