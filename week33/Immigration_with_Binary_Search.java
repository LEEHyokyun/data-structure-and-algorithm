package week33;

public class Immigration_with_Binary_Search {
    public long solution(int n, int[] times) {
        //모든 사람이 심사를 받는데 걸리는 시간의 최소값
        long min = 0;
        long max = 0;
        for(int time : times){
            /*
             * 그 전의 max를 누적하여 n을 곱하기에, long의 상한선을 넘어갈 수 있다.
             */
            max = Math.max(time, max);
            //max = Math.max(time * n, max * n);
        }
        max = max * n;

        long mid = 0;
        while(min <= max){

            mid = (min + max) / 2;

            if(isPossible(mid, times, n)){
                //가능하다면 걸리는 시간을 감소한다.
                max = mid - 1;
            }else {
                //불가능하다면 걸리는 시간을 늘린다.
                min = mid + 1;
            }
        }

        //조건을 만족하는 최소한의 값
        return min;
    }

    static boolean isPossible(long mid, int[] times, int n){
        //걸리는 시간에 맞춰 모든 사람(n명)의 심사가 가능하다면 return true.
        long count = 0;

        for(int time : times){
            count += mid / time; //버림으로 카운팅

            if(count >= n) return true;
        }

        return false;
    }
}
