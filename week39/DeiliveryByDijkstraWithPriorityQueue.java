package week39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DeiliveryByDijkstraWithPriorityQueue {
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

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()){

            Node cur = pq.poll();

            if(cur.weight > distance[cur.to]) continue;

            //to로 바로거가나, 현재 cur 거쳐서 to로 가거나
            for(Node adj : graph[cur.to]){
                if(distance[adj.to] > distance[cur.to] + adj.weight){
                    distance[adj.to] = distance[cur.to] + adj.weight;
                    pq.offer(new Node(adj.to, adj.weight));
                }
            }
        }

        int answer = 0;
        for(int d : distance) if(d <= K) answer++;

        return answer;
    }
}
