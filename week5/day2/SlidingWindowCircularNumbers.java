package week5.day2;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindowCircularNumbers {
    public int solution(int[] elements) {
        //길이가 1
        //길이가 2
        //길이가 3
        //=sliding window

        //선형수열 -> 순회 시 끝
        //원형수열 -> 이어지므로 인덱스의 끝이 없다.


        Set<Integer> result = new HashSet<>();

        int N = elements.length;
        int[] arr = new int[N*2];
        for(int i = 0 ; i < N*2 ; i++){
            arr[i] = elements[i%N];
        }


        for(int len = 1 ; len <= N ; len++){
            int sum = 0;

            for(int i = 0 ; i < len ; i++){
                sum = sum + arr[i];
            }

            result.add(sum);

            for(int i = len ; i < N + len - 1 ; i++){
                sum = sum - arr[i - len] + arr[i];
                result.add(sum);
            }

        }

        return result.size();
    }
}

