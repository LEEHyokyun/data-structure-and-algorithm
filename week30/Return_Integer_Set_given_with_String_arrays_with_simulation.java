package week30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Return_Integer_Set_given_with_String_arrays_with_simulation {
    Set<String> set = new HashSet<>();

    public int[] solution(String s) {
        int originLength = s.length() ;
        String[] sliced = s.substring(2, originLength - 2).split("\\},\\{");
        Arrays.sort(sliced, (a, b) -> a.length() - b.length());

        int[] answer = new int[sliced.length];
        int idx = 0;
        for(String str : sliced){

            String[] factors = str.split(",");

            for(String factor : factors) {
                if(set.contains(factor)) continue;
                else {
                    answer[idx++] = Integer.parseInt(factor);
                    set.add(factor);
                }
            }

        }

        return answer;
    }
}
