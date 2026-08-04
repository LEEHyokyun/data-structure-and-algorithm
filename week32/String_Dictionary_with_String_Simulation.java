package week32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String_Dictionary_with_String_Simulation {
    static Map<String, Integer> dict = new HashMap<>();
    static List<Integer> list = new ArrayList<>();

    public int[] solution(String msg) {

        for(int i = 0 ; i < 26; i++){

            //해당 알파벳을 인덱스(int) 형태로 : char - 'a' or char - 'A'
            //인덱스 숫자를 알파벳 형태로 : 'A' + i or 'a' + i
            dict.put(String.valueOf((char)(i + 'A')) , (i + 1));
            //System.out.println(String.valueOf((char)(i + 'A'))); (문자열 : idx + 'A' / 숫자 : char - 'A')
            //System.out.println("i + 1 : " + (i + 1));
        }

        //int idx = 0;
        for(int i = 0 ; i < msg.length() ;){

            StringBuilder key = new StringBuilder();
            String check = "";
            int start = i;

            //key.append(m);
            //사전에 단어가 있을때까지 찾고, 없으면 그걸 붙인 단어를 dict에 추가한다.
            //찾은 단어는 출력 목록에 추가한다.
            //인덱스 범위 조건을 먼저!
            while(start < msg.length() && dict.containsKey(check = check + msg.charAt(start))){ //판단하고 그 결과를 누적해야한다.
                //if(idx == 0) System.out.println("체크 문자열 확인 : " + check);
                //if(idx == 0) System.out.println("일반 문자열 객체에 append 여부 확인 : " + check + msg.charAt(start));
                key.append(msg.charAt(start));
                start++;
                i++; //있으면 탐색 순서도 건너뛴다.
                //key.append(msg.charAt(start));
            }

            //찾은 단어 출력 목록에 추가
            //if(idx == 0) System.out.println("key : " + key.toString());
            list.add(dict.getOrDefault(key.toString(), -1));

            //없으면 없는 단어는 사전에 추가
            //if(idx == 0) System.out.println("check : " + check);
            dict.put(check, dict.size() + 1);
            // idx++;
        }

        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }

        return answer;
        //return new int[]{0,0};
    }
}
