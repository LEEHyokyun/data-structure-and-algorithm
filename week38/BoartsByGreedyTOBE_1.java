package week38;

import java.util.Arrays;

public class BoartsByGreedyTOBE_1 {
    public int solution(int[] people, int limit) {

        /*
         * 구명보트 한번에 최대 2명, 무게 제한
         * - 구명보트를 최대한 적게 사용해서 모든 사람을 구출하기 위한 구명보트 개수.
         */

        /*
         * 태울 수 있는 사람부터 시작해서, 최대한 많은 사람을 태운다(*최대 2명).
         */
        int answer = 1;

        Arrays.sort(people);

        int val = 0;
        int to = 0;

        for(int weight : people){
            if(val + weight <= limit && to <= limit) {
                val += weight;
                to++;
                continue;
            }else {
                answer++;
                to = 0;
                val = weight;
            }
        }

        return answer;
    }
}
