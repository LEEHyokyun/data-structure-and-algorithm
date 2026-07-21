package week30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delivery_limit_time_Dijkstra {
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

    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] info : road){
            int from = info[0];
            int to = info[1];
            int weight = info[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        return dijkstra(1, N, K);

    }

    static int dijkstra(int start, int node, int limit){

        int[] distance = new int[node+1];
        boolean[] visited = new boolean[node+1];

        Arrays.fill(distance, INF);

        distance[start] = 0;

        for(int i = 1 ; i <= node ; i++){

            int minNode = -1;
            int minDist = INF;

            for(int j = 1 ; j <= node ; j++){

                if(visited[j]) continue;
                if(distance[j] < minDist) {
                    minDist = distance[j];
                    minNode = j;
                }

            }

            //최단거리 탐색 다 끝나고 갱신
            if(minNode == -1) break;
            visited[minNode] = true;

            for(Node adj : graph[minNode]){
                if(distance[adj.to] > distance[minNode] + adj.weight){
                    distance[adj.to] = distance[minNode] + adj.weight;
                }
            }
        }

        int answer = 0;

        for(int i = 1 ; i <= node ; i++){
            //System.out.println("distance[ " + i + "] : " + distance[i]);
            if(distance[i] <= limit) answer++;
        }

        return answer;

    }
}
