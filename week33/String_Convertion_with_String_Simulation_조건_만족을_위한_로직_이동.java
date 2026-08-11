package week33;

public class String_Convertion_with_String_Simulation_조건_만족을_위한_로직_이동 {
    public String solution(String new_id) {
        /*
         * 모든 대문자를 소문자로 치환
         * 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 제외 모든 문자 제거
         * 마침표 2번 이상 연속된 부분을 하나의 마침표로 치환
         * 마침표가 처음이나 끝에 위치하면 제거
         * 빈 문자열이면 a 대입
         * 16자 이상이면 15자 이상의 문자 제외하고 모두 제거, 제거 후 마침표 있으면 제거
         * 길이가 2자 이하라면 마지막 문자를 반복해서 끝에 붙인다.
         */

        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0 ; i < new_id.length() ; i++){

            char c = new_id.charAt(i);

            //허용 문자 여부를 먼저 판단
            if(!Character.isLetter(c)){
                if(c != '-' && c != '_' && c != '.' && !Character.isDigit(c)) {
                    //System.out.println("현재 문자는 문자가 아니면서 -, _, .이 아닙니다.");
                    continue;
                }
            }

            if(c == '.') count++;
            else count = 0;

            if(count > 1) continue;
            else sb.append(c);

        }

        return convertNewId(
                sb.toString()
        );

    }

    static String convertNewId(String id){

        //System.out.println("1차 필터링 : " + id);

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < id.length() ; i++){

            char c = id.charAt(i);
            //System.out.println("현재 문자 : " + c);

            if(i == 0 || i == id.length() - 1){
                if(c == '.') continue;
            }

            //System.out.println("조건 만족 : 문자열 추가");
            sb.append(c);

        }

        //System.out.println("1차 결과 확인 : " + sb.toString());
        //System.out.println("1차 결과 확인 : " + sb.length());

        if(sb.length() == 0) sb.append('a');

        String answer = sb.toString();

        if(sb.length() >= 16) answer = sb.toString().substring(0, 15); //길이 15개 문자열 = 0 ~ 15(14)
        //System.out.println("2차 문자열 길이 자르기 결과 확인 : " + answer);

        //끝 온점 제거
        answer = removeDot(answer);
        //System.out.println("끝 온점 제거 확인 : " + answer);

        //길이가 3 미만일때 끝 문자 붙이기
        //이 제거 과정에서 문자열 길이가 0일 수 있음, 이때는 a를 붙인다.
        if(answer.length() == 0) answer = "a";

        int len = answer.length();
        String addedChar = answer.substring(len - 1, len);
        //System.out.println("길이가 3 미만일때 끝 문자 : " + addedChar);

        while(answer.length() < 3){
            //길이가 3미만에서 3으로 붙이는 과정이기에 StringBuilder / String 차이 없음
            answer += addedChar;
        }

        return answer;
    }

    static String removeDot(String id){

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < id.length() ; i++){

            char c = id.charAt(i);

            //if(!Character.isLetter(c) || c != '-' || c != '_' || c != '.')  continue;

            if(i == 0 || i == id.length() - 1){
                if(c == '.') continue;
            }

            sb.append(c);

        }

        return sb.toString();
    }
}
