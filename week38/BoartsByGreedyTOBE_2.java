package week38;

import java.util.Arrays;

public class BoartsByGreedyTOBE_2 {
    public int solution(int[] people, int limit) {

        /*
         * 구명보트 한번에 최대 2명, 무게 제한
         * - 구명보트를 최대한 적게 사용해서 모든 사람을 구출하기 위한 구명보트 개수.
         */

        /*
         * 태울 수 있는 사람부터 시작해서, 최대한 많은 사람을 태운다(*최대 2명).
         * 가장 무거운 사람을 기준으로, 가장 가벼운 사람과 태울 수 있으면 Go, 없으면 혼자
         */
        Arrays.sort(people);

        int answer = 0;
        int start = 0;
        int end = people.length - 1;

        while(start <= end){
            int light = people[start];
            int heavy = people[end];

            System.out.println("현재 태우는 사람 : " + light + ", " + heavy);

            if(light + heavy > limit) {
                System.out.println("혼자탑니다.");
                end--;
            }else {
                System.out.println("둘이탑니다.");
                start++;
                end--;
            }

            answer++;
        }

        return answer;
    }
}
