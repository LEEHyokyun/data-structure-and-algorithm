package week5.day1;

public class BinarySearchImmigration {
    public long solution(int n, int[] times) {
        //n명이 기다리고
        //심사관과 각 심사관의 심사 소요시간
        //특정 시간 T동안에
        //각 심사관은 T/times[i] 처리 가능
        //전체가능한 심사 수 = 모든 T/time[i]의 합
        //만약 합이 n을 같거나 넘기면 가능
        //T의 단조가 보인다(불가능 > 불가능 > ... > 가능)
        //이 순간을 탐색한다 = 이분탐색.
        //기준 = T

        //condition

        long low = 1;

        long high = 0;
        for(int time : times){
            if(time > high) high = time;
        }
        high = high * n;
        long answer = 0;

        //bs
        while(low <= high){
            long mid = (low+high)/2;
            long count = 0;

            for(int time : times){
                count = count + mid/time;
                if(count >= n) break;
            }

            if(count >= n) {
                answer = mid;
                high = mid - 1; //result 후보, high를 줄인다.
            }
            else{
                low = mid + 1; //low를 높인다.
            }
        }

        return answer;
    }
}
