package week14.stringParsingBySubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StirngParsingSubString {
    public int[] solution(String msg) {

        //사전
        Map<String, Integer> dict = new HashMap<>();
        //문자열 배열을 생성하기 위한 유틸
        ArrayList<Integer> answer = new ArrayList<>();

        //최초
        for(int i = 0 ; i < 26 ; i++){
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        //가장 긴 문자열을 찾고 출력 및 w+c를 사전에 추가
        int i = 0;
        int length = msg.length();
        while(i < length){
            String w = String.valueOf(msg.charAt(i));
            int j = i + 1;

            //가장 긴 문자열
            while(j <= length && dict.containsKey(msg.substring(i, j))){
                w = msg.substring(i,j);
                j++;
            }

            //출력
            answer.add(dict.get(w));

            //마지막 문자는 사전 추가를 하지 않는다.
            if(j <= length) {
                dict.put(msg.substring(i, j), dict.size() + 1);
            }
            // String c = msg.substring(i,j);
            // dict.put(c, dict.size() + 1);

            //i = 0 이고 w = 2이면 i + w.length
            i = i + w.length();
        }


        int[] list = new int[answer.size()];
        for(int idx = 0 ; idx < answer.size() ; idx++){
            list[idx] = answer.get(idx);
        }

        return list;
        //return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
