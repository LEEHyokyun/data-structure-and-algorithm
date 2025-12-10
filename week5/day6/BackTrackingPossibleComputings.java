package week5.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTrackingPossibleComputings {
    static int N;
    static int[] nums;
    static int[] op = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];

        StringTokenizer ns = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) nums[i] = Integer.parseInt(ns.nextToken());
        StringTokenizer ops = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 4 ; i++) op[i] = Integer.parseInt(ops.nextToken());

        dfs(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int value){
        if(idx == N){
            max = Math.max(max, value);
            min = Math.min(min, value);

            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            if(op[i] > 0){
                //연산적용
                op[i]--;

                int next = value;

                if(i == 0 ) next = value + nums[idx];
                else if(i == 1) next = value - nums[idx];
                else if(i == 2) next = value * nums[idx];
                else if(i == 3) next = value / nums[idx];

                //dfs
                dfs(idx + 1, next);
                //
                op[i]++;
            }
        }
    }
}
