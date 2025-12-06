package week5.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()); //N일차
        int X = Integer.parseInt(tokenizer.nextToken()); //X일까지의 최대 방문자수는

        //연속된 X일 동안 가장 많이 방문한 방문자수(0? SAD)
        //+ 기간이 몇개

        //Sliding Window
        int[] days = new int[N];
        StringTokenizer visitors = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            days[i] = Integer.parseInt(visitors.nextToken());
        }

        //init
        long sum = 0;
        for(int i = 0 ; i < X ; i++){
            sum = sum + days[i];   //0~X-1
        }

        long result = sum;
        int count = 1;

        for(int i = X; i < N; i++){
            sum = sum - days[i - X] + days[i]; //처음제거(i-X) / 마지막(i)추가

            if(sum > result){
                result = sum;
                count = 1;
            }else if(sum == result){
                count++;
            }
        }

        if(result == 0){
            System.out.print("SAD");
        }else{
            System.out.println(result);
            System.out.println(count);
        }


    }
}
