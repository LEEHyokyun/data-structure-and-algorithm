package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FlowydWarshall {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n개(2 ~ 100)의 도시
        //도시 A to B로 가는데 필요한 최소 비용 C

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dist = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; //start = end -> 0
        }

        for(int i = 1 ; i <= M ; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            dist[a][b] = Math.min(dist[a][b], cost);
        }

        for(int k = 1 ; k <= N ; k++){
            for(int i = 1 ; i <= N ; i++){
                for(int j = 1 ; j <= N ; j++){
                    //i -> j > i k kj .. 플로이드 워셜 = 한 정점 - 다른 정점 (모든 쌍)
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j<= N ; j++){
                if(dist[i][j] == INF) sb.append(0).append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
