package week7.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //init
        StringTokenizer init = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(init.nextToken());
        int K = Integer.parseInt(init.nextToken());
        int[] coins = new int[N];
        for(int i = 0 ; i < N ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        //Grredy
        Arrays.sort(coins);

        //int start = 0;
        //int end = N-1;

        int count = 0;
        for(int i = N-1 ; i >=0 ; i--){
            count = count + K / coins[i];
            K = K % coins[i];
        }

        System.out.println(count);
    }
}
