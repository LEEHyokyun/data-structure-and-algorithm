package week25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTicketsPathToDestinatioDFS {
    static List<String> list = new ArrayList<>();
    static String[] str;
    static boolean[] selected;
    static boolean finished;

    public String[] solution(String[][] tickets) {

        //사전순 .. ticket을 먼저 사전순 배열
        Arrays.sort(tickets, (a, b) -> {

            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);

            return a[0].compareTo(b[0]);

        });

        //brute force
        int N = tickets.length;
        String start = "ICN";
        selected = new boolean[N];

        list.add(start);
        dfs(tickets, 0, start, N);


        return list.toArray(new String[0]);
    }

    static void dfs(String[][] tickets, int count, String from, int N){

        if(count == N){
            System.out.println("현재 카운트는 : " + count);
            finished = true;
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(selected[i]) continue;

            if(tickets[i][0].equals(from)){
                String to = tickets[i][1];

                list.add(to);
                selected[i] = true;

                System.out.println("내역 확인 : " + list);

                dfs(tickets, count + 1, to, N);
                if(finished) break;

                //경로 잘못되었을때 초기화
                list.remove(list.size() - 1);
                selected[i] = false;


            }
        }


    }
}
