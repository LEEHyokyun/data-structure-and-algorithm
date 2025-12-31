package week9.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheMostSumThroughMriCandiesDP {
    static int[][] graph;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};
    static int N;
    static int M;
    //아래
    //오른쪽옆
    //대각선아래(아래+오른쪽옆)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token1.nextToken());
        M = Integer.parseInt(token1.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                graph[i][j] = Integer.parseInt(token2.nextToken());
            }
        }


        //출발점 고정
        dp(graph);

        System.out.println(graph[N-1][M-1]);
    }

    static void dp(int[][] graph){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                //3가지 경로 중 최대값 pick
                int up = (i > 0 )? graph[i-1][j] : 0;
                int left = (j > 0 )? graph[i][j-1] : 0;
                int upLeft = (i > 0 && j > 0 )? graph[i-1][j-1] : 0;

                //그 지점에서, 이전의 지점을 합산하는 방식.
                graph[i][j] = graph[i][j] + Math.max(up, Math.max(left, upLeft));
            }
        }
    }
}
