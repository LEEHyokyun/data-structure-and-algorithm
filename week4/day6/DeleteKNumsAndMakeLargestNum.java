package week4.day6;

import java.util.Stack;

public class DeleteKNumsAndMakeLargestNum {
    public String solution(String number, int k) {
        String answer = "";

        //stack = result
        Stack<Character> stack = new Stack<>();

        for(char num : number.toCharArray()){

            while(!stack.isEmpty() && k > 0 && stack.peek() < num){
                //순회숫자가 더 크면 stack push
                stack.pop();
                k--;
            }

            //init
            stack.push(num);
        }

        //뒤에서 제거
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }

        //stack -> String
        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);  //단순 stack 순회

        return sb.toString();
    }
}
