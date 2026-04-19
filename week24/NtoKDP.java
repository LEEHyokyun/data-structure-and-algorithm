package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class NtoKDP {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        //1초 -> cur - 1, cur + 1
        //0초 -> cur * 2

        int diff = Math.abs(K - N);
        int answer = 0;


        while(diff > 0){

            if(diff % 2 == 0){
                //점프
                diff = diff / 2;
            }else{
                //이동
                diff = diff - 1;
                answer++;
            }

        }

        System.out.println(answer);
    }
}
