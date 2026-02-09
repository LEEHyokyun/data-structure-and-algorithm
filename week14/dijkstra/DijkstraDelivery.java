package week14.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraDelivery {
    static class Edge{ //info
        int to, w;
        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }

    static class Node{ //cost
        int v, dist;
        Node(int v, int dist){
            this.v = v;          //인접노드
            this.dist = dist;    //로의 거리
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //graph 정보 - Edge
        List<Edge>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] info : road){

            int u = info[0];
            int v = info[1];
            int w = info[2];

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int[] dist = new int[N+1]; //init
        Arrays.fill(dist, INF); //init
        dist[1] = 0; //시작점

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist); //a-b<0 -> a-b, b-a<0 -> b-a
        pq.offer(new Node(1,0)); //시작점

        while(!pq.isEmpty()){
            Node cur = pq.poll();  //순회기준 = pq우선순위 = 노드

            if(cur.dist <= dist[cur.v]){     //인접노드 거리가 dist보다 크면 누적할 필요 없음
                for(Edge e : graph[cur.v]){ //경로 누적 = 그래프 = edge
                    int cost = cur.dist + e.w; //Node -> 현재, Edge -> 인접
                    if(cost < dist[e.to]){
                        pq.offer(new Node(e.to, cost));
                        dist[e.to] = cost;
                    }
                }
            }
        }

        for(int cost : dist){
            if(cost <= K) answer ++;
        }


        return answer;
    }
}
