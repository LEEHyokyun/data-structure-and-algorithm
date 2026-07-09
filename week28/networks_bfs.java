package week28;

import java.util.ArrayDeque;
import java.util.Queue;

public class networks_bfs {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {

        if(n == 1) return 1;

        int count = 0;
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(visited[i]) continue;
            else {
                count += bfs(i, computers);
            }
        }

        return count;
    }

    static int bfs(int start, int[][] computers){

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){

            int cur = q.poll();

            int[] adjs = computers[cur];

            for(int i = 0 ; i < adjs.length ; i++){
                if(adjs[i] == 0) continue;
                if(visited[i]) continue;
                if(adjs[i] == 1) {
                    if(cur == i) continue;
                    //System.out.println(cur + "노드의 인접 노드 : " + i);
                    q.offer(i);
                    visited[i] = true;
                }
            }

        }

        return 1;
    }
}
