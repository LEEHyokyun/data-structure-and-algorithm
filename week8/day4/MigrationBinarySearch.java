package week8.day4;

public class MigrationBinarySearch {
    public long solution(int n, int[] times) {

        int low = 1;
        int high = 0;
        for(int time : times){
            high = Math.max(high, time);
        }
        high = n * high;

        int mid = 0;
        while(low <= high){
            mid = (high + low)/2;
            if(isPossible(mid, times, n)){
                high = high - 1;
            }else{
                low = low + 1;
            }
        }

        return mid;
    }

    static boolean isPossible(int mid, int[] times, int n){

        int people = 0;
        for(int time : times){
            people += mid / time;  //처리가능한 사람
        }

        if(people >= n) return true; //의 수가 n보다 크면 만족
        return false;
    }
}
