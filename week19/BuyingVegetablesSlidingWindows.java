package week19;

import java.util.HashMap;
import java.util.Map;

public class BuyingVegetablesSlidingWindows {
    public int solution(String[] want, int[] number, String[] discount) {

        //할인 제품은 하루에 하나씩만 구매
        //10일 동안 회원자격

        //answer = 회원등록 날짜 "가능한" 총 일수

        //슬라이딩 윈도우 : 가능한 시작일의 개수
        //discount idx pick -> i ~ i + 9 idx까지 선택 가능

        //슬라이딩 윈도우 크기 10으로 고정
        //i = 0 부터 시작해서 구매 가능인 경우라면 answer++

        Map<String, Integer> wanteds = new HashMap<>();
        Map<String, Integer> windows = new HashMap<>();
        int answer = 0;

        for(int i = 0 ; i < want.length ; i++){
            wanteds.put(want[i], number[i]);
        }

        for(int i = 0 ; i < 10 ; i++){
            //10일 동안 할인받을 수 있는 품목과 그 갯수에 대하여 winmap 구성(0~9)
            windows.put(discount[i], windows.getOrDefault(discount[i], 0) + 1);
        }

        if(check(wanteds, windows)) answer++;

        //슬라이딩 윈도우 시작
        for(int i = 10 ; i < discount.length ; i++){
            windows.put(discount[i], windows.getOrDefault(discount[i], 0) + 1);

            //i = 10 -> i = 0x
            //i = 11 -> i = 0x 1x
            windows.put(discount[i-10], windows.get(discount[i-10]) - 1);

            //if(windows.get(discount[i-10]) == 0) windows.remove(discount[i-10]);

            if(check(wanteds, windows)) answer++;

        }

        return answer;
    }

    static boolean check(Map<String, Integer> wanted, Map<String, Integer> windows){
        for(String key : wanted.keySet()){
            //원하는 수량과 할인 수량이 정확히 일치해야 함
            if(windows.getOrDefault(key, 0) != wanted.get(key)){
                return false;
            }
        }

        return true;
    }
}
