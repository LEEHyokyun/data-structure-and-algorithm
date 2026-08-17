package week34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourcesToDestination_with_for_Dijkstra {
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

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        /*
         * 부대원(sources) -> 강철부대 지역으로 복귀(destination)
         * sources 순서대로 최단 시간으로 복귀할 수 있는 각 시간들.
         */
        graph = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++) graph[i] = new ArrayList<>();

        for(int[] road : roads){
            int from = road[0];
            int to = road[1];

            graph[from].add(new Node(to, 1));
            graph[to].add(new Node(from, 1));
        }

        int[] answer = new int[sources.length];
        for(int i = 0 ; i < sources.length ; i++){
            answer[i] = dijkstra(sources[i], n, destination);
        }

        return answer;
    }

    static int dijkstra(int start, int n, int destination){

        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        //System.out.println("start : " + start);
        //System.out.println("distance[start] : " + distance[start]);

        for(int i = 0 ; i < n ; i++){

            int minNode = -1;
            int minDist = INF;

            for(int j = 1 ; j <= n ; j++){

                //System.out.println("j : " + j);
                //System.out.println("distance[j] : " + distance[j]);

                if(visited[j]) continue;
                if(distance[j] < minDist){
                    minNode = j;
                    minDist = distance[j];
                }

                //System.out.println("minNode : " + minNode);

                if(minNode == -1) continue; //다음 최단 가중치를 탐색하도록 건너뛰기
                visited[minNode] = true;

                for(Node adj : graph[minNode]){
                    //System.out.println("1 : " + distance[adj.to]);
                    //System.out.println("2 : " + distance[minNode]);
                    //System.out.println("3 : " + adj.weight);
                    if(distance[adj.to] > distance[minNode] + adj.weight){
                        //System.out.println("다익스트라 갱신 조건 충족");
                        distance[adj.to] = distance[minNode] + adj.weight;
                    }

                }

            }

        }

        return (distance[destination] == INF) ? -1 : distance[destination];
    }
}
