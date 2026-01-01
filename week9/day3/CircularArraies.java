package week9.day3;

import java.util.HashSet;
import java.util.Set;

public class CircularArraies {
    static int[] arr;

    public int solution(int[] elements) {

        int N = elements.length;
        Set<Integer> result = new HashSet<>();
        arr = new int[2*N];
        for(int i = 0 ; i < 2*N ; i++){
            arr[i] = elements[i % N];
        }

        for(int length = 1 ; length <= N ; length ++){
            int sum = 0;

            //초기 윈도우
            for(int i = 0 ; i < length ; i++){
                sum += arr[i];
            }

            result.add(sum);

            //슬라이딩(=시작점 조절, )
            for(int start = 1 ; start < N ; start++){

                sum -= arr[start-1];
                sum += arr[start + length -1]; //길이만큼 더해야함(=start + length - 1)
                result.add(sum);
            }
        }

        return result.size();
    }
}
