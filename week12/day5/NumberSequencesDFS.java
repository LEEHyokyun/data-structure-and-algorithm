package week12.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberSequencesDFS {
    static int[] path;
    static boolean[] selected;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    //static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        //N개 수 중에 M개를 고른 수열
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        arr = new int[N];
        selected = new boolean[N];
        path = new int[M];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(token2.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, M, N);

        System.out.print(sb.toString());
    }

    //순열 -> start 지점 고정
    static void dfs(int count, int M, int N){
        if(count == M){
            int len = path.length;

            for(int i = 0 ; i < M ; i++){
                sb.append(path[i]).append(" ");
            }
            sb.append('\n');

            return;
        }

        int prev = -1;

        for(int i = 0 ; i < N ; i++){

            //수열
            if(selected[i]) continue;
            //중복
            if(prev == arr[i]) continue;

            path[count] = arr[i];
            prev = arr[i];

            selected[i] = true;
            dfs(count + 1, M, N);
            selected[i] = false;
        }
    }
}
