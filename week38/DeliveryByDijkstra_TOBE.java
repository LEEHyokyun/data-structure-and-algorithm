package week38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DeliveryByDijkstra_TOBE {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static int INF = Integer.MAX_VALUE;
    static List<Node>[] list;

    public int solution(int N, int[][] road, int K) {

        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) list[i] = new ArrayList<>();

        for(int[] info : road){
            int from = info[0];
            int to = info[1];
            int weight = info[2];

            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }

        return dijkstra(N, K);

    }

    static int dijkstra(int N, int K){
        int[] distance = new int[N+1];
        Arrays.fill(distance, INF);

        //각 노드를 순회하면서 가장 가중치가 작은 노드를 찾지 말고 우선순위 큐 활용.
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.weight - b.weight;
        });

        //최초 시작점
        distance[1] = 0;
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int curTo = cur.to;
            int curWeight = cur.weight;

            //최단거리 갱신이 목적, 가중치가 더 크면 볼 필요 없음
            if(curWeight > distance[curTo]) continue;

            //if(curWeight >= K) continue;

            //인접노드로 바로 가는 거리 > 현재 노드 거쳐서 가는 거리 -> 갱신
            for(Node adj : list[curTo]){
                if(distance[adj.to] > adj.weight + distance[curTo]){
                    distance[adj.to] = adj.weight + distance[curTo];
                    pq.offer(new Node(adj.to, adj.weight));
                }
            }
        }

        int answer = 0;
        for(int dis : distance){
            if(dis <= K) answer++;
        }

        return answer;
    }
}
