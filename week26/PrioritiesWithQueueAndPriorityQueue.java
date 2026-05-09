package week26;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrioritiesWithQueueAndPriorityQueue {
    public int solution(int[] priorities, int location) {
        //숫자 높을수록 우선순위 높은 것
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>();

        int idx = 0;
        for(int priority : priorities) {
            pq.offer(priority);
            q.offer(new int[]{priority, idx++});
        }
        //일단 끝까지 실행해야 함
        int answer = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(pq.peek() == cur[0]){
                int priority = pq.poll();
                answer++;

                if(cur[1] == location) {
                    break;
                }
            } else {
                q.offer(cur);
            }
        }

        return answer;
    }
}
