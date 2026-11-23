package week39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DeliveryByDijkstra {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;

    public int solution(int N, int[][] road, int K) {
        /*
         * 다익스트라 - 우선순위 큐
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

        //boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];

        Arrays.fill(distance, INF);

        //visited[1] = true;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.weight - b.weight;
        });
        pq.offer(new Node(1, 0));

        distance[1] = 0;

        while(!pq.isEmpty()){

            Node cur = pq.poll();

            //if(visited[cur.to]) continue;
            //비교대상 : 인접노드(to)로 가는 가중치(weight) vs 이미 정해진 거리..
            //동등까지는 OK, 초과 시 생략
            if(cur.weight > distance[cur.to]) continue;

            for(Node adj : graph[cur.to]){
                if(distance[adj.to] > distance[cur.to] + adj.weight){
                    distance[adj.to] = distance[cur.to] + adj.weight;
                    pq.offer(new Node(adj.to, adj.weight)); //인접노드로 가는 가중치 그 자체
                }

            }

        }

        int count = 0;
        for(int val : distance) if(val <= K) count++;

        return count;
    }
}
