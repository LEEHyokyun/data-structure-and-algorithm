package week22;

import java.util.PriorityQueue;

public class ScovillePriorityQueue {
    public int solution(int[] scoville, int K) {

        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + 두번째로 맵지 않은 음식의 스콜 지수 * 2
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순 배열..가장 낮은 수치가 우선순위

        for(int s : scoville){
            pq.offer(s);
        }

        if(pq.peek() >= K) return 0;

        int count = 0;
        while(!pq.isEmpty()){

            if(pq.size() == 1) break;
            if(pq.peek() >= K) return count;

            int s1 = pq.poll();
            int s2 = pq.poll();
            count++;

            int s = s1 + s2 * 2;
            pq.offer(s);

        }

        //최종
        if(!pq.isEmpty() && pq.peek() >= K) return count++;

        return -1;
    }
}
