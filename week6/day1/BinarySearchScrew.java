package week6.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchScrew {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        long[] arr = new long[K];
        long max = 0;
        for(int i = 0 ; i < K ; i++){
            arr[i] = Long.parseLong(br.readLine());
            if(arr[i] > max) max = arr[i];
        }

        //이분탐색 : 길이를 조절해가면서 가능한 랜선의 개수의 최소값(길이의 최대값)을 추출하는 방법.
        long low = 1;
        long high = max;
        long result = 0;

        while(low <= high){
            long mid = (low + high)/2;  //길이
            long count = 0;

            for(int i = 0 ; i < K ; i++){
                count = count + arr[i] / mid;
            }

            if(count >= N){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
