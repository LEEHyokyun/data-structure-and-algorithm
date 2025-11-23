package week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");


        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        //정렬
        Arrays.sort(arr);

        //투포인터
        int target = Integer.parseInt(br.readLine());
        int left = 0;
        int right = N-1;
        int count = 0;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum < target){
                left = left + 1;
                continue;
            }else if(sum > target){
                right = right - 1;
                continue;
            }else {
                count++;
                left = left + 1;
                right = right - 1;
            }
        }

        System.out.print(count);
    }
}
