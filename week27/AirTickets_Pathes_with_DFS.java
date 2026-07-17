package week27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirTickets_Pathes_with_DFS {
    static List<String> list;
    static boolean[] used;
    static String[] ans;
    static boolean completed;

    public String[] solution(String[][] tickets) {

        //문자열비교 : compareTo
        Arrays.sort(tickets, (a,b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            else return a[0].compareTo(b[0]);
        });

        int len = tickets.length;
        list = new ArrayList<>();
        ans = new String[len + 1];
        used = new boolean[len + 1];

        list.add("ICN");
        dfs(tickets, "ICN", list, 0);

        for(int i = 0 ; i < list.size() ; i++)
            ans[i] = list.get(i);

        return ans;
    }

    static void dfs(String[][] tickets, String begin, List<String> list, int selected){

        if(selected == tickets.length) {
            //System.out.println("selected : " + selected + ", 경로 탐색 완료");
            completed = true;
            return;
        }

        for(int i = 0 ; i < tickets.length ; i++){

            if(used[i]) continue;
            if(isPossible(begin, tickets[i])){

                //System.out.println("현재 티켓(to) : " + tickets[i][1]);

                used[i] = true;
                list.add(tickets[i][1]);

                dfs(tickets, tickets[i][1], list, selected + 1);
                if(completed) return;

                used[i] = false;
                //뒤쪽에 생긴 공항을 지워야 함(중복 가능하므로)
                list.remove(list.size() - 1);
            }
        }

    }

    static boolean isPossible(String begin, String[] path){

        String from = path[0];

        if(begin.equals(from)) return true;
        else return false;

    }
}
