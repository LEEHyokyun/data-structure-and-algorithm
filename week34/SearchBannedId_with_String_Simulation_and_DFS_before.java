package week34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchBannedId_with_String_Simulation_and_DFS_before {
    static Map<String, List<String>> dict = new HashMap<>();
    static Map<String, Integer> isSearched = new HashMap<>();

    public int solution(String[] user_id, String[] banned_id) {
        /*
         * 불량 사용자 목록은 응모자 아이디 중에 존재하며, 아이디 일부를 *로 표시(최소 하나 이상)
         * 응모자 아이디 == 불량 사용자 아이디 -> 제재 아이디
         * 가능한 제재 아이디 목록의 경우의 수.
         */

        for(String id : user_id) {

            //System.out.println("id : " + id);

            List<String> list = new ArrayList<>();
            dict.put(id, list);
            isSearched.put(id, 0);

            makeSets("", id, 0);
        }

        int answer = 1;
        for(String id : banned_id){

            //System.out.println("************탐색대상 : " + id + "************");
            int count = 0;

            for(String key : dict.keySet()){

                /*
                 * 이미 탐색한 대상이라면 건너뛰기
                 */
                if(isSearched.get(key) > 0) {
                    //System.out.println("이미 탐색된 이므로 중복 탐색 불가, key : " + key);
                    continue;
                }
                List<String> list = dict.get(key);
                //System.out.println("key : " + key);

                for(int i = 0 ; i < list.size() ; i++){

                    //System.out.println("candidates : " + candidates);

                    if(list.get(i).equals(id)) {
                        //System.out.println("dict에서 user_id 관련 list에서 탐색하고 일치하는 아이디 찾음 : " + list.get(i));
                        count++;

                        /*
                         * 더이상 제재 아이디 대상에 들어가지 않는다..중복 제거
                         */
                        isSearched.put(key, 1);

                        break;
                    }
                }
            }

            answer *= (count == 0) ? 1 : count;
        }

        return answer;
    }

    static void makeSets(String res, String id, int idx){

        //System.out.println("현재 res 확인 : " + res);

        if(idx == id.length()) {
            //System.out.println("추가되는 문자열 : " + res);
            //System.out.println("id : " + id);
            //System.out.println("id 길이 : " + id.length());
            //System.out.println("현재 idx : " + idx);
            dict.get(id).add(res);
            return;
        }

        makeSets(res + "*", id, idx + 1);
        makeSets(res + id.charAt(idx), id, idx + 1);

        /*
         * 같은 메모리를 공유하는 StringBuilder는 결과가 누적된다.
         */
        //makeSets(res.append("*"), id, idx + 1);
        //makeSets(res.append(id.charAt(idx)), id, idx + 1);

        return;
    }
}
