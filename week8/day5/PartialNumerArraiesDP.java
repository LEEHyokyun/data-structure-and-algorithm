package week8.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialNumerArraiesDP {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        array = new int[N];
        StringTokenizer input = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            array[i] = Integer.parseInt(input.nextToken());
        }

        int answer = tabul(array, N);
        System.out.println(answer);
    }

    static int tabul(int[] array, int N){
        int[] dp = new int[N];
        int length = 0;

        for(int i = 0 ; i < N ; i++){
            dp[i] = 1; //부분 연속 증가수열 불가 시 기본 길이는 1

            for(int j = 0 ; j < i ; j++){
                if(array[j] < array[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1); //dp[j]는 이전값 순회를 반복하면서 만족할때마다 부분증가수열 + 이전의 부분증가에 이어진 부분증가 조건까지 만족
                }
            }

            length = Math.max(length, dp[i]);
        }

        return length;
    }
}
