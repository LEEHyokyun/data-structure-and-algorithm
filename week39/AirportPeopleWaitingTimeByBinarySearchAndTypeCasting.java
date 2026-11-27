package week39;

public class AirportPeopleWaitingTimeByBinarySearchAndTypeCasting {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = 0;
        for(int time : times){
            right = Math.max(time, right);
        }
        right = right * n;

        while(left <= right){
            long mid = (left + right) / 2;

            //가능하다면 걸리는 소요 시간을 낮춘다.
            if(isPossible(n, mid, times)) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    static boolean isPossible(int n, long mid, int[] times){

        long person = 0;

        for(int i = 0 ; i < times.length ; i++){
            person += mid / times[i];

            if(person >= n) return true;
        }

        return false;

    }
}
