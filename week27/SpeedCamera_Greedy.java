package week27;

import java.util.Arrays;

public class SpeedCamera_Greedy {
    public int solution(int[][] routes) {
        //-20 -> -15
        //-14 -> -5
        //-18 -> -13
        //-5 -> -3

        //-20 (0번째) / 5
        //-18 (3번째) / 5
        //-14 (1번째) / 9
        //-5 (4번째) / 2

        Arrays.sort(routes, (a, b) -> a[0] - b[0]);

        System.out.println("routes 최초 진입 지점 확인 : " + routes[0][0]);
        int range = routes[0][1] - routes[0][0];
        System.out.println("range 확인 : " + range);
        int start = routes[0][0];
        int answer = 1;

        for(int i = 1 ; i < routes.length ; i++){

            if(isInRange(start, range, routes[i])){
                //System.out.println(" start : "+ start + " 진입지점 : " + routes[i][0] + " 끝지점 : " + routes[i][1] + " start + range : " + (start + range) + "범위 만족, 카메라 그대로 유지");
                continue;
            }else{
                //System.out.println("범위 만족 안됨");
                range = routes[i][1] - routes[i][0];
                start = routes[i][0];

                answer++;
            }

        }

        return answer;
    }

    static boolean isInRange(int start, int range, int[] route){
        if(
                (start <= route[0] && route[0] <= (start + range))
                        ||
                        (start <= route[1] && route[1] <= (start + range))
        ) return true;
        else return false;
    }
}
