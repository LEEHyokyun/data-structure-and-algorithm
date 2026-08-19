package week34;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rubies_with_SlidingWindow_and_Map_and_Set {
    /*
     * 구매해야 하는 보석 리스트
     */
    Set<String> list = new HashSet<>();
    /*
     * 구입한 보석 리스트
     */
    Map<String, Integer> buyed = new HashMap<>();

    public int[] solution(String[] gems) {
        /*
         * 적어도 1개 이상의 보석을 보유할때
         * 길이가 동일하다면 시작 진열대 번호가 작은 것으로
         */
        for(String gem : gems){
            list.add(gem);
        }

        int start = 0;
        int end = 0;
        int count = 1;
        buyed.put(gems[start], 1);

        if(list.size() == buyed.keySet().size()) return new int[]{1,1};

        //만족하는 보석을 구성하기 위해 끝까지 이동해야할 수 있음
        while(true){

            /*
             * 만족할때까지 늘리면서, 구매 대상 보석 리스트를 제거해나간다.
             * 어느때 구간을 줄이느냐 -> 일단 끝까지
             */
            if(list.size() != buyed.keySet().size()){
                end++;

                //구매 내역에 넣고
                //System.out.println("추가 내역 : " + gems[end]);

                buyed.put(gems[end], buyed.getOrDefault(gems[end], 0) + 1);
                //System.out.println("해당 보석의 현재 카운트 : " + buyed.get(gems[end]));
                //최소 한개 이상 넣었으면 종료
                //if(list.size() == buyed.keySet().size()) break;

            } else {
                /*
                 * 끝까지 진행할 경우 start를 늘리면서 중복 보석을 점진적으로 제거
                 */
                if(buyed.get(gems[start]) > 1) {
                    //System.out.println("현재 gems[start]는 2개 이상입니다 : " + gems[start]);
                    //System.out.println("start : " + start);
                    buyed.put(gems[start], buyed.get(gems[start]) - 1); //제거하고
                    start++; //증가

                }
                else break;
                //break;
            }
        }

        return new int[]{start + 1, end + 1};
    }
}
