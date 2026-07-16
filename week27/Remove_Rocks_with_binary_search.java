package week27;

import java.util.Arrays;

public class Remove_Rocks_with_binary_search {
    /*
     * 판별 기준이니까,
     * 13을 만족한다는게 최소값이 25,26 이렇게 되어도 13이상이라는 범위에 들어가는 것이다.
     * 즉, = OK.
     */

    public int solution(int distance, int[] rocks, int n) {
        //거리의 최소값
        int max = distance;
        int min = 0;
        int mid = 0;

        //오름차순 정렬
        Arrays.sort(rocks);

        while(min <= max){

            mid = (min + max) / 2;

            //System.out.println("현재 max : " + max);
            //System.out.println("현재 min : " + min);
            //System.out.println("현재 mid : " + mid);

            if(isPossible(mid, rocks, n, distance)){
                //가능하다면 더 크게 범위 조정(min)
                min = mid + 1;
            }else {
                //불가능하다면 최소값 범위 조정(max)
                max = mid - 1;
            }

        }

        //결국 가능한 "가장 큰 값" = 최대값
        return max;
    }

    static boolean isPossible(int mid, int[] rocks, int n, int distance){

        //mid는 두 바위 사이 거리의 "최소값"
        //"판별 기준, 정답 후보 군" = 그 최소값을 만족한다면 OK.

        int prev = 0;
        int count = 0;

        for(int rock : rocks){

            if(rock - prev >= mid){
                //충분히 크다.
                prev = rock;
            }else {
                //너무 가깝다. 제거
                count++;
            }

        }

        //끝지점 제거되었을 경우까지 생각해야 함
        if(distance - prev < mid) {
            count++;
        }

        //System.out.println("count : " + count);

        if(count <= n) return true;
        else return false;
    }
}
