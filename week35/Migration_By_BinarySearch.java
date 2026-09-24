package week35;

public class Migration_By_BinarySearch {
    public long solution(int n, int[] times) {
        long min = 0;
        long max = 0;

        for(int time : times) max = Math.max(max, time);
        max = max * n;

        long mid = 0;

        while(min <= max){

            mid = (min + max) / 2;

            if(isPossible(mid, times, n)) max = mid - 1;
            else min = mid + 1;
        }

        //조건을 만족하는 가장 최소한의 값
        return min;

    }

    static boolean isPossible(long mid, int[] times, int n){

        long res = 0;

        for(int time : times) {
            long person = mid / time; //버림
            res += person;

            if(res >= n) return true;
        }

        return false;
    }
}
