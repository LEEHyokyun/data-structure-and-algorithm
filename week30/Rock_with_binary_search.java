package week30;

import java.util.Arrays;

/*
 * 판별식 해석이 쟁점
 * mid -> 정확히 그 값이 아니라, 그 값을 적어도? 최소한? 수용이 가능한가
 * */
public class Rock_with_binary_search {
    public int solution(int distance, int[] rocks, int n) {
        //탐색기준 : 지점 사이 거리의 최소값
        int min = 0;
        int max = distance;

        Arrays.sort(rocks);

        int mid = 0;
        while(min <= max){

            mid = (min + max) / 2; //두 바위 사이의 거리가 "적어도" mid가 가능한가, mid 이상.

            //가능하면 거리의 최소값 증가
            if(isPossible(mid, rocks, n, distance)) min = mid + 1;
            else max = mid - 1;

        }

        //제거 가능한 바위 개수의 최대값
        return max;
    }

    //mid = 조건을 만족하는 "최소한의" 거리
    static boolean isPossible(int mid, int[] rocks, int n, int distance){
        int count = 0; //mid -> 각 지점 사이의 거리 중 최소값
        int prev = 0;

        /*
         * 거리의 최소값을 min, 즉 "적어도" 사이 거리의 최소값을 mid로 하였을때 제거한 돌의 개수가 가능한가.
         * - 거리가 만족하거나 그 이상이면 냅두고
         * - 거리가 너무 작을 경우 떼어내서 최소값의 거리를 만들어낸다가 핵심.
         */
        for(int rock : rocks){

            if(rock - prev >= mid) { //최소값보다 더 크면 제거하면 더 커진다.
                //적어도 그 돌 사이의 최소값을 mid 이상으로 유지할 수 있는가
                //적어도 그 이상의 승객에 대한 항공권을 처리할 수 있는가
                //유지
                prev = rock; //유지
            }else {
                //제거
                count++; //거리가 너무 작으면 뗴어낸다.
            }

            //이건 그 전에 판단하면 안됨, 끝까지 판단해야 함
            //if(count <= n) return true; //최종 제거한 바위의 개수가 n개 이하로 수용가능하면 만족
        }

        //마지막까지 판별 : 너무 작으면 뗴어낸다.
        if(distance - prev < mid) {
            count++;
        }

        if(count <= n) return true;
        else return false;
    }
}
