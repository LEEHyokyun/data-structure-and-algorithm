package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartAndLinkByDFS {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] graph;
    //boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for(int i = 0 ; i < N ; i++){

            StringTokenizer token = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < N ; j++){
                graph[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        //int[] selected = new int[N/2];
        boolean[] selected = new boolean[N];

        System.out.println(dfs(selected, 0, 0));
    }

    //조합하면서 최소값
    static int dfs(boolean[] selected, int idx, int count){

        if(count == N/2){
            return getScore(selected);
        }

        //선택 기준 = count가 아닌 idx.
        for(int i = idx ; i < N ; i++){
            selected[i] = true;
            answer = Math.min(answer, dfs(selected, i + 1, count + 1));
            selected[i] = false;
        }

        return answer;
    }

    static int getScore(boolean[] selected){
        //N/2명에 대한 점수 - N/2명에 대한 점수
        int score1 = 0;
        int score2 = 0;


        //조합의 경우 -> 다음 단계 포함 x
        for(int i = 0 ; i < N ; i++){
            for(int j = i + 1; j < N ; j++){
                if(selected[i] && selected[j]) score1 += graph[i][j] + graph[j][i];
                if(!selected[i] && !selected[j]) score2 += graph[i][j] + graph[j][i];
            }
        }

        return Math.abs(score1 - score2);
    }
}
