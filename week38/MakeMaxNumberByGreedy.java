package week38;

import java.util.Stack;

public class MakeMaxNumberByGreedy {
    public String solution(String number, int k) {
        /*
         * number 2 ~ 100만
         * k개 수를 제거하고 재배열할때 만들 수 있는 가장 큰 수
         * 주어진 숫자의 순서를 그대로 유지
         */
        Stack<Integer> stack = new Stack<>();

        /*
         * 순회하면서 다음 숫자가 더 크면 앞의 숫자를 제거
         * 스택에 남아있는 숫자들이 현재 나온 앞의 숫자들보다 작으면 스택의 수를 모두 제거해주어야 한다.
         * 큰 숫자가 나오면 바로바로 대체하는 형태로
         * Queue가 아닌 Stack을 활용해서 바로바로 대체하는 방향으로 접근한다.
         */
        int count = 0;

        /*
         * 1) 현재 숫자를 넣기 전에 나보다 더 작은 숫자가 앞에 있고, 아직 허용 횟수 이내라면 제거(제거를 지속한다.)
         * 2) 크거나 없다면 스택에 계속 넣는다.
         */
        for(char ch : number.toCharArray()){
            int num = ch - '0';

            while(!stack.isEmpty() && stack.peek() < num && count < k){
                stack.pop();
                count++;
            }

            stack.push(num);
        }

        //만약 카운트가 0이라면, 맨 뒤 숫자를 카운트만큼 제거
        if(count == 0){
            while(count < k) {
                stack.pop();
                count++;
            }
        }


        String answer = "";
        System.out.println(stack.size());
        for(int i = 0 ; i < stack.size() ; i++){
            answer += stack.get(i);
        }

        return answer;
    }
}
