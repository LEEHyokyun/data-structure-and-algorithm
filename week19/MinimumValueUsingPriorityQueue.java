package week19;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumValueUsingPriorityQueue {
    public long solution(int n, int[] works) {

        //야근 피로도 = (야근 시작한 시점에서 남은 일의 작업량)^2 을 더한 값
        //n시간 동안 야근 피로도를 최소화 하도록,
        //1시간 = 1 처리 가능

        //균등 분배가 아닌
        //가장 큰 값을 줄이는 것이 핵심.
        long answer = getMinValue(n, works);

        return answer;
    }

    static long getMinValue(int n, int[] works){
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works){
            pq.add(work);
            //Integer 기반의 PQ -> 가장 작은 수 부터 추출
            //이를 역전 순회 : Comparator reverseOrder
        }

        while(n-- >0){
            int max = pq.poll();

            if(max == 0) return 0 ;

            pq.add(max - 1);
            //n--;  //pq를 활용하여, 최대수를 추출해서 -1...
        }

        long answer = 0;

        for(int work : pq){
            answer += (long) ( work * work );
        }

        return answer;
    }
}
