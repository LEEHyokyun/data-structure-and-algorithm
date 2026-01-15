package week12.day5;

import java.util.*;

public class CombinationAndStringDFS {
    static List<String> list = new ArrayList<>();
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        //단품 메뉴를 조합해서 코스요리로 재구성
        //가장 많이 함께 주문한 단품메뉴들.
        //2명이상의 손님이 주문한 단품메뉴 조합에 대해서만 코스에 포함
        //단품메뉴 >= 2
        for(int length : course){

            map = new HashMap<>();

            for(String order : orders){

                if(order.length() < length) continue;

                char[] ch = order.toCharArray();
                Arrays.sort(ch);
                order = new String(ch);

                dfs(order, "", 0, length, map); //조합 -> map 조합은 확실한데.

            }

            //map -> list(2개 이상이면서 빈도 최대값)
            int freq = 0;
            for(String key : map.keySet()){
                if(map.get(key) >= 2) {
                    freq = Math.max(freq, map.get(key));
                }
            }

            for(String key : map.keySet()){
                if(freq == map.get(key)) list.add(key);
            }
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    static void dfs(String order, String str, int start, int length, Map<String, Integer> map){

        if(str.length() == length){

            if(map.getOrDefault(str, 0) != 0){
                int num = map.get(str);
                map.put(str, num + 1);
            }else{
                map.put(str, 1);
            }

            return;
        }

        //StringBuilder sb = new StringBuilder();
        for(int i = start ; i < order.length() ; i++){

            //int length = sb.length();
            //sb.append(order[i]);

            char c = order.charAt(i);
            dfs(order, str + c, i+1, length, map); //다음단계 : 현재단계의 + 1
            //sb.setLength(length);
        }
    }
}
