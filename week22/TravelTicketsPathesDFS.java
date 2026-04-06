package week22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelTicketsPathesDFS {
    static List<String> answer = new ArrayList<>();
    static int N;
    static boolean[] visited;
    static boolean finished;

    public String[] solution(String[][] tickets) {

        String start = "ICN";
        N = tickets.length;
        visited = new boolean[N];

        //사전순 ? 애초에 사전순 정렬.
        Arrays.sort(tickets, (a, b) -> {

            //출발지점 같으면 도착지점 정렬
            //String == String -> 객체의 주소를 비교한다.
            //ICN이 같아도 다른 것으로 판단하여 도착지가 정렬이 안될 수 있음
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);

            //출발지점 기본 정렬
            return a[0].compareTo(b[0]);
        });

        answer.add(start);
        dfs(start, tickets, 0);

        //return answer.toString();
        //list -> String[]
        return answer.toArray(new String[0]);
    }

    //조합..모든 요소를 확인해야 함 경로가 다른 경우의 수에 존재할 수있음
    static void dfs(String start, String[][] tickets, int selected){

        if(selected == N){
            finished = true;
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(visited[i]) continue;
            if(!start.equals(tickets[i][0])) continue; //connect

            visited[i] = true;
            answer.add(tickets[i][1]);

            dfs(tickets[i][1], tickets, selected + 1);
            if(finished) return;

            visited[i] = false;
            answer.remove(answer.size() - 1);
        }

    }
}
