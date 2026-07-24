package week30;

/*
* 판별식 해석이 쟁점
* mid -> 정확히 그 값이 아니라, 그 값을 적어도? 최소한? 수용이 가능한가
* */
public class Airport_max_passengers_with_binary_search {
    public long solution(int n, int[] times) {
        long max = 0;
        //long min = Long.MAX_VALUE;
        long min = 1;
        long mid = 0;

        for(int time : times){
            max = Math.max(max, time);
            //n을 곱할 경우, 상한선을 이미 곱한 max와 곱하지 않은 time과 비교하므로 반드시 연산을 다 마치고 난 후에 상한을 도출할 것.
            //min = Math.min(min, time) * n;
        }
        max = max * n;

        while(min <= max){
            mid = (min + max) / 2; //전체 총 걸리는 시간
            //조건 만족 -> 시간 충분 -> 시간을 좀 더 줄인다.
            if(isPossible(mid, times, n)) max = mid - 1;
            else min = mid + 1;

        }

        //가능한 사람의 최소값
        return min;
    }

    /*
    * mid -> 적어도 그 이상의 사람의 탑승을 처리할 수 있는가.
    * mid = 조건을 만족하는 "최소한의" 처리 시간
    * */
    static boolean isPossible(long mid, int[] times, int n){
        long people = 0;

        for(int time : times){
            people += mid / time; //버림

            if(people >= n) return true;
        }

        return false;
    }
}
