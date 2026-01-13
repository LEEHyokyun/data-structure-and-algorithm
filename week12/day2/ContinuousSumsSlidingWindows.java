package week12.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSumsSlidingWindows {
    static int[] list;
    //static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        list = new int[N+1];
        //dp = new int[N+1]; //i까지의 누적합
        //int sum = 0;
        //dp[0] = 0;
        for(int i = 1 ; i <= N ; i++){
            list[i] = Integer.parseInt(token2.nextToken());
            //dp[i] = sum + list[i];
        }

        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while(true){   //right > N(N을 넘어갔지만), 그동안 가능한 경우도 있을 수 있음.

            if(sum == M) {
                count++;
//                if(right > N) break;
//                sum = sum + list[right];
//                right++;
                sum -= list[left];
                left++;
            }
            else if(sum > M){
                sum = sum - list[left];
                left++;
            }
            else if(sum < M){
                if(right > N) break;
                sum = sum + list[right];
                right++;
            }
        }

        System.out.println(count);
    }
}
