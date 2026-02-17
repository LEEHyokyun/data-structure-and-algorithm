package week15;

import java.util.Stack;

public class StackBalancedString {
    public int solution(String s) {

        //문자열 s를 왼쪽으로 회전하였을때 올바른 괄호 문자열이 되는가?
        //올바른 괄호 문자열 추출 개수
        int answer = 0;

        int length = s.length();
        int idx = 0;

        while(idx < length){

            String str = "";

            if(idx == length - 1){
                str = s;
            }else{
                String str1 = s.substring(0, idx + 1);    // 0 ~ length -2
                String str2 = s.substring(idx + 1 , length);  // length -1 ~ length -1
                str = str2 + str1;
            }

            if(isBalanced(str)) answer++;

            idx++;
        }

        return answer;
    }

    static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();

        int length = str.length();

        for(int i = 0 ; i < length ; i++){
            char c = str.charAt(i);

            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                else{
                    if(c == '}') {
                        char ch = stack.pop();
                        if(ch != '{') return false;
                    }
                    else if(c == ']'){
                        char ch = stack.pop();
                        if(ch != '[') return false;
                    }
                    else if(c == ')'){
                        char ch = stack.pop();
                        if(ch != '(') return false;
                    }
                }

            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}
