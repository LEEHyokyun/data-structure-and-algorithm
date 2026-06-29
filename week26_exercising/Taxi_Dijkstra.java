package week26_exercising;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Taxi_Dijkstra {
    static class Node{
        int to;
        int cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*
         * 다익스트라? 플로이드워셜?
         * 플로이드 워셜은 모든 정점을 공유지로 고려하면서, 3중 반복
         * 다익스트라의 핵심은 가중치.
         * s > stopby > a > b 의 가중치를 고려한 최단거리를 구하는 것이 핵심.
         */

        graph = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        //양방향 그래프
        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        //s - 합승지점, 모든 지점을 합승 종료 지점으로 가정하고 각각 도착
        //s->n->a->b
        //s<->n + n<->a + n<->b .. 각 정점 합에 대한 최소값 도출
        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);

        int answer  = INF;

        for(int i = 1 ; i <= n ; i++){
            answer = Math.min(answer,
                    distS[i] + distA[i] + distB[i]);
        }

        return answer;
    }

    //모든 정점을 경유지로 일단 고려
    private int[] dijkstra(int n , int start){

        //n : 정점 개수 , start : 출발점

        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(dist, INF);
        dist[start] = 0; //start to start =  0

        for(int i = 1 ; i <= n ; i++){

            int minNode = -1;
            int minDist = INF;

            //아직 방문하지 않은 정점들 중 최단거리 선택
            for(int j = 1 ; j <= n ; j++){
                if(visited[j]) continue;

                //다익스트라의 특징은 최단거리를 일단 선택하는 것(인접노드 상관없이)
                if(dist[j] < minDist){
                    minDist = dist[j];
                    minNode = j;
                }
            }

            //더이상 갈 수 있는 정점이 없다면(모두 이미 방문한 상태)
            if(minNode == -1) break;

            visited[minNode] = true;

            for(Node next : graph[minNode]){
                //최단거리의 노드를 거쳐가는 비용이 인접노드로 바로 가는 비용보다 크다면 다익스트라 .. 그 거리를 인접노드를 통한 거리로 갱신한다.
                if(dist[next.to] > dist[minNode] + next.cost){
                    dist[next.to] = dist[minNode] + next.cost;
                }
            }
        }

        return dist;
    }
}
