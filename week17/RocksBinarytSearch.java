package week17;

import java.util.Arrays;

public class RocksBinarytSearch {
    public int solution(int distance, int[] rocks, int n) {

        //바위를 제거하였을때 가능한 거리의 최소값 중 가장 큰 값.
        //최소값을 이분탐색의 조건으로 두자.
        int left = 1;
        int right = distance;
        int answer = 1;

        Arrays.sort(rocks);

        //단조의 흐름에 따라 만족하는 경계의 특정 지점을 구한다.
        //종료 시 left < right , 더이상 해가 존재하지 않는다.
        //그 사이에서 만족 해를 구하는 것

        while(left <= right){
            int mid = (left + right) / 2;

            if(canInstall(rocks, n, distance, mid)){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }

        return answer;
    }

    static boolean canInstall(int[] rocks, int n, int distance, int mid){
        /*
         * greedy : 앞에서 부터 간격을 만족하지 못한다면 제거해나간다.
         */
        int removed = 0;
        int prev = 0; //start

        //핵심 : 불변식 condition
        //조건을 그대로 따라간다(간격이 크면 제거하고 작으면 그대로 둔다)
        for(int rock : rocks){
            if(rock - prev >= mid){
                prev = rock;
            }else{
                //조건 불만족
                removed++;
            }

        }

        //마지막
        if(distance - prev < mid) removed++;

        //제거한 숫자가 n을 넘어가면 안됨
        return (removed <= n) ? true : false;

    }
}
