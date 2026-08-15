package week33.refactored;

import java.util.ArrayList;
import java.util.List;

public class DartSummarization_with_String_Simulation {
    static List<Integer> result = new ArrayList<>();

    public int solution(String dartResult) {

        String convertResult = convertResult(dartResult);


        for(char ch : convertResult.toCharArray()){

            if(Character.isDigit(ch) || ch == 'A'){

                int value = (ch == 'A') ? 10 : Integer.parseInt(String.valueOf(ch));
                //System.out.println("value : " + value);
                result.add(value);

            }else if(ch == 'D' || ch == 'T'){

                result = option1(result, ch);

            }else if(ch == '*' || ch == '#'){

                result = option2(result, ch);

            }

        }

        int answer = 0;
        for(int res : result) {
            //System.out.println("list 요소 : " + res);
            answer += res;
        }
        return answer;
    }

    static String convertResult(String dartResult){

        return dartResult.replace("10", "A");

    }

    static List<Integer> option1(List<Integer> result, char option){

        int cur = result.size();
        int val = result.get(cur - 1);

        if(option == 'D'){
            result.remove(cur - 1);
            result.add(val * val);
        }else {
            result.remove(cur - 1);
            result.add(val * val * val);
        }

        return result;

    }

    static List<Integer> option2(List<Integer> result, char option){

        int cur = result.size();
        int val1 = result.get(cur - 1);
        int val2 = 0;

        if(cur > 1) val2 = result.get(cur - 2);

        if(option == '*'){

            if(cur > 1){
                result.remove(cur -1);
                result.remove(cur - 2);
                result.add(val2 * 2);
                result.add(val1 * 2);
            }else {
                result.remove(cur -1);
                result.add(val1 * 2);
            }

        }else {
            result.remove(cur - 1);
            result.add(val1 * (-1));
        }

        return result;

    }
}
