package week2.day1;

import java.util.Arrays;

public class StringComparingWays {
    class Solution {
        public String[] solution(String[] strings, int n) {
            //String[] answer = {};

            Arrays.sort(strings, (s1, s2)-> {
                //charAt -> 인덱스 X, "몇번째"
                if(s1.charAt(n) == s2.charAt(n)){
                    return s1.compareTo(s2);
                }else{
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }
            });

            return strings;
        }

            /*
            //comparing character
            char c1 = 'c';
            char c2 = 'c';
            Character.compare(c1, c2);

            //comparing string
            String s1 = "s1";
            String s2 = "s2";
            s1.compareTo(s2);

            return answer;
            */
    }
}
