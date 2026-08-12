package week33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//특정 시작점에서 출발하여 각 마을로 도달하는 가중치의 최소 합 = 다익스트라

public class Delivery_with_DIjkstra {
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

        graph = new ArrayList[N + 1];

        for(int i = 0 ; i <= N ; i++){
            //객체화는 모두 온전히 진행
            graph[i] = new ArrayList<>();
        }

        for(int[] r : road){
            int from = r[0];
            int to = r[1];
            int weight = r[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        return dijkstra(N, K);

    }

    //시작점 : 1
    static int dijkstra(int N, int K){

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        /*
         * 최초 거리는 INF!
         */
        Arrays.fill(distance, INF);

        //시작점 거리 = 0
        distance[1] = 0;

        //노드 개수 만큼 순회
        for(int i = 1 ; i <= N ; i++){

            int minNode = -1;
            int minDist = INF;

            //지금까지 알려진 최단거리 찾고 인접거리 갱신
            for(int j = 1 ; j <= N ; j++){
                if(visited[j]) continue;

                if(distance[j] < minDist){
                    minNode = j;
                    minDist = distance[j];
                }
            }

            //위에서 도출한 최소 거리를 기준으로 인접노드 갱신 진행

            if(minNode == -1) break;
            visited[minNode] = true;

            //System.out.println("현재까지 알려진 최소 거리의 노드 : " + minNode);

            //거리 갱신 : 인접노드로 바로 가느냐, 현재 거리를 거쳐 인접노드로 가느냐.
            for(Node adj : graph[minNode]){
                //System.out.println("인접노드 : " + adj.to);
                //System.out.println("인접노드로 가는 거리 : " + distance[adj.to]);
                //System.out.println("거쳐가는 거리 : " + (distance[minNode] + adj.weight));

                if(distance[adj.to] > distance[minNode] + adj.weight){
                    distance[adj.to] = distance[minNode] + adj.weight;
                }
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= N ; i++){
            System.out.println("최종 가중치 합 : " + distance[i]);
            if(distance[i] <= K) answer++; //자기 자신 포함
        }

        return answer;

    }
}
