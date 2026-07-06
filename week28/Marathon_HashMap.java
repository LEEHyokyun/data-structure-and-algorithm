package week28;

import java.util.HashMap;
import java.util.Map;

public class Marathon_HashMap {
    static Map<String, Integer> pMap = new HashMap<>();
    static Map<String, Integer> cMap = new HashMap<>();

    public String solution(String[] participant, String[] completion) {
        //참여 / 완주
        for(int i = 0 ; i < participant.length ; i++){
            int count = pMap.getOrDefault(participant[i], 0);
            pMap.put(participant[i], count + 1);
        }

        for(int i = 0 ; i < completion.length ; i++){
            int count = pMap.getOrDefault(completion[i], 0);
            //System.out.println("완주자 : " + completion[i]);
            //System.out.println("현재 내역 : " + count);
            if(count == 0) continue;

            if(count == 1) pMap.remove(completion[i]);
            else pMap.put(completion[i], count - 1);
        }

        String answer = "";
        for(String key : pMap.keySet()) answer = key;

        return answer;
    }
}
