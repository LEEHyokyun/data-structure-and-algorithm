package week34;

import java.util.*;

public class SearchBannedId_with_String_Simulation_and_DFS_after {
    static boolean[] visited;
    static Set<String> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        visited = new boolean[user_id.length];

        /*
         * 애초에 dict를 만들어서 탐색과정을 3중 순회로 길게 가져갈 필요가 없다.
         */
        dfs(user_id, banned_id, 0, "");

        return result.size();

    }

    static void dfs(String[] user_id, String[] banned_id, int idx, String selected){


        /*
         * dfs의 목적 : banned_id를 기준으로 user_id를 dfs로 순회하면서 가능한 명단을 탐색한다.
         * - 1차적인 dfs 순회 = 조합, 한번 탐색된 user_id는 다음 banned_id의 탐색 대상에 포함될 수 없다.
         * - 2차적인 result 중복 제거(Set) = 제재 아이디 목록에 선별된 아이디들의 중복은 허용하지 않는다(즉, 최종 결과의 상태는 조합으로 판단하여 중복을 제거한다)
         */

        if(idx == banned_id.length){ //selected = 찾은 사람들, 다만
            char[] chars = selected.toCharArray();
            Arrays.sort(chars);

            result.add(new String(chars));

            return;
        }

        //1개의 banned_id에 대해 user_id 전 내역에 대해 조사
        for(int i = 0 ; i < user_id.length ; i++){

            if(visited[i]) continue;
            if(!isMatched(user_id[i], banned_id[idx])) continue;

            visited[i] = true;

            dfs(
                    user_id,
                    banned_id,
                    idx + 1,
                    selected + i
            );

            visited[i] = false;

        }
    }

    static boolean isMatched(String user, String banned){

        if(user.length() != banned.length()) return false;

        for(int i = 0 ; i < user.length() ; i++){

            if(banned.charAt(i) == '*') continue;
            if(user.charAt(i) != (banned.charAt(i))) return false;

        }

        return true;
    }
}
