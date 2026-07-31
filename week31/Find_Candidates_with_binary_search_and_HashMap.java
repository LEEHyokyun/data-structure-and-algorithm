package week31;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Candidates_with_binary_search_and_HashMap {

    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        for(String in : info){
            String[] i = in.split(" ");
            makeMap(i, 0, "");
        }

        //이분탐색을 위해 해당 list 정렬
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        int[] answer = new int[query.length];

        for(int i = 0 ; i < query.length ; i++){

            answer[i] = bs(query[i]);
        }

        return answer;
    }

    static void makeMap(String[] i, int index, String str){

        if(index == 4) return;

        makeMap(i, index + 1, str + i[index]);
        makeMap(i, index + 1, str + "-");
    }

    static int bs(String query){
        String q = query.replaceAll(" and ", "");
        String[] infos = q.split(" ");
        String key = infos[0];
        int score = Integer.parseInt(infos[1]);

        if(!map.containsKey(key)) return 0;

        int min = 0;
        int max = map.get(key).size() - 1;
        int mid = 0 ;

        //조건을 만족하는 map.get(key)에서 도출한 리스트의 "인덱스"를 기준으로 탐색
        while(min <= max){

            mid = (min + max) / 2;

            //get(mid) = score, 조건 만족 시 사람 수 증가(점수 폭 증가 = 인덱스 감소)
            if(map.get(key).get(mid) >= score) max = mid - 1;
            else min = mid + 1;

        }

        //도출한 가능한, 조건이 가능한 최소한의 인덱스
        //size = 5 max = 4 -> 가능한 사람의 수는 1명
        return map.get(key).size() - min;
    }
}
