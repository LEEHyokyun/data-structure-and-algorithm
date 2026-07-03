package week27;

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
        graph = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        //환승을 고려하였을때
        //s n n a n b
        //환승지점을 N이라 했을때 각 가중치의 합
        int[] distSN = dijkstra(n, s);
        int[] distNA = dijkstra(n, a);
        int[] distNB = dijkstra(n, b);

        int answer = INF;

        for(int i = 1 ; i<= n ; i++){
            //각 정점지점에 대한 가중치 합 중 최소값 도출
            answer = Math.min(answer, distSN[i] + distNA[i] + distNB[i]);
        }

        return answer;
    }

    /*
     * "시작점(s)으로부터 현재까지 알려진 거리 중 가장 짧은 노드"를 하나씩 확정
     * dist[i] = 시작점(s)로부터 현재까지 알려진 거리 중 i로 갈 수 있는 가장 최단거리.
     */
    static int[] dijkstra(int n, int s){
        //노드는 1부터
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(dist, INF);
        dist[s] = 0; //시작지점

        //일단 최근접 거리 구하기
        for(int i = 1 ; i <= n ; i++){

            int minNode = -1;
            int minDist = INF;

            //최초 시작점을 먼저 구하고, 이를 기반으로 이후 순회에서 계속 갱신됨
            for(int j = 1 ; j <= n ; j++){
                if(visited[j]) continue;

                if(dist[j] < minDist){
                    minDist = dist[j];
                    minNode = j;
                }
            }

            //근접거리 갱신 완료 시 탈출
            if(minNode == -1) break;

            visited[minNode] = true;

            //근접거리 갱신(시작지점은 항상 s)
            //현재까지 알려진 거리 중 인접노드까지 최단거리를 갱신하는 과정
            //인접노드를 갱신하였으므로, 다음 순회도 인접노드가 계속 반복되는 것임.
            for(Node next : graph[minNode]){
                //s -> next 보다 minNode를 거쳐 next로 가는게 작다면 갱신
                if(dist[next.to] > dist[minNode] + next.cost){
                    dist[next.to] = dist[minNode] + next.cost;
                }
            }
        }

        return dist;
    }
}
