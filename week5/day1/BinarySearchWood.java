package week5.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchWood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        long M = Long.parseLong(tokenizer.nextToken()); //long

        //필요한 나무 길이 M이상
        //톱 H미터

        StringTokenizer treeToken = new StringTokenizer(br.readLine(), " ");
        int[] trees = new int[N];
        long max = 0L;

        for(int i = 0 ; i < N ; i++){
            trees[i] = Integer.parseInt(treeToken.nextToken());
            if(trees[i] > max) max = trees[i];
        }

        long low = 0;
        long high = max;
        long result = 0;

        //N,M값이 크면 long.
        while(low <= high){
            long mid = (low+high)/2; //=> H
            long sum = 0;

            //cutting
            for(int i = 0 ; i < N ; i++){
                if(trees[i] > mid) sum = sum + (trees[i] - mid);
            }

            if(sum >= M){
                //sum = M -> best practice
                result = mid;
                low = mid + 1; //mid값을 조절해가면서 H를 작거나 크게, H의 최대값 = 이분탐색을 통한 순회
            }else{
                high = mid - 1;
            }

        }

        System.out.print(result);
    }
}
