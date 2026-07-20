package week30;

import java.util.Arrays;

public class SpeedCamera_with_Greedy_with_finalPoint {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1] - b[1]); //도착지점 가장 빠른 순서대로

        int target = 0;
        int answer = 0;
        for(int[] route : routes){

            int from = route[0];
            int to = route[1];

            if(target <= to && from <= target) {
                //System.out.println("");
                //answer++;
            }else {
                //System.out.println("");
                target = to;
                //새로운 카메라를 설치할때만 카운팅
                answer++;
            }
        }

        return answer;
    }
}
