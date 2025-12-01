package week4.day4;

import java.util.Stack;

public class PricesByStack {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            //stack.push(i); //이렇게 하면 비교대상이 현재가 되어버림(when i = 2~3)
            //비교대상이 이전 = stack이 비어있지 않다.
            //[3,1]과 같은 쉬운 예시를 생각해보자.

            while(!stack.isEmpty() && (prices[i] < prices[stack.peek()])){ //가격이 떨어진 시점
                int top = stack.pop(); //최초 시작시간(=가장 최근에 pop한 시간)
                answer[top] = i - top; //result = 최초 시작시간 - 현재 시간
            }

            stack.push(i);  //비교대상이 이전이 되어야 한다.

            //i = 2
            //stack -> 2
            //i = 3
            //stack -> 2 - 3
            //top = 3
            //answer[3] = 3-3 .. 비교대상이 이전이 아닌 현재.
        }

        //가격이 떨어지지 않은 항목들 처리
        while(!stack.isEmpty()){
            int top = stack.pop();
            answer[top] = n - 1 - top;
        }

        return answer;
    }
}
