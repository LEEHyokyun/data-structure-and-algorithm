package week14.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GoAndBackDijkstraTwice {
    static int INF = Integer.MAX_VALUE;
    static int N, M, X;

    static class Edge{
        int to;
        int cost;

        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node{

        //v = 정점
        //해당 정점으로 최단 가중 경로로 누적된 상태

        int v;
        int dist;

        Node(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1 2 3 .. N
        //N명의 학생
        //마을과 마을 사이에는 M개의 도로

        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());

        //인접노드 : List<Node>[]
        List<Edge>[] graph = new ArrayList[N+1];
        List<Edge>[] reversedGraph = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
            reversedGraph[i] = new ArrayList<>();
        }

        while(M-- >0){

            StringTokenizer token2 = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token2.nextToken());
            int to = Integer.parseInt(token2.nextToken());
            int cost = Integer.parseInt(token2.nextToken());

            graph[from].add(new Edge(to, cost));
            reversedGraph[to].add(new Edge(from, cost));
        }

        int[] fromX = dijkstra(graph, X);
        int[] toX = dijkstra(reversedGraph, X);

        int answer = 0;
        //N = 1 ~ N 마을에서 출발하여 거쳐서 다시 N마을로 돌아온다.
        //이 중 가장 오래 걸린 사람
        for(int i = 1 ; i <= N ; i++){
            answer = Math.max(answer, fromX[i] + toX[i]);
        }

        System.out.println(answer);
    }

    static int[] dijkstra(List<Edge>[] graph, int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        //pq는 기본적으로 높은 순서대로 정렬
        //혹은 우선순위를 comparator 기반으로(a,b) a.dist - b.dist :
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.dist > dist[cur.v]) continue; //Node의 정점 가중치가 현재 저장된 비용보다 크다면 continue

            for(Edge e : graph[cur.v]){
                //비용 구하고
                int cost = cur.dist + e.cost;

                //누적비용이 현재 비용보다 적다면 갱신
                if(cost < dist[e.to]){
                    dist[e.to] = cost;
                    pq.offer(new Node(e.to, cost));
                }
            }
        }

        return dist;
    }
}
