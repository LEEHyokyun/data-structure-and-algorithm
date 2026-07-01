package week27;

import java.util.Arrays;

public class SpeedCamera_Greedy_endPoint {
    public int solution(int[][] routes) {

        //가장 먼저 나가는 차량을 기준으로, 그 곳에 카메라를 설치하고 이 지점에만 걸치면 된다.
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int target = routes[0][1];
        int answer = 1;

        for(int i = 1 ; i < routes.length ; i++){

            int start = routes[i][0];
            int end = routes[i][1];

            if(start <= target) continue;
            else {
                answer++;
                target = end;
            }

        }

        return answer;
    }
}
