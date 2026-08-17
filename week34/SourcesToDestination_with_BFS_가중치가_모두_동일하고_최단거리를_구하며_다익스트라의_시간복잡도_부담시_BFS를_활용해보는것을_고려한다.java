package week34;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SourcesToDestination_with_BFS_가중치가_모두_동일하고_최단거리를_구하며_다익스트라의_시간복잡도_부담시_BFS를_활용해보는것을_고려한다 {
    /*
     * 가중치가 모두 동일함 .. BFS인지 의심해봐야한다.
     */
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
            if(sources[i] == destination) answer[i] = 0;
            else answer[i] = bfs(sources[i], n, destination);
        }

        return answer;
    }

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
    /*
     * 애초에 가중치가 같으므로 BFS를 돌리는 것이 훨씬 효율적.
     */
//     static int dijkstra(int start, int n , int destination){

//         int[] distance = new int[n+1];
//         Arrays.fill(distance, INF);
//         distance[start] = 0;

//         boolean[] visited = new boolean[n+1];

//         //PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
//         Queue<Node> q = new ArrayDeque<>();
//         q.offer(new Node(start, 0));


//         while(!q.isEmpty()){

//             Node node = q.poll();
//             int to = node.to;
//             int weight = node.weight;
//             visited[node.to] = true;

//             for(Node adj : graph[to]){
//                 if(adj.weight >= distance[adj.to]) continue;
//                 if(visited[adj.to]) continue;

//                 distance[adj.to] = distance[to] + adj.weight;
//                 q.offer(adj);

//             }

//         }

//         return (distance[destination] == INF) ? -1 : distance[destination];
//     }
}
