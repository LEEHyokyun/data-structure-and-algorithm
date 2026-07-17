package week27;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Far_Node_Count_with_BFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;

    public int solution(int n, int[][] edge) {

        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i = 0 ; i < edge.length ; i++){
            int[] info = edge[i];
            int v1 = info[0];
            int v2 = info[1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return bfs(1);
    }

    static int bfs(int start){

        visited[start] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        int max = 0 ;
        int count = 0;

        while(!q.isEmpty()){

            int cur = q.poll();

            for(int adj : graph[cur]){
                if(visited[adj]) continue;

                q.offer(adj);
                visited[adj] = true;

                distance[adj] = distance[cur] + 1;

                if(max == distance[adj]) count++;
                if(distance[adj] > max) {
                    count = 1;
                    max = distance[adj];
                }
            }

        }

        return count;
    }
}
