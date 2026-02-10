package week14.stringParsingBySubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringParsing {
    public int[] solution(String msg) {

        //사전
        Map<String, Integer> dict = new HashMap<>();
        //문자열 배열을 생성하기 위한 유틸
        ArrayList<Integer> answer = new ArrayList<>();

        //최초
        for(int i = 0 ; i < 26 ; i++){
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        System.out.println(dict);

        // for (char c = 'A'; c <= 'Z'; c++) {
        //     dict.put(Character.toString(c), dict.size() + 1);
        // }

        StringBuilder sb = new StringBuilder();

        int length = msg.length();
        for(int i = 0 ; i < length ; i++){
            //초기화
            sb.setLength(0);
            sb.append(msg.charAt(i));

            while(i + 1 < length && dict.putIfAbsent(sb.toString() + msg.charAt(i + 1), dict.size() + 1) != null){
                i++;
                sb.append(msg.charAt(i));
            }

            answer.add(dict.get(sb.toString()));
        }

        int[] list = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++){
            list[i] = answer.get(i);
        }

        return list;
        //return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
