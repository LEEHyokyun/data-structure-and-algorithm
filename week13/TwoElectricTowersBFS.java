package week13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TwoElectricTowersBFS {
    static List<Integer>[] list;

    public int solution(int n, int[][] wires) {

        list = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < wires.length ; i++){
            int u = wires[i][0];
            int v = wires[i][1];

            list[u].add(v);
            list[v].add(u);
        }

        //bfs
        int answer = 101;
        int count = 0;
        int diff = 0;

        for(int i = 0 ; i < wires.length ; i++){
            int u = wires[i][0];
            int v = wires[i][1];

            boolean[] visited = new boolean[n+1];

            count = bfs(visited, u, v);   //u 시작, v로 가면 안됨
            diff = Math.abs(n - 2 * count);

            answer = Math.min(answer, diff);
        }

        return answer;
    }

    static int bfs(boolean[] visited, int start, int target){ //start = u , v x
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        int count = 1;

        while(!q.isEmpty()){
            int u = q.poll();
            visited[u] = true;

            for(int next : list[u]){
                if(u == start && next == target) continue;
                if(u == target && next == start) continue;
                if(visited[next]) continue;

                count++;
                q.offer(next);
            }
        }

        return count;
    }
}
