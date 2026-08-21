package week34;

public class convertingCharacterWithOperationg_with_String_Util_and_Simulation {
    public String solution(String s, int n) {
        /*
         * 문자열 s를 n만큼 각가 더한다.
         * 각 문자열의 단일 문자들을 인덱스 혹은 숫자 형태로 나타낼 수 있어야 한다.
         */
        char a = 'a';
        char b = 'b';
        char A = 'A';
        char B = 'B';
        //System.out.println((char)(1 + 'a')); //b
        //System.out.println((char)(1 + 'A')); //B
        //System.out.println((int)(a - '0')); //49
        //System.out.println((int)(a - 'a')); //0
        //System.out.println((int)(b - '0')); //50
        //System.out.println((int)(b - 'a')); //1
        //System.out.println((int)(A - '0')); //17
        //System.out.println((int)(A - 'A')); //0

        return getConverted(s, n);
    }

    static String getConverted(String s, int n){

        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){
            //System.out.println("***************");
            char c = s.charAt(i);
            //System.out.println("현재 입력 문자 : " + c);

            if(c != ' ' && c != 'z'){
                int convertedInteger = (Character.isUpperCase(c)) ? (int)(c - '0') + (n - 17) : (int)(c - '0') + (n -49);
                //System.out.println("convertedInteger : " + convertedInteger);
                char convertedChar = (Character.isUpperCase(c)) ? (char)(convertedInteger + 'A') : (char)(convertedInteger + 'a');
                //System.out.println("convertedChar : " + convertedChar);
                answer.append(convertedChar);
            }else if(c != ' ' && c == 'z') {
                char convertedChar = (Character.isUpperCase(c)) ? (char)((n-1) + 'A') : (char)((n-1) + 'a');
                //System.out.println("convertedChar : " + convertedChar);
                answer.append(convertedChar);
            }
            else {
                answer.append(" ");
            }

        }

        return answer.toString();

    }
}
