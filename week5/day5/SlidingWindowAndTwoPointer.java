package week5.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindowAndTwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] arr = new int[N];
        StringTokenizer num = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(num.nextToken());
        }

        //투포인터
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        //슬라이딩 윈도우(고정 부분합) + 투포인터(크기조절)

        while(true){
            //슬라이딩을 적용한 이후에는 크거나 작아지므로 자동적으로 left/right 적용됨
            if(sum > M){
                //크면 left 슬라이딩
                sum = sum - arr[left];
                left = left + 1;
            }else if (sum < M){
                if(right == N) break; //(작은데 right == N ? break) 그전까지는 계속 슬라이딩 적용
                //작으면 right 슬라이딩
                sum = sum + arr[right];
                right = right + 1;
            }else{
                count++;
                sum = sum - arr[left];
                left = left + 1;
            }
        }

        //while(left < right){
        //    int sum = 0;
        //    for(int i = left ; i <= right ; i++){
        //        sum = sum + arr[i];
        //    }
        //
        //    if(sum < target){
        //        left = left + 1;
        //    }else if(sum > target){
        //        right = right - 1;
        //    }else{
        //        count++;
        //        left = left + 1;
        //        right = right - 1;
        //    }
        //}

        System.out.println(count);
    }
}
