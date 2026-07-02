package week27;

import java.util.ArrayDeque;
import java.util.Queue;

public class Networks_BFS {
    static boolean[] selected;

    public int solution(int n, int[][] computers) {

        if(n == 1) return 1;

        selected = new boolean[n];
        int answer = 0;

        for(int i = 0 ; i < n ; i++){
            if(selected[i]) continue;
            else {
                bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    static void bfs(int node, int[][] computers){

        //System.out.println("현재 노드 : " + node);
        selected[node] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()){
            //System.out.println("큐 추출");
            int cur = q.poll();

            for(int i = 0 ; i < computers[cur].length ; i++){
                if(computers[cur][i] == 0) {
                    //System.out.println("현재 " + cur +"번째 노드의 인접노드들 중 " + i + "노드랑은 미연결");
                    continue;
                }
                if(selected[i]) {
                    //System.out.println("현재 " + cur +"번째 노드의 인접노드들 중 " + i + "노드는 이미 방문함");
                    continue;
                }

                //System.out.println("인접노드 추가 : " + i);

                q.offer(i);
                selected[i] = true;
            }
        }

    }
}
