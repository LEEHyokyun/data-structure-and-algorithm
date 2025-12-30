package week8.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirportDFS {
    //answer 배열형태 = arrayList
    static List<String> answer = new ArrayList<>();
    static boolean[] visited;
    static boolean finished;
    static int N;

    public String[] solution(String[][] tickets) {

        String start = "ICN";
        N = tickets.length;
        visited = new boolean[N]; //i인덱스 티켓은 사용하였다.

        //사전순 보장을 위해 알파벳 오름차순 정렬
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        answer.add(start);
        dfs(start, tickets, 0);

        //return answer.toString();
        return answer.toArray(new String[0]);
    }

    static void dfs(String start, String[][] tickets, int usedCnt){

        if(usedCnt == N){
            //경로 완료
            finished = true;
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(visited[i]) continue;
            if(!start.equals(tickets[i][0])) continue;

            visited[i] = true;
            String next = tickets[i][1];
            answer.add(next);
            usedCnt++;

            dfs(next, tickets, usedCnt);
            if(finished) return;

            //반례 -> 경로 제거 후 다음 순회
            answer.remove(answer.size()-1);
            visited[i] = false;
            usedCnt--;
        }
    }
}
