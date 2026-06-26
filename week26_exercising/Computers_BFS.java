package week26_exercising;

import java.util.ArrayDeque;
import java.util.Queue;

public class Computers_BFS {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        int answer = 0;

        for(int i = 0 ; i < n ; i++){

            System.out.println("현재 노드는 : " + i);

            if(visited[i]) continue;
            else {
                answer++;
                bfs(i, computers, n);
            }
        }

        return answer;
    }

    static void bfs(int start, int[][] computers, int n){
        Queue<Integer> q = new ArrayDeque<>();

        //인접 노드를 넣는 시점
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            //System.out.println("bfs를 진행합니다. 현재 노드는 : " + cur);

            int[] adjList = computers[cur];

            for(int i = 0 ; i < adjList.length ; i++){

                if(visited[i]) continue;
                else{
                    if(adjList[i] == 0) continue;
                    else {
                        //System.out.println("현재 노드[" + cur + "]의 인접 노드를 추가합니다. : " + i);
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }
}
