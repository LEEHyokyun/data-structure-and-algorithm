package week11.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ContiualSumsDFS {
    static int[] list;
    static Set<Integer> result = new HashSet<>();
    static boolean[] selected;
    static int MIN = -1000;
    static int MAX = 1000;
    static int answer = MIN;

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
        dfs(N, 0);

        System.out.println(answer);
    }

    static void dfs(int N, int sum){

        result.add(sum);
        answer = Math.max(answer, sum);

        for(int i = 0 ; i < N ; i++){

            if(sum + list[i] > 1000) continue;
            if(sum + list[i] < -1000) continue;
            if(result.contains(sum + list[i])) continue;
            if(selected[i]) continue;

            selected[i] = true;
            dfs(N, sum + list[i]);
            selected[i] = false;
        }
    }
}
