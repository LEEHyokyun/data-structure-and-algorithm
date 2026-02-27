package week16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationButNotDFS {
    static Map<String, List<String>> map = new HashMap<>();

    public int solution(String[][] clothes) {

        //서로 다른 조합의 수(*기본 각 착용 1가지씩 + 다른 항목 끼리의 조합)
        for(String[] cloth : clothes){
            String key = cloth[1];
            String item = cloth[0];

            if(map.get(key) == null){
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }

            map.get(key).add(item);

        }

        int answer = 1;
        int keySize = map.keySet().size();
        int answer2 = 0;

        for(String key : map.keySet()){
            answer *= map.get(key).size() + 1;
        }

        return answer - 1;
    }
}
