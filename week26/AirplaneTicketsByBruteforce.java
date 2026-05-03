package week26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirplaneTicketsByBruteforce {
    static List<String> list = new ArrayList<>();
    static boolean finished;
    static boolean[] selected;

    public String[] solution(String[][] tickets) {

        String start = "ICN";
        list.add(start);

        int len = tickets.length;
        String[] ans = new String[len + 1];
        selected = new boolean[len];

        Arrays.sort(tickets, (a, b) -> {

            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);

            return a[0].compareTo(b[0]);
        });

        dfs(tickets, start);


        for(int i = 0 ; i < list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    static void dfs(String[][] tickets, String from){

        //System.out.println(from + "에서 이어야 한다.");

        if(list.size() == tickets.length + 1){
            finished = true;
            return ;
        }

        for(int i = 0 ; i < tickets.length ; i++){

            if(selected[i]) continue;

            if(tickets[i][0].equals(from)) {

                //System.out.println("선택 : " + tickets[i][0] + " ~ " + tickets[i][1]);

                list.add(tickets[i][1]);
                selected[i] = true;

                dfs(tickets, tickets[i][1]);

                if(finished) {
                    break;
                }
                else{
                    selected[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
