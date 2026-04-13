package week23;

import java.util.Arrays;

public class MigrationBinarySearch {
    public long solution(int n, int[] times) {

        //정렬
        int length = times.length;
        Arrays.sort(times);

        //bs
        long left = 1;
        long right = (long) n * times[length - 1];
        long answer = 0;

        while(left <= right){

            long mid = (left + right) / 2;

            //가능하면 시간을 줄인다.
            if(isPossible(mid, times, n)){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }

        }

        return answer;
    }

    boolean isPossible(long mid, int[] times, int n){

        long people = 0;

        for(int time : times) {
            people += mid / time;

            if(people >= n) return true;
        }

        return false;
    }
}
