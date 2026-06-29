package week27;

import java.util.HashMap;
import java.util.Map;

public class Clothes_HashMap {
    static Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {

        for(String[] cloth : clothes){
            String c = cloth[0];
            String type = cloth[1];

            int count = map.getOrDefault(type, 0);
            if(count == 0){
                map.put(type, 1);
            }else {
                map.put(type, count + 1);
            }
        }

        int res = 1;
        for(String type : map.keySet()){
            res = res * (map.get(type) + 1);
        }

        return res - 1;

    }
}
