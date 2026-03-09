package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreesBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] list = new int[N];
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(token2.nextToken());
            max = Math.max(max, list[i]);
        }

        //폐구간에서의 특정 값 = when left == right 그것의 최대값
        int left = 0;
        int right = max;
        int answer = 0;

        while(left <= right){

            int mid = (left + right) / 2;

            if(getSlicedSum(mid, list) < M){
                right = mid - 1; //보장 불가 -> mid
            } else if(getSlicedSum(mid, list) >= M){
                answer = mid;
                left = mid + 1; //보장 -> mid + 1
            }
        }

        //처리 후 최종 저장된 mid = 특정값
        System.out.println(answer);

    }

    static long getSlicedSum(int mid, int[] list){

        long answer = 0;

        for(int tree : list){
            if(tree > mid) answer += tree - mid;
        }

        return answer;
    }
}
