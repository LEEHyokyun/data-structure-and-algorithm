package week11.day1;

import java.util.*;

public class TheMostFarNodeBFS {
    static List<Integer>[] graph;

    public int solution(int n, int[][] edge) {

        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < edge.length ; i++){
            int u = edge[i][0];
            int v = edge[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int answer = bfs(n, 1);

        //가장 멀리 떨어진 = 간선 개수

        return answer;
    }

    static int bfs(int n, int start){
        int[] dist = new int[n+1]; //1 ~ n
        Arrays.fill(dist, -1);

        dist[start] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    q.offer(next); // 1-> 2 o // 2->1 x
                }

            }
        }


        int count = 0;
        int answer = 0;
        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == answer) count++;
            if(dist[i] > answer) {
                count = 1;
                answer = dist[i];
            }
        }

        return count;
    }
}
