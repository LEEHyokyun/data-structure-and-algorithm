package week31;

import java.util.Arrays;

public class Distance_Rocks_with_binary_search {
    public int solution(int distance, int[] rocks, int n) {

        //각 지점 사이의 거리를 기준으로 잡고, 그것이 가능한지 이분탐색으로 탐색.
        //만약 그 거리를 기준으로 조건이 가능하다면, 거리의 최소값을 늘린다.
        int min = 0;
        int max = distance;

        int mid = 0;

        Arrays.sort(rocks);

        while(min <= max){

            mid = (min + max) / 2;

            if(isPossible(rocks, mid, n, distance)) min = mid + 1;
            else max = mid - 1;

        }

        //최소값 중 가장 큰 값 = 최대값
        return max;

    }

    //O(N) = 배열이 아닌 10억에 대한 이분탐색(log10억) = 30번 * 최악의 경우 5만번 순회 = 150만회(수용가능)
    //여기에 정렬 NlogN = 5만 * log 5만 = 약 80만회 = 수용 가능
    //100만회 + 80만회의 선형적 진행 .. 시간 복잡도 관점에서 수용 가능
    //거리의 최소값 = 최소한 그 거리는 되어야 한다는 의미.
    static boolean isPossible(int[] rocks, int mid, int n, int distance){

        int count = 0;
        int prev = 0;

        for(int rock : rocks){

            if(rock - prev >= mid) prev = rock;
            else count++;

            if(count > n) return false;
        }

        if(distance - prev < mid) count++;

        if(count <= n) return true;
        else return false;


    }
}
