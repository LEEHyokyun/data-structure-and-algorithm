package week34;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rubies_with_SlidingWindow_and_Map_and_Set_단조성을_구입한_과일의_개수로_판별하여_구입한_과일_조건만족시_최초구입과일_제거_불만족시_이후_추가구입 {
    static Map<String, Integer> buyed = new HashMap<>();
    static Set<String> list = new HashSet<>();

    public int[] solution(String[] gems) {
        /*
         * 모든 보석을 포함한다면 start 이동
         * 모든 보석을 포함하지 못한다면 end 이동
         */
        for(String gem : gems) list.add(gem);

        int start = 0;
        int end = 0;

        int answerS = 0;
        int answerE = gems.length - 1;

        buyed.put(gems[start], buyed.getOrDefault(gems[start], 0) + 1);
        if(buyed.size() == list.size()) return new int[]{1,1};

        while(true){

            //아직 모든 보석 사지 못했다면 end 증가
            if(buyed.size() < list.size()){

                end++; //증가하고, 증가한 보석을 buyed에 적용
                //System.out.println("현재 end : " + end);

                /*
                 * 더이상 증가할 수 있는 보석이 없다면, 즉 보석을 제거하였음에도 보석을 늘릴 수 없다는 탈출
                 */
                if(end == gems.length) {
                    //start--; //제거한 보석 다시 원복
                    end--; //제거한 보석 다시 원복
                    break;
                }

                buyed.put(
                        gems[end],
                        buyed.getOrDefault(gems[end], 0) + 1
                );

            }else {

                /*
                 * 모든 보석을 샀으므로 이 구간은 최적의 해 후보에 일단 기록
                 * 여기로 왔다는 것 자체가 이미 모두 샀다는 얘기이다.
                 */
                if((end - start) < (answerE - answerS)){
                    //System.out.println("현재 조건은 start, end 상태 : " + start + "," + end);
                    answerE = end;
                    answerS = start;
                }

                //모든 보석을 샀다면 start를 제거
                String gem = gems[start];

                buyed.put(
                        gem,
                        buyed.get(gem) - 1
                );

                //제거한 결과가 0이라면 아예 제거
                if(buyed.get(gem) == 0) buyed.remove(gem);

                start++;

            }

        }

        return new int[]{answerS + 1, answerE + 1};

    }
}
