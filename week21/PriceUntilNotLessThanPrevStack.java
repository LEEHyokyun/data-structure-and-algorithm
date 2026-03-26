package week21;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PriceUntilNotLessThanPrevStack {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] solution(int[] prices) {

        //가격이 떨어지지 않은 초
        //index = 0 -> ... if(value[idx] < origin) return time;

        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for(int price : prices){

            //stack -> "idx"
            //stack 저장된 idx 값보다 떨어지는 시점을 체크.

            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();

                //2 -> 3
                //3 -> 2
                //idx = 2 -> 1초 (= i - idx)

                //while .. 복수 이상의 인덱스보다 떨어진 값이 있으면 순환하면서 적용

                answer[idx] = i - idx;
            }

            stack.push(i);

            //인덱스를 넣는 아이디어
            i++;
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;

            //n = 5일때
            //idx = 3 -> 1초 = n - 1 - idx
            //idx = 4 -> 0초
        }

        return answer;

    }
}
