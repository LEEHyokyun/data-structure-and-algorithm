package week12.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 유연한 슬라이딩 아닌 고정된 길이에 의한 비효율적인 슬라이딩
* 원형수열
* */
public class ContinuousSumsFixedLengthAndSlidingWindows {
    static int[] list;
    //static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        list = new int[N+1];
        int count = 0;
        //dp = new int[N+1]; //i까지의 누적합
        //int sum = 0;
        //dp[0] = 0;
        for(int i = 1 ; i <= N ; i++){
            list[i] = Integer.parseInt(token2.nextToken());
            //dp[i] = sum + list[i];
        }

        for(int len = 1 ; len <= N ; len++){
            int sum = 0;

            //초기 윈도우(0 ~ len)
            for(int i = 0 ; i < len ; i++){
                sum +=  list[i];
            }

            if(sum == M) count++;

            //start 지점 조정(길이만큼 0 ~ len -> 0빼고 len + 1 증가하는 식으로
            //len = 3 , 초기 0,1,2      start = 1 -> 0빼고 3증가 start = 2 -> 1빼고 4증가
            //최초 0 ~ len ..... start에 따라 start - 1 빼고 start ~ start + len ..
            for(int start = 1 ; start < N ; start++){

                sum -= list[start - 1];     //|(x)|||
                sum += list[len + start + 1];   //|(x)||(start + len -1)|(start + len) //start + len -> start를 포함한 len만큼 더, start 포함 len길이라면 마지막 제거

                if(sum == M) count++;
            }
        }



        System.out.println(count);
    }
}
