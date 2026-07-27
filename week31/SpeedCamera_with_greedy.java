package week31;

import java.util.Arrays;

public class SpeedCamera_with_greedy {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int answer = 0;
        int prev = 0;

        for(int[] route : routes){

            int start = route[0];
            int end = route[1];

            if(prev <= end && prev >= start) continue;
            else {
                prev = end;
                answer++;
            }

        }

        return answer;
    }
}
