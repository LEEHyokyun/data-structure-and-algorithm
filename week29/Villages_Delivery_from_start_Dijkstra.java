package week29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Villages_Delivery_from_start_Dijkstra {
    /*
     * 다익스트라
     * - 출발점 명확하고
     * - 가중치 합의 최소
     */
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {

        //N개의 마을 중에 K 시간 이하로 배달이 가능한 마을
        //출발점 : 1
        graph = new ArrayList[N + 1];
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

        int answer = dijkstra(1, N, K);
        return answer;
    }

    static int dijkstra(int start, int villages, int limit){

        int[] distance = new int[villages + 1];
        boolean[] visited = new boolean[villages + 1];

        //inf
        Arrays.fill(distance, INF);

        //starting point
        distance[start] = 0;

        //for i : villages , j : minimum distance
        for(int i = 1 ; i <= villages ; i++){

            int minDist = INF;
            int minNode = -1;

            for(int j = 1 ; j <= villages ; j++){
                if(visited[j]) continue;
                if(distance[j] < minDist) { //지금까지 알고 있는 거리 중 가장 최단 거리를 도출
                    minNode = j;
                    minDist = distance[j];
                }
            }

            if(minNode == -1) break;
            visited[minNode] = true;

            for(Node adj : graph[minNode]){
                //start에서, adj에 직접 가는것보다 minNode를 거쳐 adj로 가는 경로 비교 및 갱신
                if(distance[adj.to] > adj.weight + distance[minNode]){
                    distance[adj.to] = adj.weight + distance[minNode];
                }
            }
        }

        int count = 0;
        for(int i = 1 ; i <= villages ; i++){
            System.out.println("start to " + i + " : " + distance[i]);
            if(distance[i] <= limit) {
                //System.out.println("distance : " + distance[i] + " K : " + limit + " = 조건 만족");
                //System.out.println("count = " + count);
                count++;
            }
        }

        //count에 1번 마을 포함
        return count;
    }
}
