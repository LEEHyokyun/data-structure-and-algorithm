package week30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String_Dictionary_with_String_Simulation {
    public int[] solution(String msg) {
        //msg 길이는 1이상, 1000 이하, 2회 순회 허용
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < 26 ; i++){
            //System.out.println("문자 : " + (char)(i + 'A'));
            //System.out.println("인덱스 : " + (i + 'A'));
            dictionary.put(String.valueOf((char)(i + 'A')), (i + 1));
        }

        int i = 0 ;
        int len = msg.length();

        while(true){
            //if(i == len) break; //i + 현재 찾은 문자열(str)

            String str = String.valueOf(msg.charAt(i));
            //System.out.println("현재 문자 : " + str);
            int j = i + 1;

            //while(j <= len && dictionary.containsKey(msg.substring(i, j))){
            while(j <= len && dictionary.containsKey(msg.substring(i, j))){
                str = msg.substring(i, j);
                j++;
            }

            //System.out.println("다음 추가할 문자 : " + msg.substring(i, j)); //j는 이후 시점
            //System.out.println("사전 인덱스 : " + dictionary.get(str)); //str은 자르기 전임
            list.add(dictionary.get(str));

            if(j <= len) dictionary.put(msg.substring(i, j), dictionary.size() + 1);

            i = i + str.length();
            if(i == len) break; //i + 현재 찾은 문자열 이후(str)
        }

//         int[] answer = new int[list.size()];

//         int idx = 0;
//         for(int num : list.toArray(new Integer[0])){
//             answer[idx] = num;
//             idx++;
//         }
        int[] answer = new int[list.size()];
        //System.out.println("list.size() : " + list.size());
        for(int j = 0 ; j < list.size() ; j++){
            //System.out.println("dictionary.get(list.get(j)) : " + dictionary.get(list.get(j)));
            answer[j] = list.get(j);
        }

        return answer;
    }
}
