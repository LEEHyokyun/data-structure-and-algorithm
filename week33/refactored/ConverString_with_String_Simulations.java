package week33.refactored;

public class ConverString_with_String_Simulations {
    public String solution(String new_id) {
        return convertString(
                new_id.toLowerCase()
        );
    }

    static String convertString(String id){
        StringBuilder res = new StringBuilder();

        for(char c : id.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c) || c == '-' || c == '_' || c == '.'){
                res.append(c);
            }
        }

        //System.out.println("res 확인 : " + res.toString());


        res = removeSideDots(removeDots(res));

        //System.out.println("연속 점 및 끝 점 제거 후 res 확인 : " + res.toString());
        /*
         * String
         */

        String answer = "";

        if(res.length() == 0) answer = res.append('a').toString();
        else if(res.length() >= 16) answer = res.toString().substring(0, 15); //0~14(->15)
        else answer = res.toString();


        //System.out.println("answer 확인 : " + answer);

        answer = removeSideDots(answer);

        if(answer.length() == 0) answer = "a";
        if(answer.length() <= 2) answer = addSideChar(answer);

        return answer;
    }

    static StringBuilder removeDots(StringBuilder str){

        String before = str.toString();
        int count = 0;

        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < before.length() ; i++){
            char c = before.charAt(i);

            if(c == '.') {
                count++;

                if(count > 1) continue;
            } else count = 0;

            result.append(c);
        }

        return result;

    }

    static StringBuilder removeSideDots(StringBuilder str){

        String before = str.toString();
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < before.length() ; i++){
            char c = before.charAt(i);

            if(i == 0 || i == before.length() - 1){
                if(c == '.') continue;
            }

            result.append(c);
        }

        return result;
    }

    static String removeSideDots(String str){

        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);

            if(i == 0 || i == str.length() - 1){
                if(c == '.') continue;
            }

            result.append(c);
        }

        return result.toString();
    }

    static String addSideChar(String str){

        char sideChar = str.charAt(str.length() - 1);
        int curLeng = str.length();

        while(curLeng < 3) {
            str = str + sideChar;
            curLeng++;
        }

        return str;


    }
}
