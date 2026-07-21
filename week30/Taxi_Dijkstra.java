package week30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Taxi_Dijkstra {
    //dijkstra(S, X) + dijkstra(X, A) + dijkstra(A, B)
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int weight = fare[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        int[] dijkstraSX = dijkstra(s, n);
        int[] dijkstraAX = dijkstra(a, n);
        int[] dijkstraBX = dijkstra(b, n);
        int answer = INF;

        for(int i = 1 ; i <= n ; i++){
            answer = Math.min(answer,
                    dijkstraSX[i] + dijkstraAX[i] + dijkstraBX[i]
            );
        }

        return answer;
    }

    static int[] dijkstra(int start, int n){

        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        for(int i = 1 ; i <= n ; i++){

            int minNode = -1;
            int minDist = INF;

            for(int j = 1 ; j <= n ; j++){

                if(visited[j]) continue;
                if(distance[j] < minDist){
                    minNode = j;
                    minDist = distance[j];
                }

            }


            if(minNode == -1) break;
            visited[minNode] = true;

            //인접노드(to)로 바로가는 것보다 현재의 최소노드를 거쳐 가는 거리를 비교
            for(Node adj : graph[minNode]){
                if(distance[adj.to] > distance[minNode] + adj.weight){
                    distance[adj.to] = distance[minNode] + adj.weight;
                }
            }

        }

        return distance;
    }
}
