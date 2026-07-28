package week31;

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

        int[] resultS = dijkstra(s, n);
        int[] resultA = dijkstra(a, n);
        int[] resultB = dijkstra(b, n);

        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++){
            min = Math.min(min, resultS[i] + resultA[i] + resultB[i]);
        }

        return min;
    }

    static int[] dijkstra(int start, int n){

        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        boolean[] visited = new boolean[n+1];

        for(int i = 1 ; i <= n ; i++){

            int minNode = -1;
            int minDist = INF;

            for(int j = 1 ; j <= n ; j++){
                if(visited[j]) continue;
                if(distance[j] < minDist) {
                    minNode = j;
                    minDist = distance[j];
                }
            }

            if(minNode == -1) break;
            visited[minNode] = true;

            //다익스트라 = 인접노드로 바로 가는 거리와 현재의 최소 거리를 거쳐 인접노드로 가는거리
            for(Node adj : graph[minNode]){
                if(distance[adj.to] > distance[minNode] + adj.weight){
                    distance[adj.to] = distance[minNode] + adj.weight;
                }
            }
        }

        return distance;

    }
}
