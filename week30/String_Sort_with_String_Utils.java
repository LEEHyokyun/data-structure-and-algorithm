package week30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_Sort_with_String_Utils {
    public String[] solution(String[] files) {
        //파일명 = head(문자열) + number(숫자) + tail(확장자)
        //head 사전순 정렬 / number 숫자 순 정렬 / 입력 순서 유지
        List<String> answer = new ArrayList<>();

        Arrays.sort(files, (a, b) -> {

            //split -> 특수문자 표현 시 정규표현식 필수
            String[] str1 = a.split("\\.");
            String[] str2 = b.split("\\.");
            //String[] str1 = new String[]{"1", "2"};
            //String[] str2 = new String[]{"1", "2"};

            StringBuilder sb11 = new StringBuilder(); //영문
            StringBuilder sb12 = new StringBuilder(); //숫자
            StringBuilder sb21 = new StringBuilder(); //영문
            StringBuilder sb22 = new StringBuilder(); //숫자

            for(char c : str1[0].toCharArray()){
                if(!Character.isDigit(c)) {
                    if(Character.isLetter(c)) sb11.append(c);
                }else {
                    //if(((int) c - '0') != 0)
                    sb12.append(c);
                }
            }

            for(char c : str2[0].toCharArray()){
                if(!Character.isDigit(c)) {
                    if(Character.isLetter(c)) sb21.append(c);
                } else {
                    sb22.append(c);
                }
            }

            if(!sb11.toString().toLowerCase().equals(sb21.toString().toLowerCase())) {
                return sb11.toString().compareTo(sb21.toString());
            }else {
                return Integer.parseInt(sb12.toString()) - Integer.parseInt(sb22.toString());
            }

            //return a.length() - b.length();
        });

        return files;
    }
}
