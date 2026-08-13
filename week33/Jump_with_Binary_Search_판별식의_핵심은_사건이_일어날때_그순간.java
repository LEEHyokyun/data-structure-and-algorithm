package week33;

/*
 * 이분탐색에서 판별식의 핵심은 이후의 상태가 아닌 사건이 일어날때의 시점.
 */

public class Jump_with_Binary_Search_판별식의_핵심은_사건이_일어날때_그순간 {
    public int solution(int[] stones, int k) {
        //몇명까지 건널 수 있는지, 몇명이 "건넜는가"를 기준으로 탐색
        //마지막 사람까지 건넌 이후에, 그 상태가 가능한가.
        int min = 0;
        //int max = 2000000000;
        int max = 0;
        for(int stone : stones) max = Math.max(max, stone);
        int mid = 0;

        while(min <= max){

            mid = (min + max) / 2;

            //건넌 이후의 "상태"를 살펴본다. 가능하다면, 건너는 사람을 늘린다.
            //마지막 사람이 건너는 순간의 상태를 살펴본다.
            if(isPossible(mid, stones, k)){
                min = mid + 1;
            }else {
                max = mid - 1;
            }

        }

        //가능한 사람의 최대
        return max;
    }

    static boolean isPossible(int mid, int[] stones, int k){
        /*
         * 모두 건넌 이후에 <k만큼의 연속 0의 개수 이하>가 존재해야 할 것(상한선).
         * -> 마지막 사람이 건너는 순간의 상태를 살펴본다.
         * -> stone - mid가 0이라면 그 순간에는 1이상의 수..밟을 수 있는 돌
         * -> stone - mid < 0 일때 그것이 밟을 수 없는 돌, 이게 k개 이상 시 불가.
         */
        //이 의미는 하한선, 그 이전의 사람은 모두 성공하였다는 의미.
        int count = 0;

        for(int stone : stones){
            // if(stone - mid <= 0) count++;
            // else count = 0;
            if(stone - mid < 0) count++;
            else count = 0;

            // //연속된 돌의 개수가 k를 넘어가면 조건 불만족
            // if(count > k) return false;
            //건널 당시 연속된 돌의 개수가 k-1개까지 허용
            if(count == k) return false;
        }

        //조건은 상한선의 관점 .. 건널 수 있으면 됨, 탐색을 하면서 최적으로 맞춰진다.
        // if(count <= k) return true;
        // else return false;
        return true;
    }
}
