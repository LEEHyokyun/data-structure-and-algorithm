package week28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Taxi_min_Weights_Dijkstra {
    /*
     * 특정 출발 지점에서 경유지를 고려한 최소 가중치 경로
     */
    static class Node{
        //from = graph의 index
        int to;
        int weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*
         * 출발지점 : s, A : a, B : b
         * 합승하고 내리는 지점 : x
         * = dijkstra(s, x) + dijkstra(x, a) + dijkstra(x, b)
         * = x를 어디로 하느냐(x 최소지점 특정)
         */
        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int weight = fare[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        //참고로 경유지가 필요없다면 X는 A, B 둘 중 하나로 도출될 것이다.
        //출발지가 명확, 도착지점에 대한 최소거리를 갱신.
        int[] dijkstraSX = dijkstra(s, n);
        int[] dijkstraAX = dijkstra(a, n);
        int[] dijkstraBX = dijkstra(b, n);

        int answer = INF;
        for(int i = 1 ; i <= n ; i++){
            answer = Math.min(answer,
                    dijkstraSX[i] + dijkstraAX[i] + dijkstraBX[i]
            );
        }

        return answer;
    }

    /*
     * 특정 지점에서 특정 지점으로 갈때 가중치 최소의 합
     * 지금까지 알고있는 인접거리를 갱신해나간다.
     */
    static int[] dijkstra(int from, int n){

        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(distance, INF);
        distance[from] = 0;

        //최단거리를 구하고, 이걸 인접노드화하여 갱신해나가는 것.
        //최단거리를 일단 구하는데, 이것이 인접노드라는 점이 핵심(start가 본인이므로)
        //이때 i는 정점을 의미하지 않는다. 각 노드에 대한 인접노드를 갱신하기 위한 반복순회 개수를 제공한다.
        for(int i = 1 ; i <= n ; i++){

            int minDist = INF;
            int minNode = -1;

            //출발점은 이미 특정된 상태, 갱신마다 최단거리 및 인접노드를 찾아가면서 갱신하는 과정.
            //최초 반복의 i는 횟수일뿐, 그 이상 그 이하도 아니다(정점을 의미하지 않는다)
            for(int j = 1 ; j <= n ; j++){
                if(visited[j]) continue;
                if(distance[j] < minDist) {
                    minDist = distance[j];
                    minNode = j;
                }
            }

            //탈출 조건 및 방문여부 확인
            if(minNode == -1) break;
            visited[minNode] = true;

            //바로 다익스트라 적용
            for(Node adj : graph[minNode]){
                //start -> adj > start + minNode(distance[minNode]) + minNode + adj(adj.weight)
                if(distance[adj.to] > adj.weight + distance[minNode]){
                    distance[adj.to] = adj.weight + distance[minNode];
                }
            }
        }

        return distance;
    }
}
