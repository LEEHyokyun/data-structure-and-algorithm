package week27;

public class Jump_with_binary_search_판별_당시의_상황과_연산_직후의_탈출조건 {
    public int solution(int[] stones, int k) {
        //한번에 점프할 수 있는 거리 = 중간에 0인 돌의 개수는 k-1개까지 허용
        //그 몇명을 기준점으로 두고 이분탐색하자.

        int min = 0;
        int max = 0;
        int mid = 0;

        for(int i = 0 ; i < stones.length ; i++){
            max = Math.max(max, stones[i]);
        }

        while(min <= max){
            mid = (min + max) / 2;

            //System.out.println("현재 max : " + max);
            //System.out.println("현재 min : " + min);
            //System.out.println("현재 mid : " + mid);

            //후보군 범위 조정
            if(isPossible(mid, stones, k)){
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }

        //최대 몇명
        return max;
    }

    static boolean isPossible(int mid, int[] stones, int k){

        int count = 0;

        //0인 돌의 개수 = 건너뛸 수 있는 돌의 개수는 k - 1개까지 허용
        //3명까지 건넜다는 의미는 결국 건너뛴 돌의 개수가 k개라는 것.
        //0인 돌의 개수가 아니라 0보다 작은 돌의 개수를 판별.
        /*
         * 연속된 0의 개수가 k개 까지 허용 -> 건너기 불가능한 경우의 수
         * 연속된 0 미만(-1)의 개수가 .. 건넌 이후에 -1 -1 -1 -> 판별하는 모습은 건넌 이후의 모습
         * 판별 당시의 상황인거야 아니면 그 이후의 상황인거야
         * -1-1 까지 OK
         * 건널 당시의 상황, stone - mid = 마지막 사람이 건널때의 상황.
         * 세번째 친구를 보면 1 0 0 -> 건너면서 연산 -> 이 연산의 결과가 "0인 경우에는 지나갈 수 있다.""
         */
        for(int stone : stones){
            //if(count == k) return false; //탈출 조건이 연산 직후가 아니라면 탈출하지 못하고 반복문 빠져나갈 수있음 마지막에
            if(stone - mid < 0) {
                //0일때는 그 당시 사람이 지나갈 수 있음, -1이면 지나갈 수 없는 것.
                //-1이 연속된 돌의 개수의 판별 기준이며 그 기준은 k
                count++;
                if(count == k) return false; //탈출 조건이 연산 직후일때 정확히 판단 후에 반복문 빠져나갈 수 있음, 특히 마지막의 경우를 조심
            }
            else count = 0;

        }

        //if(count <= k) return true;
        //else
        return true;

    }
}
