package week13;

import java.util.ArrayDeque;
import java.util.Queue;

public class NetworksBFS {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        int answer = 0;

        for(int i = 0 ; i < n ; i++){
            if(visited[i]) continue;
            else{
                answer++;
                bfs(i, computers, n);
            }
        }

        return answer;
    }

    static void bfs(int start, int[][] computers, int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int current = q.poll();

            //computer의 인덱스로 가야한다.
            int[] adjacents = computers[current];
            int length = adjacents.length;
            for(int i = 0 ; i < length ; i++){
                if(visited[i] || (adjacents[i] == 0)) continue;

                q.offer(i);
                visited[i] = true;
            }
        }
    }
}
