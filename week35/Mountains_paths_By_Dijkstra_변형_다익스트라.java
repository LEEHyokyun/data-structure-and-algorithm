package week35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Mountains_paths_By_Dijkstra_변형_다익스트라 {
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

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        graph = new List[n+1];
        for(int i = 0 ; i <= n ; i++) graph[i] = new ArrayList<>();

        for(int[] path : paths){

            int from = path[0];
            int to = path[1];
            int weight = path[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));

        }

        return dijkstra(gates, summits, n);

    }

    static int[] dijkstra(int[] gates, int[] summits, int n){

        //지금까지 알려진 가중치중에 가장 적은 가중치
        //우선순위 큐에서 빼면서 visited 등을 사용하지 않고 동시체크 가능
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] distance = new int[n+1];
        boolean[] isGate = new boolean[n+1];
        boolean[] isSummit = new boolean[n+1];

        Arrays.fill(distance, INF);

        for(int gate : gates){
            distance[gate] = 0;
            isGate[gate] = true;
            pq.offer(new Node(gate, 0));
        }

        for(int summit : summits){
            isSummit[summit] = true;
        }

        while(!pq.isEmpty()){

            Node toNode = pq.poll();
            int to = toNode.to;
            int weight = toNode.weight;

            if(weight > distance[to]) continue; //더 안좋은 경로는 탐색 안됨
            if(isSummit[to]) continue; //정상 도달 시 탐색 끝

            //intensity
            for(Node adj : graph[to]){

                if(isGate[adj.to]) continue;

                int max = Math.max(weight, adj.weight);

                if(max < distance[adj.to]){
                    distance[adj.to] = max;
                    pq.offer(new Node(adj.to, max));
                }

            }
        }

        int number = -1;
        int dist = Integer.MAX_VALUE;

        for(int s : summits){
            if(distance[s] < dist){
                dist = distance[s];
                number = s;
            }else if(distance[s] == dist){
                if(s < number) number = s;
            }
        }

        return new int[]{number , dist};
    }
}
