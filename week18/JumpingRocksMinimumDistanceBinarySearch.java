package week18;

import java.util.Arrays;

public class JumpingRocksMinimumDistanceBinarySearch {
    public int solution(int distance, int[] rocks, int n) {

        int answer = 0;
        int left = 1;
        int right = distance;

        Arrays.sort(rocks);

        while(left <= right){

            int mid = (left + right) / 2;

            if(isPossible(mid, rocks, distance, n)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return answer;

    }

    static boolean isPossible(int mid, int[] rocks, int distance, int n){

        int prev = 0;
        int count = 0;

        //mid = 둘 사이의 거리 최소값

        for(int rock : rocks){
            if(rock - prev >= mid){
                //유지
                prev = rock;
            }else{
                //제거
                count++;
            }
        }

        //마지막
        if(distance - prev < mid) count++;

        //count <= n -> 더 제거해도 OK, 이미 최소값은 만족
        //count > n -> X
        if(count <= n) return true;
        else return false;
    }
}
