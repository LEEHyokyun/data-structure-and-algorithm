package week34;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRelationKeyCandidates_with_DFS {
    static List<String> list = new ArrayList<>();

    public int solution(String[][] relation) {
        /*
         * 후보키
         * - 모든 튜플에 대해 유일하게 보장가능한 속성
         * - 속성의 조합이 둘 이상일때 최소한의 속성 개수로 유일성 보장(하나라도 빠지면 안됨)
         */
        /*
         * dfs로 해당 속성에 대해 유일한지 조회
         * - 유일하다면 list에 추가
         * - 유일하지 않다면 복합키로 유일성 탐색
         * - 이 과정을 모든 속성에 대해 검사
         */
        dfs(relation, 0, "");

        return list.size();
    }

    /*
     * key의 조합을 dfs로 탐색
     */
    static void dfs(String[][] relation, int idx, String key){

        for(int i = idx ; i < relation[0].length ; i++){

            String keyCombined = key + i;

            if(isUnique(relation, keyCombined)){
                //System.out.println("현재 key["+ keyCombined +"]는 조건 만족");
                list.add(key);
                continue;
            }else {
                //System.out.println("현재 key["+ keyCombined +"]는 조건 불만족, 조합키로 생성");
                dfs(relation, i + 1, keyCombined);
            }
        }

        //return;
    }

    static boolean isUnique(String[][] relation, String keyCombined){

        Set<String> valueList = new HashSet<>();

        for(int row = 0 ; row < relation.length ; row++){

            String value = "";

            //col -> key list 반영
            for(char key : keyCombined.toCharArray()){
                //System.out.println("탐색 대상 key : " + key);
                int col = Integer.parseInt(String.valueOf(key));
                value = value + relation[row][col];
                //System.out.println("value : " + value);
            }

            //row 순회
            if(valueList.contains(value)) {
                return false;
            } else valueList.add(value);
        }

        //System.out.println("현재 key는 조건을 만족합니다.");
        return true;

    }
}
