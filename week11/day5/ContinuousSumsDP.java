package week11.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ContinuousSumsDP {
    static int[] list;
    static Set<Integer> result = new HashSet<>();
    static boolean[] selected;
    static int MIN = -1000;
    static int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        selected = new boolean[N];

        list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(token.nextToken());
        }

        //조합
        int answer = tabul(N);

        System.out.println(answer);
    }

    static int tabul(int N){
        int[] dp = new int[N];
        dp[0] = list[0];
        int result = dp[0];

        //구현은 단순명료하게
        for(int i = 1 ; i < list.length ; i++){
            dp[i] = Math.max(list[i], dp[i-1] + list[i]); //여기서 음수일때 연속합 하지 않고 양수일때 연속합 하는 의도가 모두 들어가있다.
            result = Math.max(result, dp[i]);
        }


        return result;
    }
}
