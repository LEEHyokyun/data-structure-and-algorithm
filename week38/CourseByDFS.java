package week38;

import java.util.*;

public class CourseByDFS {
    static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        /*
         * 코스요리 = 단품메뉴 조합 = 손님들이 주문할때 가장 많이 함께 주문한
         * - 최소 2가지 이상의 단품 메뉴, 최소 2명 이상이 주문한
         * - "몇 번 주문하였는가"(가장 많이 주문한 단품 메뉴를 코스요리로) 기준
         * - result = 알파벳 오름차순(각 코스요리도 오름차순)
         */

        /*
         * 각 주문에서 course별 조합 생성
         * 조합을 생성할때마다 HashMap에 누적
         * 2개 이상의 조합 중, 가장 많은 조합을 다중 선택
         */

        for(String order : orders){
            for(int standard : course){
                dfs(getArrange(order), standard , 0, 0, "");
            }
        }

        List<String> list = getCourseList(course, map);
        Collections.sort(list);

        return list.toArray(new String[0]);
    }

    static void dfs(String order, int standard, int count, int idx, String res){

        if(count == standard){

            //System.out.println("현재 count : " + count);
            //System.out.println("현재 단어 : " + res);

            int val = map.getOrDefault(res, 0);
            map.put(res, val + 1);

            return;
        }

        for(int i = idx ; i < order.length() ; i++){
            char ch = order.charAt(i);

            //현재 단계에서 + 1
            dfs(order, standard, count + 1, i + 1, res + ch);
        }

    }

    static String getArrange(String str){

        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }

    static List<String> getCourseList(int[] course, Map<String, Integer> map){

        List<String> list = new ArrayList<>();

        for(int standard : course){

            int max = 0;

            for(String key : map.keySet()){
                if(key.length() == standard)
                    max = Math.max(max, map.get(key));
            }

            if(max < 2) continue;

            for(String key : map.keySet()){
                if(max == map.get(key) && key.length() == standard) list.add(key);
            }
        }

        return list;
    }
}
