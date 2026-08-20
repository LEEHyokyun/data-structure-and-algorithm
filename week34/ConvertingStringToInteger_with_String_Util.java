package week34;

public class ConvertingStringToInteger_with_String_Util {
    public int solution(String s) {
        /*
         * 일부 자릿수를 영단어로 바꾼다.
         * 영단어 문자열을 최종 int형태의 결과로 바꾼다.
         */
        return Integer.parseInt(converted(s));
    }

    static String converted(String s){
        return s.replace("zero", "0")
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
                ;
    }
}
