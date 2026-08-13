package week33;

public class Jump_with_Binary_Search {
    public int solution(int[] stones, int k) {
        //몇명까지 건널 수 있는지, 몇명이 "건넜는가"를 기준으로 탐색
        //마지막 사람까지 건넌 이후에, 그 상태가 가능한가.
        int min = 0;
        int max = 0;
        for(int stone : stones) max = Math.max(max, stone);
        int mid = 0;

        while(min <= max){

            mid = (min + max) / 2;

            //건넌 이후의 "상태"를 살펴본다. 가능하다면, 건너는 사람을 늘린다.
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
        //모두 건넌 이후에 <k만큼의 연속 0의 개수 이하>가 존재해야 할 것(상한선).
        //이 의미는 하한선, 그 이전의 사람은 모두 성공하였다는 의미.
        int count = 0;
        for(int stone : stones){
            if(stone - mid <= 0) count++;
            else count = 0;

            if(count > k) return false;
        }

        if(count <= k) return true;
        else return false;
    }
}
