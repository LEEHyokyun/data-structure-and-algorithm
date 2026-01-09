package week11.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberArraiesDFSWithArrayAndStringBuilder {
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        selected  = new boolean[N+1];
        arr = new int[M];

        //N까지 M개의 자연수를 순서구분하는 수열을 모두 출력.
        dfs(0, N, M);
        System.out.print(sb);
    }

    static void dfs(int depth, int N, int M){

        if(depth == M){
            for(int i = 0 ; i < arr.length ; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }


        for(int i = 1 ; i <= N ; i++){
            if(selected[i]) continue;

            selected[i] = true;
            arr[depth] = i;
            dfs(depth + 1, N, M);
            selected[i] = false;
        }

    }
}
