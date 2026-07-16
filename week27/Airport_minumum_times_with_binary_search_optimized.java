package week27;

public class Airport_minumum_times_with_binary_search_optimized {
    /*
     * 이분탐색의 유의사항
     * - while(min <= max) -> min = max 인 마지막 경우도 고려해야 한다.
     * - 조건에 따라 현재의 조건을 포함하지 않는 범위 갱신이 필요하다(mid + 1, mid - 1)
     * - mid는 이번 반복에서 검사한 값으로 탐색 조건일 뿐이고, 최초로 가능한 실제 지점은 min.
     */

    public long solution(int n, int[] times) {
        //걸리는 시간에 대한 범위를 이분탐색으로 조정
        //long min = Long.MAX_VALUE;
        long min = 1;
        long max = 0;
        for(int i = 0 ; i < times.length ; i++){
            max = Math.max(max, times[i]);
            //min = Math.min(min, times[i]);
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

        return min;
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
