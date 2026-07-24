package week30;

import java.util.*;

public class Candidates_and_Score_with_binary_search_list_탐색시_최대_인덱스는_size_기준_반드시_1감소 {
    /*
     * 이분탐색은 기본적으로 단조가 적용되어야 함
     * 언어/직무/경력 조건을 기준으로 그룹을 만들어 각 그룹의 점수 단조성을 먼저 구성해두는 것이 쟁점.
     */
//     static class Person{

//         String lang;
//         String job;
//         String level;
//         String food;
//         int score

//         public Person(String lang, String job, String level, String food, int score){
//             this.lang = lang;
//             this.job = job;
//             this.level = level;
//             this.food = food;
//             this.score = score;

//         }

//     }

    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        //query에 대한 조건은 1회 순회까지만 허용

        //List<Person> list = new ArrayList<>();
        for(String in : info){

            String[] infos = in.split(" ");
            //list.add(new Person(in[0], in[1], in[2], int[3], Integer.parseInt(in[3])));
            // String lang = in[0];
            // String job = in[1];
            // String level = in[2];
            // String food = in[3];
            // int score = Integer.parseInt(in[4]);

            //String key = lang + job + level + food;
            //각 조건을 이어 붙인 형태에 포함조건(-)까지 고려해서 map을 구성해야 한다.
            makeMap(infos, 0, "");
            /*
             * 2^4회 * 16 * 5만번 = 약 80만회 = 재귀호출 수용 가능한 수준
             */

            //List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            //list.add(score);
        }

        for(String key : map.keySet()){
            List<Integer> list = map.get(key);

            //list.sort();
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        int idx = 0;
        for(String q : query){
            //int minIdx = bs(q, map);
            //answer[idx++] = list.size() - minIdx;
            answer[idx++] = bs(q, map);
        }

        return answer;
    }

    static void makeMap(String[] infos, int count, String key){

        if(count == 4){

            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            map.put(key, list); //반드시 key / value 세트로 등록해야 함
            list.add(Integer.parseInt(infos[4]));

            //System.out.println("현재 key 등록합니다 : " + key);
            //System.out.println("점수 등록합니다 : " + infos[4]);
            return;

        }

        makeMap(infos, count + 1, key + infos[count]);
        makeMap(infos, count + 1, key + "-");
    }

    static int bs(String query, Map<String, List<Integer>> map){

        query = query.replaceAll(" and ", "");
        String[] infos = query.split(" ");
        String key = infos[0];
        int score = Integer.parseInt(infos[1]); //만족해야 하는 조건

        //해당 키를 만족하는 사람이 없을 수 있음
        //System.out.println("key : " + key);
        if(!map.containsKey(key)) return 0;
        //System.out.println("해당 key 사람들 존재함");

        //조건을 만족하는 "최소한의" 인덱스
        int min = 0;
        int max = map.get(key).size() - 1; //인덱스이므로 - 1 !!!!!
        int mid = 0;

        int count = 0;

        while(min <= max){

            mid = (min + max) / 2; //최소한의 조건을 만족하는 최소한의 인덱스

            //조건을 만족하는 최소한의 점수, 조건 만족 시 점수 폭을 낮춘다.
            if(map.get(key).get(mid) >= score) max = mid - 1;
            else min = mid + 1;

        }

        //return min(이분탐색으로 획득한 "최소한"의 인덱스)
        return map.get(key).size() - min;
    }
}
