package week9.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLongestPartialArrayLessThanK {
    static int[] array;

    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token1.nextToken());
        int K = Integer.parseInt(token1.nextToken());
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        array = new int[N];

        for(int i = 0 ; i < N ; i++){ //N <= 10만
            array[i] = Integer.parseInt(token2.nextToken());
        }

        //sliding window
        int[] cnt = new int[100001]; //숫자빈도관리 -> 숫자보다 커야함.
        int left = 0 ;
        int answer = 0;
        for(int right = 0 ; right < N ; right++){
            cnt[array[right]] ++;

            while(cnt[array[right]] > K){
                cnt[array[left]]--;
                left++;
            }


            int length = right - left + 1;
            answer = Math.max(answer, length);
        }

        System.out.println(answer);
    }
}
