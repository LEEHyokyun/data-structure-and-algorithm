package week34;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRelationKeyCandidates_with_DFS_최소성_조건_만족을_위해_별도의_정렬과_최소성_판별식_적용하기 {
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

        /*
         * 모든 키들을 일단 넣고, 그 키들에 대해 정렬한 후 최소성을 맨 마지막에 검사한다.
         */
        List<String> candidates = new ArrayList<>();
        list.sort((a,b) -> a.length() - b.length());

        for(String key : list){

            boolean isMin = true;

            for(String candidate : candidates){
                //full - subset
                //하나라도 부분문자열이면 키후보에 넣을 수 없다..다른 key로 다시 탐색 시작.
                if(isSubset(key, candidate)){
                    isMin = false;
                    break;
                }
            }

            if(isMin) candidates.add(key);
        }

        return candidates.size();
    }

    /*
     * key의 조합을 dfs로 탐색
     */
    static void dfs(String[][] relation, int idx, String key){

        for(int i = idx ; i < relation[0].length ; i++){

            String keyCombined = key + i;

            /*
             * 현재 로직에서는 AB 복합키 조건 만족 시 다음
             */
            if(isUnique(relation, keyCombined)){
                //System.out.println("현재 key["+ keyCombined +"]는 조건 만족");
                /*
                 * 유일성 만족 + 최소성 만족
                 * 지금 로직대로라면 ABC가 가능하고 AC 역시 가능해진다.
                 * 하지만 최소성으로 인해 AC만 가능하고 ABC는 불가능해야 한다.
                 * 최소성을 반드시 같이 확인해야 한다.
                 */
                //if(isMin(keyCombined)) {
                list.add(keyCombined);
                continue;
                //}
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
                value = value + relation[row][col] + "&"; //ab + c, a + bc는 서로 다르게 봐야한다.
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

//     static boolean isMin(String keyCombined){

//         //기존의 list key 후보군들 중 현재 combined key가 후보군의 부분집합 문자열인지 확인한다.
//         //combined한 key는 list에 비해 반드시 그 길이가 길다.
//         //boolean isGood = true;

//         for(String candidates : list){

//             boolean isSubset = true;

//             for(char c : candidates.toCharArray()){
//                 /*
//                 * 최소성 만족 : 문자열의 포함 여부가 연속적으로 부합해야 한다.
//                 * 즉, (리스트)AB / (combinedKey)AC -> 이 둘은 포함관계가 아니다.
//                 * (리스트)AC / (combinedKey) ABC -> 이 둘은 포함관계이다(ABC는 최소성을 불만족한다).
//                 * 그리고 이걸 모든 후보군에 대해 진행해야 한다(continue)
//                 */
//                 //if(keyCombined.contains(candidates)) return false;
//                 if(keyCombined.indexOf(c) == -1) {
//                     //만족, 다음 candidates 순회로
//                     isSubset = false;
//                     break;
//                 }else {
//                     isSubset = true;
//                 }
//             }

//             if(isSubset) return false;
//         }

//         //모든 후보군이 부분집합이 아니어야 최소성 만족
//         return true;
//     }

    static boolean isSubset(String fullSet, String subset) {

        for (char c : subset.toCharArray()) {

            //subset의 단일 문자 중 하나라도 포함되어있지 않으면 부분문자열이 아님
            if (fullSet.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }
}
