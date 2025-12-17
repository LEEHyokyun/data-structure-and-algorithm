package week6.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node{
        int v, dist;
        Node(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[V+1];
        for(int i = 1; i <= V ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E ; i++){
            StringTokenizer edge = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(edge.nextToken());
            int v = Integer.parseInt(edge.nextToken());
            int w = Integer.parseInt(edge.nextToken());

            graph[u].add(new Edge(v, w));
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist); //a -> b(거리 오름차순)
        pq.offer(new Node(K, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.dist > dist[cur.v]) continue;

            //인접노드로
            for(Edge e : graph[cur.v]){
                int cost = cur.dist + e.weight;   //현재노드에서 인접노드로의 가중치 합(경로)
                if(cost < dist[e.to]){  //현재의 가중치 값보다 작은가
                    dist[e.to] = cost; //작으면 갱신
                    pq.offer(new Node(e.to, cost)); //인접노드 정보 넣기
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= V ; i++){
            if(dist[i] == INF) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }

        System.out.print(sb);
    }
}
