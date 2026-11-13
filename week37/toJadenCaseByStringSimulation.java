package week37;

public class toJadenCaseByStringSimulation {
    public String solution(String s) {
        /*
         * Jaden : 모든 단어의 첫 문자가 대문자, 그 외 알파벳은 소문자인 문자열
         * 첫 문자가 알파벳이 아닐 경우 이어지는 알파벳은 소문자로
         */
        return toJadenCase(s);
    }

    private String toJadenCase(String s){

        StringBuilder answer = new StringBuilder();

        char[] chars = s.toCharArray();
        boolean isEmpty = true;

        for(int i = 0 ; i < chars.length ; i++){

            char c = chars[i];

            if(c == ' ') {
                isEmpty = true;

                answer.append(c);

                continue;
            }

            if(!Character.isDigit(c)){
                if(c != ' ' && isEmpty == true) {
                    c = Character.toUpperCase(c);
                }else {
                    c = Character.toLowerCase(c);
                }

                isEmpty = false;
            }else {
                isEmpty = false;
            }

            answer.append(c);

        }

        return answer.toString();

    }
}
