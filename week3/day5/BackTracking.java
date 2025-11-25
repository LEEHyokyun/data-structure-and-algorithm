package week3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking {
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken()); //depth

        int[][] result = new int[N][M];
        arr = new int[M];
        visited = new boolean[N+1];

        //1행 1열부터 시작
        dfs(1,0);
    }

    static void dfs(int start, int depth){ //N개 중에 M개(=depth)
        //backtracking
        if(depth == M){
            for(int x : arr) System.out.print(x + " ");
            System.out.println();
            return;
        }

        //dfs
        /*
         * 시작점 : start부터
         * 조합의 가지 수 : depth까지
         * 각 층마다 arr를 채우고 층이 넘어가면 다시 초기화해서 채우는 방식
         */
        for(int i = start ; i <= N ; i++){
            arr[depth] = i; //다음 순회 depth = 0
            dfs(i+1, depth+1);
        }

        //처음(1~2)
        //arr[0] = 1
        //arr[1] = 2
        //depth = 2 ->
        //재귀 종료 다음 조합으로 넘어간다.

        //이후(2~)
        //arr[0] = 2
        //..
    }
}
