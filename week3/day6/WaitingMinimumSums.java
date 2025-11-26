package week3.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WaitingMinimumSums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        //Integer 배열
        //Arrays.sort(arr, Comparator.naturalOrder());
        Arrays.sort(arr);

        int[] result = new int[N+1];
        result[0] = 0;
        for(int i = 1 ; i <= N ; i++){
            result[i] = result[i-1] + arr[i-1];
        }

        int sum = 0;
        for(int i = 1 ; i <= N ; i++){
            sum = sum + result[i];
        }

        System.out.println(sum);
    }
}
