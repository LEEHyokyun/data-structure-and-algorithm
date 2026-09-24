package week35;

public class Stones_By_BinarySearch {
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = 0;
        int mid = 0;

        for(int stone : stones) max = Math.max(max, stone);

        //건너는 상황이 가능한지 살펴볼 것
        while(min <= max){

            mid = (min + max) / 2;

            if(isPossible(mid, stones, k)) min = mid + 1;
            else max = mid - 1;

        }

        //가능한 가장 최대한의 값
        return max;
    }

    static boolean isPossible(int mid, int[] stones, int k){

        //그 숫자 = 결국 마지막에 건너는 사람이 가능한가.
        //건널때 -> 연속된 0의 개수가 k - 1
        //건넌 이후 -> 연속된 0의 개수가 k (k 뺐을때 0이면 가능한거고 그 이하면 안된다는 것)
        int count = 0;

        for(int stone : stones){

            if(stone - mid < 0) count++;
            else count = 0;

            if(count == k) return false;
        }

        return true;
    }
}
