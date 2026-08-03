package week32;

import java.util.Arrays;

public class Speedy_Camera_with_Greedy {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int answer = 1;
        int prev = routes[0][1];

        for(int i = 1 ; i < routes.length ; i++){

            //다음 차량이 지나가는 경로가 그 이전에 설치한 지점을 지날 경우 OK.
            int start = routes[i][0];
            int end = routes[i][1];

            if(start <= prev) continue;
            else {
                answer++;
                prev = end;
            }

        }

        return answer;
    }
}
