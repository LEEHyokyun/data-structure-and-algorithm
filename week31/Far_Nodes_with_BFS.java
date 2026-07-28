package week31;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Far_Nodes_with_BFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;

    public int solution(int n, int[][] edge) {

        distance = new int[n+1];
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edge){

            int from = e[0];
            int to = e[1];

            graph[from].add(to);
            graph[to].add(from);

        }

        return bfs(1);

    }

    static int bfs(int start){

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int max = 0;
        int answer = 0;

        while(!q.isEmpty()){

            int cur = q.poll();

            for(int adj : graph[cur]){
                if(visited[adj]) continue;

                q.add(adj);
                visited[adj] = true;

                distance[adj] = distance[cur] + 1;

                if(distance[adj] > max){
                    answer = 1;
                    max = distance[adj];
                }else if(distance[adj] == max){
                    answer++;
                }
            }
        }

        return answer;

    }
}
