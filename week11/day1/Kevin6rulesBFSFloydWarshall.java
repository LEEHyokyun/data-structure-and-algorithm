package week11.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kevin6rulesBFSFloydWarshall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[N+1][N+1];  // i > j

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for(int i = 0 ; i < M ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(token2.nextToken());
            int v = Integer.parseInt(token2.nextToken());

            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        //FW
        //단순히 경유한 거리와 비교하여 최소값을 도출하는 것이 아니라, 경유 경로에 대한 경로 업데이트 자체가 가능해짐
        for(int k = 1 ; k <= N; k++){
            for(int i = 1  ; i <= N ; i++){
                for(int j = 1 ;  j <= N ; j++){
                    if(dist[i][j] > dist[i][k] +  dist[k][j]){
                        dist[i][j] = dist[i][k] +  dist[k][j];
                    }
                }
            }
        }

        //answer
        int person = 0 ;
        int result = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N ; i++){
            int sum = 0 ;
            for(int j = 1 ; j <= N ; j++){
                sum += dist[i][j];
            }

            if(sum < result){
                result = sum;
                person = i;
            }
        }

        System.out.println(person);
    }

}
