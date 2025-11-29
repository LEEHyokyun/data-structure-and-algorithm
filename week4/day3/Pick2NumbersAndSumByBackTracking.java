package week4.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//백트래킹으로 풀 수 있긴 한데 복잡하다.
public class Pick2NumbersAndSumByBackTracking {
    static List<Integer> result = new ArrayList<>();

    public int[] solution(int[] numbers) {
        //int[] answer = {};

        //정렬
        Arrays.sort(numbers);

        dfs(numbers, 0, 0, 0);

        result.sort(Comparator.naturalOrder());

        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    static void dfs(int[] numbers, int start, int num, int sum){
        if(num == 2){
            if(!result.contains(sum))
                result.add(sum);

            //기저조건 중요..num == 2 이상까지 재귀반복 시 시간초과
            return;
        }

        int n = numbers.length;

        for(int i = start ; i < n ; i++){
            dfs(numbers, i+1, num+1, sum+numbers[i]);
        }
    }
}
