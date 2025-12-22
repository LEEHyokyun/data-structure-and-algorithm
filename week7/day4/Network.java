package week7.day4;


import java.util.ArrayDeque;
import java.util.Queue;

public class Network {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        int answer = 0;

        //bfs
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                answer++;
                bfs(i, computers, n);
            }
        }

        return answer;
    }

    static void bfs(int start, int[][] computers, int n){
        //queue 누적 필요X bfs 내에서 정의/선언
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll(); //start

            for(int i = 0 ; i < n ; i++){
                if(computers[cur][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                } //adjacent
            }
        }

    }
}
