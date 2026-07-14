package week29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class String_simulation_with_Tuple {
    public int[] solution(String s) {
        /*
         * (1,2,3) != (2,3,1) (*요소 순서 고려, 서로 다른 튜플)
         * n개의 tuple, 중복되는 원소가 없음
         * {a1} {a1, a2} {a1, a2, a3} , .... (1 2 3 4 .... n)..
         */
        //제거 방법 : 중괄호 맨 앞뒤 2개 제거하고, },{ 기준 split(*{} escape 처리 필수)
        String[] sets = s.substring(2, s.length() - 2).split("\\},\\{");
        // for(String str : stringArrays){
        //     System.out.println("stringArrays 요소 확인 : " + str);
        // }

        int[] answer = new int[sets.length];

        //1 2 3 4 ...
        //내부 요소까지 한꺼번에 오름차순 정렬됨
        Arrays.sort(sets, (a, b) -> a.length() - b.length());

        //map보다는 set이 훨씬 편함
        Set<Integer> visited = new HashSet<>();

        int idx = 0;

        for(String set : sets){
            String[] numbers = set.split(",");

            for(String num : numbers){

                int val = Integer.parseInt(num);

                if(visited.contains(val)) continue;
                else {
                    visited.add(val);
                    answer[idx++] = val;
                    break;
                }
            }
        }

        return answer;
    }
}
