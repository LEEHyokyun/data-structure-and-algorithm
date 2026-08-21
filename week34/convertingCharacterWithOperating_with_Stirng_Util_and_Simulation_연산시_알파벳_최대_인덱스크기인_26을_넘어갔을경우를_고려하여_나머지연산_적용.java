package week34;

public class convertingCharacterWithOperating_with_Stirng_Util_and_Simulation_연산시_알파벳_최대_인덱스크기인_26을_넘어갔을경우를_고려하여_나머지연산_적용 {
    public String solution(String s, int n) {
        /*
         * 문자를 더하는데 단순 연산이 아니라
         * n을 더했을때 26이상이 나올 수 있으므로,
         * 그 이상을 나머지를 구하는 방식으로 접근해야 한다.
         */
        char[] chars = s.toCharArray();

        for(int i = 0 ; i < chars.length ; i++){

            char c = chars[i];

            //System.out.println((char)(0 + 'A')); //A
            //System.out.println((char)(1 + 'A')); //B
            //System.out.println((int)(a - 'a')); //0
            if(Character.isUpperCase(c)){
                c = (char)((((int)(c - 'A') + n) % 26) + 'A');
            }else if(Character.isLowerCase(c)){
                c = (char)((((int)(c - 'a') + n) % 26) + 'a');
            }else if(c == ' '){
                c = ' ';
            }

            chars[i] = c;
        }

        return new String(chars);
    }
}
