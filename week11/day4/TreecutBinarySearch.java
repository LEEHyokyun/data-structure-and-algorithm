package week11.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreecutBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] trees = new int[N];
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 1;
        for(int i = 0 ; i < N ; i++){
            trees[i] = Integer.parseInt(token2.nextToken());
            max = Math.max(max, trees[i]);
        }

        int answer = 0;
        while(min <= max){
            int cur = (max + min) / 2;
            long heights = 0;

            for(int i = 0 ; i < N ; i++){
                if(trees[i] > cur) heights += trees[i] - cur;
                else continue;
            }

            if(heights >= M){
                //answer = Math.max(answer, max);
                min = cur + 1;
            }else{
                max = cur - 1;
            }

        }

        System.out.println(max);

        //가져가야하는 최소 나무의 높이 합산
        //절단기의 최대 높이
    }
}
