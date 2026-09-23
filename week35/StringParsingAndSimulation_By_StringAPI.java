package week35;

import java.util.ArrayList;
import java.util.List;

public class StringParsingAndSimulation_By_StringAPI {
    static List<Integer> list = new ArrayList<>();

    public int solution(String dartResult) {

        String converted = convertString(dartResult);

        for(char ch : converted.toCharArray()){

            if(Character.isLetter(ch))
                if(ch == 'A') digitOperate(10);
                else charOperate(ch);
            else {
                if(Character.isDigit(ch))
                    digitOperate(Integer.parseInt(String.valueOf(ch)));
                else
                    optionOperate(ch, list.size());
            }
        }

        int answer = 0;
        for(int l : list) answer += l;

        return answer;
    }

    static String convertString(String str){
        return str.replace("10", "A");
    }

    static void digitOperate(int val){
        list.add(val);
    }

    static void charOperate(char ch){

        int idx = list.size() - 1;
        int val = list.get(idx);

        if(ch == 'S'){
            return;
        }
        else if(ch == 'D'){
            list.remove(idx);
            list.add(val * val);
        }
        else if(ch == 'T'){
            list.remove(idx);
            list.add(val * val * val);
        }
    }

    static void optionOperate(char ch, int curSize){

        int idx1 = 0;
        int idx2 = 0;

        int val1 = 0;
        int val2 = 0;

        if(curSize == 1){
            idx1 = curSize - 1;
            val1 = list.get(idx1);
        }else {
            idx1 = curSize - 1;
            idx2 = curSize - 2;

            val1 = list.get(idx1);
            val2 = list.get(idx2);
        }

        if(ch == '*'){
            if(curSize == 1){
                list.remove(idx1);
                list.add(val1 * 2);
            }else {
                list.remove(idx1);
                list.remove(idx2);
                list.add(val2 * 2);
                list.add(val1 * 2);
            }
        }
        else if(ch == '#'){
            list.remove(idx1);
            list.add(val1 * (-1));
        }

    }
}
