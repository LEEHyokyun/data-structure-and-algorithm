package week2.day5;

public class Stack {
        boolean solution(String s) {
            boolean answer = true;

            java.util.Stack<Character> stack = new java.util.Stack<>();

            for(int i = 0 ; i < s.length() ; i++){
                char ch = s.charAt(i);

                if(ch == '(')
                    stack.push(ch);
                else{
                    if(stack.isEmpty()){
                        answer = false;
                        //따라서 스택이 비어있는 상태라면 무조건 false
                        return answer;
                    }

                    else
                        //처음부터 )일 경우, return 이 없다면 이 분기를 타게되어 오류 발생(비어있는데 pop)
                        stack.pop();
                }
            }

            if(stack.isEmpty())
                answer = true;
            else
                answer = false;

            return answer;
        }
}
