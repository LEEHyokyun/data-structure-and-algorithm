package week15;

import java.util.*;

public class ConditionsAndQueryMapAndBinarySearch {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        for(String s : info){
            String[] arr = s.split(" "); //항상 5개(0 ~ 5)
            String[] conditions = Arrays.copyOfRange(arr, 0, 4);
            int score = Integer.parseInt(arr[4]);

            dfs(conditions, 0, "", score);
        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        int[] answer = new int[query.length];
        int idx = 0;

        for(String q : query){
            q = q.replaceAll(" and ", "");
            String[] arr = q.split(" "); //마지막 점수와 떼어놓기

            String key = arr[0];
            int score = Integer.parseInt(arr[1]);

            if(!map.containsKey(key)){
                answer[idx++] = 0;
                continue;
            }

            List<Integer> list = map.get(key);

            int count = list.size() - lowerBound(list, score);
            answer[idx++] = count;
        }

        return answer;
    }

    //지원조건
    static void dfs(String[] conditions, int depth, String key, int score){

        if(depth == 4){
            //조건을 빈틈없이 이어붙인 문자열을 key로 - 그 key에 대한 score
            map.putIfAbsent(key, new ArrayList<>()); //key가 없으면 객체 추가
            map.get(key).add(score); //key에 해당하는 점수 추가
            return;
        }

        dfs(conditions, depth + 1, key + conditions[depth], score);
        dfs(conditions, depth + 1, key + "-", score);
    }

    //score 이상을 만족하는
    static int lowerBound(List<Integer> list, int target){

        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid) >= target){
                right = mid;
            }else
                left = mid + 1;

            //조건을 만족하는 가장 최소의 인덱스, 위치
            //=left

        }

        return left;
    }
}
