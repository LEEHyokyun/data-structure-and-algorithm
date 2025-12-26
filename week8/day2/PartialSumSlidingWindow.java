package week8.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialSumSlidingWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine(), " ");
        StringTokenizer items = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(input.nextToken());
        int S = Integer.parseInt(input.nextToken());

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(items.nextToken());
        }

        int left = 0;
        int sum = 0;
        //최소합 -> MAX, 최대합 -> MIN
        int answer = Integer.MAX_VALUE;

        for(int right = 0 ; right < N ; right++){
            //작으면 right +
            sum = sum + arr[right];

            while(sum >= S){
                answer = Math.min(answer, right - left + 1);
                sum = sum - arr[left++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
