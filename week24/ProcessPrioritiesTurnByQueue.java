package week24;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProcessPrioritiesTurnByQueue {
    public int solution(int[] priorities, int location) {

        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < priorities.length ; i++){
            q.offer(new int[]{priorities[i], i});
            pq.offer(priorities[i]);
        }

        int turn = 0;

        //돌면서 현재 실행가능할 경우 turn++(실행가능하다는 것은 우선순위가 가장 높은 것),
        //그때 idx = location일때 return turn
        while(true){
            int[] cur = q.poll();
            int priority = cur[0];
            int idx = cur[1];

            //현재 가장 높은 우선순위
            /*
             * 1 1 9 1 1 1
             * 1,0 -> 1 9 1 1 1 1
             * 1,1 -> 9
             */
            int most = pq.peek();

            if(most == priority){
                pq.poll();
                turn++;
                if(idx == location) break;
            }else{
                //현재 우선순위가 아니면 실행하지 않고 넘김
                q.offer(new int[]{priority, idx});
            }
        }

        return turn;
    }
}
