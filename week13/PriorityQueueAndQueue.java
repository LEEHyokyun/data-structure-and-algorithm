package week13;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueAndQueue {
    public int solution(int[] priorities, int location) {

        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int length = priorities.length;
        for(int i = 0 ; i < length ; i++){
            q.offer(new int[]{priorities[i], i});
            pq.offer(priorities[i]);
        }

        //몇번째에 실행하는가.
        int count = 0;

        while(true){
            int[] cur = q.poll();
            int value = cur[0];
            int index = cur[1];

            if(value == pq.peek()){
                pq.poll();
                count++;

                if(index == location){
                    break;
                }
            }else{
                q.offer(cur);
            }
        }

        return count;
    }
}
