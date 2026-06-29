package week27;

import java.util.Stack;

public class AlphabetPairs_Stack {
    //연속된 문자가 같으면 제거, 다르면 보관
    static Stack<String> stack = new Stack<>();

    public int solution(String s)
    {
        char[] ch = s.toCharArray();

        for(char c : ch){

            if(stack.isEmpty()){
                stack.push(String.valueOf(c));
            }else{
                if(stack.peek().equals(String.valueOf(c))){
                    stack.pop();
                }else{
                    stack.push(String.valueOf(c));
                }
            }

        }

        if(!stack.isEmpty()) return 0;
        else return 1;
    }
}
