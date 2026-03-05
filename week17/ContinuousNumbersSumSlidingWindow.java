package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousNumbersSumSlidingWindow {
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //연속된 수들의 부분합 중에 그 길이가 가장 "짧은 것"
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int S = Integer.parseInt(token.nextToken());

        list = new int[N];

        StringTokenizer token2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(token2.nextToken());
        }

        //구간을 줄이면 sum 감소
        //구간을 늘리면 sum 증가
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        //무한순회 / 탈출조건 / 범위조절

        while(true){
            if(sum < S){
                if(right == list.length) break;
                sum += list[right++];
            }else{
                //right ++된 후 +1 X
                answer = Math.min(answer, right - left);
                sum -= list[left++];
            }
        }

        System.out.println((answer == Integer.MAX_VALUE) ? 0 : answer);
    }
}
