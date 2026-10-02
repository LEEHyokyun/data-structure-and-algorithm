package week36;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GoDestinationWithSameWeight_By_BFS {
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
            if(sources[i] == destination) answer[i] = 0; //시작점
            else answer[i] = bfs(sources[i], n, destination);
        }

        return answer;
    }

    /*
     * 가중치가 동일하면 bfs
     */
    static int bfs(int start, int n, int destination){


        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){

            int cur = q.poll();

            for(Node adj : graph[cur]){

                if(visited[adj.to]) continue;

                distance[adj.to] = distance[cur] + 1;
                visited[adj.to] = true;
                q.offer(adj.to);

            }

            if(visited[destination]) break;

        }

        return (distance[destination] == 0) ? -1 : distance[destination];

    }
}
