package week33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Taxi_with_Dijkstra {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] graph;
    static int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*
         * 특정 지점을 환승지점으로 해서, 총 3개의 가중치 최소합을 구한 후
         * 모든 환승지점에 대한 도합이 가장 적은 경로를 도출한다.
         * = 다익스트라.
         */
        graph = new ArrayList[n + 1];
        for(int i = 0 ; i <= n ; i++) graph[i] = new ArrayList<>();

        for(int[] fare : fares){

            int from = fare[0];
            int to = fare[1];
            int weight = fare[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));

        }

        int[] distanceSX = dijkstra(s, n);
        int[] distanceAX = dijkstra(a, n);
        int[] distanceBX = dijkstra(b, n);

        int answer = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++){
            answer = Math.min(answer,
                    distanceSX[i] + distanceAX[i] + distanceBX[i]
            );
        }

        return answer;
    }

    static int[] dijkstra(int start, int nodes){

        boolean[] visited = new boolean[nodes + 1];
        int[] distance = new int[nodes + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        for(int i = 1 ; i <= nodes ; i++){

            int minNode = -1;
            int minDist = INF;

            for(int j = 1 ; j <= nodes ; j++ ){
                if(visited[j]) continue;
                if(distance[j] < minDist){
                    minNode = j;
                    minDist = distance[j];
                }
            }

            if(minNode == -1) break;
            visited[minNode] = true;

            for(Node adj : graph[minNode]){
                if(distance[adj.to] > distance[minNode] + adj.weight)
                    distance[adj.to] = distance[minNode] + adj.weight;
            }

        }

        return distance;
    }
}
