package week27;

public class Airport_minumum_times_with_binary_search_1 {
    public long solution(int n, int[] times) {
        //걸리는 시간에 대한 범위를 이분탐색으로 조정
        long min = Long.MAX_VALUE;
        long max = 0;
        for(int i = 0 ; i < times.length ; i++){
            max = Math.max(max, times[i]);
            min = Math.min(min, times[i]);
        }

        max = max * n;

        long mid = 0;
        while(min <= max){ //min = max -> mid = max = min, 최적의 해

            mid = (min + max) / 2;
            //System.out.println("현재 max : " + max);
            //System.out.println("현재 min : " + min);
            //System.out.println("현재 mid : " + mid);

            if(isPossible(mid, times, n)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }

        }

        return mid;
    }

    static boolean isPossible(long mid, int[] times, int target){

        long ans = 0;

        for(int i = 0 ; i < times.length ; i++){
            ans += mid / times[i];
        }

        if(ans >= target) return true;
        else return false;
    }
}
