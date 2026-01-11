package week11.day6;

import java.util.*;

public class CourseCombinationFromOrdersDFS {
    static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        //단품 조합 > 코스
        //함께주문한 단품메뉴들을 코스 요리 메뉴로, 조합가능한 같은 길이의 요소 중 가장 많이 주문한 것
        //단품 >= 2 단품 주문 손님 >= 2
        //orders -> 단품메뉴들 .. 조합인데 해당 조합이 그대로 다른 orders에 존재해야 한다.
        //course -> 주문한 손님의 수에 따른 코스요리 구성..orders의 길이 2 문자열 조합이 2번이상 존재한다면 구성가능.
        List<String> list = new ArrayList<>();

        for(int target : course){
            map.clear();

            //dfs단위 : orders
            for(String order : orders){
                if(order.length() < target) continue;

                char[] chars = order.toCharArray();
                char[] arr = new char[target];
                Arrays.sort(chars);
                dfs(chars, 0, 0, target, arr);
            }

            int max = 0;
            for(int count : map.values()){
                if(count >= 2) max = Math.max(max, count);
            }

            for(String comb : map.keySet()){
                if(map.get(comb) == max) list.add(comb);
            }
        }

        //list도 sort(사전순 배열을 먼저해야 함)
        list.sort((a,b) -> {

            //if(a.length() != b.length()) return a.length() - b.length();

            return a.compareTo(b); //사전 연산
        });

        return list.toArray(new String[0]);
    }

    static void dfs(char[] chars, int start, int depth, int target, char[] arr){

        if(depth == target){
            StringBuilder sb = new StringBuilder();
            sb.append(arr);

            String s = sb.toString();

            if(map.containsKey(s)){
                int count = map.get(s);
                map.put(s, count+1);
            }else{
                map.put(s, 1);
            }

            return;
        }

        for(int i = start ; i < chars.length ; i++){

            arr[depth] = chars[i];
            dfs(chars, i + 1, depth + 1, target, arr);
        }
    }
}
