package week31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delivery_Nodes_with_Dijkstra {
    static class Node{

        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

    }

    static boolean[] visited;
    static List<Node>[] graph;
    static int INF = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {

        visited= new boolean[N+1];
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

    static int dijkstra(int start, int N, int K){

        int[] distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        //노드 만큼 순회하면서
        for(int i = 1 ; i <= N ; i++){

            int minDist = INF;
            int minNode = -1;

            //if(visited[i]) continue;
            //지금까지 알려진 거리 중 가장 최단거리를 구하고,
            //이 최단거리를 기준으로 인접거리까지 거리를 갱신
            for(int j = 1 ; j <= N ; j++){

                if(visited[j]) continue;
                if(distance[j] < minDist){
                    minDist = distance[j];
                    minNode = j;
                }
            }

            if(minNode == -1) continue;
            visited[minNode] = true;

            //if(distance[i] < minDist){
            //minNode = i;
            //minDist = distance[i];
            //minDist = INF;

            //visited[i] = true;

            for(Node adj : graph[minNode]){
                //인접노드로 직접 가는 거리와 현재 노드를 거쳐 인접노드로 가는 거리 비교
                //start : minNode / adj : minNode -> adj(from minNode)
                if(distance[adj.to] > distance[minNode] + adj.weight){
                    distance[adj.to] = distance[minNode] + adj.weight;
                }
            }
            //}

        }

        int answer = 0;
        for(int dis : distance) {
            if(dis <= K) answer++;
        }

        return answer;
    }
}
