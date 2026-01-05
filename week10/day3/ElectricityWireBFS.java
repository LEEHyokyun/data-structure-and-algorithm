package week10.day3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ElectricityWireBFS {
    List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        int N = wires.length;
        graph = new ArrayList[n+1];  //N -> wires의 개수, 실제 송전탑 개수 -> N+1

        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < N ; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        //bfs
        int answer = 100;
        int count = 0;
        int diff = 0;
        //int start = wires[0][0]; // 고정
        for(int i  = 0 ; i < N  ; i++){
            int u = wires[i][0]; //끊었음
            int v = wires[i][1]; //여기로 못감
            boolean[] visited = new boolean[n+1];

            count = bfs(visited, graph, u, v);
            int differ = Math.abs(n - 2*count);

            answer = Math.min(answer, differ);
        }

        return answer;
    }

    static int bfs(boolean[] visited, List<Integer>[] graph, int start, int sliced){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        int answer = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            answer++;
            visited[u] = true;

            for(int v : graph[u]){
                if(u == start && v == sliced) continue;
                if(visited[v]) continue;

                q.offer(v);
                //answer++;
            }
        }

        return answer;
    }
}
