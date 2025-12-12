package week6.day1;

import java.util.Arrays;

public class BinarySearchRock {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        int N = rocks.length;
        rocks = Arrays.copyOf(rocks, N + 1);
        rocks[N] = distance;

        int left = 1;
        int right = distance;
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2; //target = 거리의 최소값
            int prev = 0;
            int removeCount = 0;

            //이분탐색1
            for(int rock : rocks){
                if(rock - prev < mid){
                    //거리유지불가(그 거리가 최소값이기에 조건 불만족)
                    removeCount++;
                }else{
                    //최소거리와 같거나 그 이상일 경우 OK
                    prev = rock; //돌제거하지 않아도 됨
                }
            }

            //이분탐색2
            if(removeCount <= n){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return result;
    }
}
