package week5.day4;

import java.util.*;

public class BFSForFarNode {
    public int solution(int n, int[][] edge) {

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < edge.length ; i++){
            int[] adjacent = edge[i];
            //쌍방향 정보 모두 입력 필요함
            graph[adjacent[0]].add(adjacent[1]);
            graph[adjacent[1]].add(adjacent[0]);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, 0);

        Queue<Integer> q = new ArrayDeque<>();
        dist[1] = 1;
        q.offer(1);

        while(!q.isEmpty()){
            int current = q.poll();

            for(int ad : graph[current]){
                if(dist[ad] == 0){
                    dist[ad] = dist[current] + 1;
                    q.offer(ad);
                }
            }
        }

        int max = 0;
        int count = 0;
        for(int i = 1; i <= n ; i++){
            if(dist[i] > max){
                max = dist[i];
                count = 1;
            }else if(dist[i] == max){
                count ++;
            }
        }

        return count;
    }
}
