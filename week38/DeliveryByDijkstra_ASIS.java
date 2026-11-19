package week38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryByDijkstra_ASIS {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;

    public int solution(int N, int[][] road, int K) {
        /*
         * 특정 지점에서 경로를 거쳐 가는 가중치 합이 K 이하가 가능한 경우
         */
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

        return dijkstra(N, K);
    }

    static int dijkstra(int N, int K){

        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];

        Arrays.fill(distance, INF);

        distance[1] = 0;

        for(int i = 1 ; i <= N ; i++){

            int minDist = INF;
            int minNode = -1;

            //현재 출발점에서 가장 가중치가 적은 그래프를 선택.
            for(int j = 1 ; j <= N ; j++){
                if(visited[j]) continue;
                if(distance[j] < minDist){
                    minDist = distance[j];
                    minNode = j;
                }
            }

            /*
             * minNode에 도착 후
             * minNode를 거쳐 가는 거리와 minNode의 인접노드로 바로 가는 거리
             * 인접노드로 가는 거리 갱신
             */
            if(minNode == -1) break;
            visited[minNode] = true;

            for(Node adj : graph[minNode]){
                if(distance[minNode] + adj.weight < distance[adj.to]) {
                    distance[adj.to] = distance[minNode] + adj.weight;
                }
            }
        }

        int answer = 0;
        for(int d : distance) {
            if(d <= K) answer++;
        }

        return answer;
    }
}
