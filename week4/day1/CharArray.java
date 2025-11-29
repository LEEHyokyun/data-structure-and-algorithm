package week4.day1;

public class CharArray {
    public boolean solution(String s) {
        boolean answer = true;

        //길이
        if(s.length() != 4 && s.length() != 6) {
            answer = false;
            return answer;
        }

        //숫자로만 구성 -> isDigit
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(!Character.isDigit(c)){
                answer = false;
                return answer;
            }
        }


        return answer;
    }
}
