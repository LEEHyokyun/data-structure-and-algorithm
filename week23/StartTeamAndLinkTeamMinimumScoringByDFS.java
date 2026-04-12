package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartTeamAndLinkTeamMinimumScoringByDFS {
    static int[][] graph;
    static int N, min;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //능력치 합의 차이가 최소가 되도록 하는
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        graph = new int[N][N];
        list = new int[N];

        for(int i = 0 ; i < N ; i++){
            list[i] = i+1;
        }

        for(int i = 0 ; i < N ; i++){

            StringTokenizer token = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < N ; j++){
                graph[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        //각 팀의 사람 수 = N/2
        //각 팀에서 N명 중에 N/2개 만큼 뽑는 조합의 경우의 수를 구하고 그 조합의 능력치 합을 구하고 차이 구함
        //이 중 최소값을 구함

        boolean[] selected = new boolean[N];
        int answer = dfs(selected, 0, 0);

        System.out.println(answer);
    }

    static int dfs(boolean[] selected, int idx, int count){

        if(count == N/2){
            return getScore(selected);
        }

        for(int i = idx ; i < N ; i++){
            selected[i] = true;
            min = Math.min(min, dfs(selected, i + 1, count + 1));
            selected[i] = false;
        }

        return min;
    }

    static int getScore(boolean[] selected){

        int score1 = 0;
        int score2 = 0;

        for(int i = 0 ; i < N ; i++){
            for(int j = i+1 ; j < N ; j++){
                if(selected[i] && selected[j]){
                    score1 += graph[i][j] + graph[j][i];
                }
                else if(!selected[i] && !selected[j]){
                    score2 += graph[i][j] + graph[j][i];
                }
            }
        }

        return Math.abs(score1 - score2);
    }
}
