package week19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TwoArreaOfWiresBFS {
    static List<Integer>[] list;

    public int solution(int n, int[][] wires) {

        list = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }

        for(int[] wire : wires){
            int u = wire[0];
            int v = wire[1];

            list[u].add(v);
            list[v].add(u);
        }

        int balance = Integer.MAX_VALUE;
        for(int[] wire : wires){
            int k = bfs(wire, n);
            balance = Math.min(balance, Math.abs((n-2*k)));
        }

        return balance;
    }

    static int bfs(int[] sliced, int n){

        int num = 1;

        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list[cur]){
                if(cur == sliced[0] && next == sliced[1]) continue;
                if(cur == sliced[1] && next == sliced[0]) continue;
                if(visited[next]) continue;

                q.offer(next);
                visited[next] = true;
                num++;
            }
        }

        return num;
    }
}
