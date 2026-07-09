package week28;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class far_node_graph_and_bfs {
    static boolean[] visited;
    static int[] distance;

    /*
    * 특정 요소에 대한 제너릭을 명기하는 것이 좋겠다.
    * for int adj -> 제너릭 명기가 반드시 전제되어야한다.
    * */
    static List<Integer>[] graph;

    public int solution(int n, int[][] edge) {

        visited = new boolean[n+1];
        distance = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edge.length ; i++){

            int v1 = edge[i][0];
            int v2 = edge[i][1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return bfs(1);
    }

    static int bfs(int start){

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        int count = 0;
        int max = 0;

        while(!q.isEmpty()){

            int cur = q.poll();

            for(int adj : graph[cur]){

                //int adj = graph[cur].get(i);

                if(visited[adj]) continue;
                distance[adj] = distance[cur] + 1;

                q.offer(adj);
                visited[adj] = true;

                if(distance[adj] > max) {
                    max = distance[adj];
                    count = 1;
                }else if(distance[adj] == max){
                    count++;
                }
            }

        }

        return count;

    }
}
