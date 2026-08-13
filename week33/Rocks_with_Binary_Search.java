package week33;

import java.util.Arrays;

public class Rocks_with_Binary_Search {
    public int solution(int distance, int[] rocks, int n) {
        //각 바위 사이의 거리 최소값(하한선)을 기준으로 가능한지 탐색한다.

        int min = 1;
        int max = distance;
        int mid = 0;

        //오름차순 정렬
        Arrays.sort(rocks);

        while(min <= max){

            mid = (min + max) / 2;

            if(isPossible(mid, rocks, n, distance)) {
                //바위 거리의 최소값(하한선) 만족 시 그 하한선의 거리를 늘린다
                min = mid + 1;
            }else {
                //불가능하다면 최소거리를 줄인다.
                max = mid - 1;
            }
        }

        return max; //가능한 거리 중 최소값
    }


    static boolean isPossible(int mid, int[] rocks, int n, int distance){

        int count = 0 ; //제거한 바위의 개수
        int prev = 0;

        for(int rock : rocks){
            //최소값 만족 시 하한선 만족, 바위 유지
            //이 최소값의 하한이 가능하다면 다음 탐색에서 거리를 늘리므로 하한선이 점점 맞춰진다.
            if(rock - prev >= mid){
                prev = rock;
            }else {
                //최소값 불만족 시 바위를 제거해서 조건을 만족하는 최적의 방향으로 진행(하한선 만족하도록 거리 늘리기)
                count++;
            }

            if(count > n) return false; //바위 제거는 그 이하로, 이상하면 조건 불만족
        }

        if(distance - prev < mid) count++;

        if(count <= n) return true;
        else return false;
    }
}
