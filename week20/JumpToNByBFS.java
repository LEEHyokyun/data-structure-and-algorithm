package week20;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpToNByBFS {
    public int solution(int n) {

        // +K(소모) or *2(소모x)
        // 건전지 사용량의 최소값

        //idx까지 가는데 소요된 건전지 사용량
        int[] count = new int[n+1];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == n) break;

            if(cur == 0){
                q.offer(1);
                count[1] = 1;
                continue;
            }

            //bfs
            //최단거리보장

            //bfs보다는 완전탐색에 더 가까울 수 있음

            if(cur + 1 <= n) {
                q.offer(cur+1);
                if(count[cur + 1] == 0){
                    count[cur+1] = count[cur] + 1;
                }else {
                    count[cur+1] = Math.min(count[cur] + 1 , count[cur+1]);
                }

            }

            if(cur * 2 <= n){
                q.offer(cur * 2);
                if(count[cur * 2] == 0){
                    count[cur * 2] = count[cur];
                }else {
                    count[cur * 2] = Math.min(count[cur * 2], count[cur]);
                }

            }

        }

        return count[n];
    }
}
