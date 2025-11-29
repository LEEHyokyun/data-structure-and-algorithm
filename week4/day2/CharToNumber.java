package week4.day2;

public class CharToNumber {
    //참고
    //int n = A - '0';
    public String solution(String s, int n) {
        char[] ch = s.toCharArray();

        for(int i = 0 ; i < ch.length ; i++){
            char c = ch[i];

            if(Character.isUpperCase(c)){
                //대문자
                c = (char)((c - 'A' + n) % 26 + 'A');
            }else if(Character.isLowerCase(c)){
                //소문자
                c = (char)((c - 'a' + n) % 26 + 'a');
            }

            ch[i] = c;
        }

        return new String(ch);
    }
}
