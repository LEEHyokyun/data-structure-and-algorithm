package week26_exercising;

import java.util.*;

public class ClothesByHashMap {
    static Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {


        for(String[] cloth : clothes){
            String type = cloth[1];

            int count = map.getOrDefault(type, 0);

            map.put(type, count + 1);
        }

        int answer = 1;

        for(String key : map.keySet()){
            int count = map.get(key);

            answer *= count + 1;
        }


        return answer - 1;
    }
}
