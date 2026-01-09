package week11.day4;

public class JumpBinarySearch {
    public int solution(int[] stones, int k) {

        //-1
        //0->건너뛰어야함
        //k= 3 -> 0 2개까지, 3개이상이면 못건넌다.
        //최대 몇명


        //0 1개 -> jump = 2
        //0 2개 -> jump = 3
        //0 3개 -> jump = 4
        //0 k개 -> jump = k+1 X
        //연속된 0의 개수가 k개까지 허용, 이것이 되는 "몇명"

        int max = 200000000;
        int min = 1;
        int length = stones.length;
        int count = 0;
        int answer = 0;

        while(min <= max){
            int mid = (max + min) / 2;

            if(canMove(stones, mid, k)){
                min = mid + 1;
                //answer = mid;
            }else{
                max = mid - 1;
            }

        }

        return max;
    }

    static boolean canMove(int[] stones, int mid, int k){

        int count = 0;

        for(int s : stones){
            if(s - mid < 0) {
                count++;
                if(count >= k) return false;
            }else{
                count = 0;
            }
        }

        return true;
    }
}
