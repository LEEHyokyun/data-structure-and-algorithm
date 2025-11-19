package week2.day6;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        //우선순위 큐
        //중요한 것은 가장 작은 것을 가져온다
        //배열/정렬을 이용하면 가장 작은 두 요소를 빼올때마다 배열이 달라지므로 for 순회 의미없음.
        //단계수행때마다 요소가 달라진다? 배열을 이용한 풀이는 아니다.

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위큐 구현체
        for(int x : scoville) pq.add(x);

        //2개 남을때까지
        while(pq.size() > 1){

            //애초에 처음요소가 K이상이라면 그걸로 끝
            int first = pq.poll();
            if(first >= K) return answer;

            int second = pq.poll();
            int mixed = first + second * 2;
            pq.add(mixed);
            answer++;

        }

        //저 경우를 모두 돌았을 경우 = 최종 1개가 남았을 경우
        //이 1개에 대해서도 마지막 확인 처리를 진행
        answer = pq.poll() >= K? answer++ : -1;

        return answer;
    }
}
