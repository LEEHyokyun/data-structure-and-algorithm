package week38;

public class JumpStonesByBinarySearch {
    public int solution(int[] stones, int k) {
        /*
         * n명이 건넌다고 할때, 그 n명이 건넌 후의 시점에 연속 0이 k가 가능한가.
         * 0이면 건넌 것이다. 0 미만 카운팅 = k
         */
        int start = 0;
        int end = 0;

        for(int stone : stones) end = Math.max(end, stone);

        int answer = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            if(isPossible(mid, stones, k)) start = mid + 1;
            else end = mid - 1;
        }

        /* 가능한 최대 값*/
        return end;
    }

    static boolean isPossible(int mid, int[] stones, int k){

        int count = 0;

        for(int stone : stones){
            if(stone - mid < 0) {
                count++;
                if(count == k) return false;
            } else count = 0;
        }

        return true;
    }
}
