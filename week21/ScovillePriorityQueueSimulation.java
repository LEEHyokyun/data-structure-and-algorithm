package week21;

import java.util.PriorityQueue;

public class ScovillePriorityQueueSimulation {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        //스코빌 지수 가장 낮은 스코빌 + (그 다음 낮은 스코빌*2)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //min heap .. poll() -> 가장 숫자가 낮은 = 우선순위가 가장 높은

        for(int s : scoville){
            pq.offer(s);
        }

        if(pq.peek() >= K) return 0;

        int count = 0;
        while(true){

            if(pq.peek() >= K) return count;
            if(pq.isEmpty() || pq.size() == 1) break;

            int x1 = pq.poll();
            int x2 = pq.poll();

            int s = x1 + x2 * 2;
            count++;

            pq.offer(s);
        }

        return -1;
    }
}
