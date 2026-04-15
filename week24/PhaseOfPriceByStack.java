package week24;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PhaseOfPriceByStack {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] solution(int[] prices) {

        int length = prices.length;
        int[] answer = new int[length];

        //for idx
        Stack<Integer> stack = new Stack<>();

        //i = idx, 최초 price
        for(int i = 0 ; i < length ; i++){

            int price = prices[i];

            //while .. stack에 있는 모든 인덱스를 확인함
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int prev = stack.pop();
                int cur = i;
                int time = cur - prev;

                answer[prev] = time;
            }

            stack.push(i);

        }

        //끝까지 stack에 남아있는 인덱스 처리
        while(!stack.isEmpty()){
            int idx = stack.pop();
            int time = length - idx - 1;
            answer[idx] = time;
        }

        return answer;
    }
}
