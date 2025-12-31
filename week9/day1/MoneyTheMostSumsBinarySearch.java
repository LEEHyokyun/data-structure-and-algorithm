package week9.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MoneyTheMostSumsBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            array[i] = Integer.parseInt(token.nextToken());
            max = Math.max(max, array[i]);
        }
        int K = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i = 0 ; i < N ; i++){
                if(array[i] > mid){
                    sum += mid;
                }else{
                    sum += array[i];
                }
            }

            if(sum > K) right = mid - 1;
            else {
                answer = mid; //예산조건을 만족하였을때만 해후보군으로 등록
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
