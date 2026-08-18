package week34;

import java.util.ArrayList;
import java.util.List;

public class MakeMaximumValue_with_String_Simulation_and_ArrayList {
    static String[] operations = {"*", "-", "+"};
    static boolean[] operated = new boolean[3];

    public long solution(String expression) {
        /*
         * 숫자와 +, -, * 연산 수식 전달..만들 수 있는 가장 큰 숫자 제출
         * 각 연산에 대한 우선순위대로 연산 진행
         * 우선순위따라 연산을 탐색하고 그 연산과 관련된 숫자를 그대로 연산 적용.
         * 음수, 양수 상관없이 절대값이 가장 큰 경우의 수.
         */
        List<String> graph = new ArrayList<>();
        StringBuilder value = new StringBuilder();

        for(int i = 0 ; i < expression.length() ; i++){

            char ch = expression.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*'){
                graph.add(value.toString());
                graph.add(String.valueOf(ch));

                value = new StringBuilder();
            } else {
                value.append(ch);
            }
        }

        //연산 처리 후 마지막 숫자 처리까지
        graph.add(value.toString());

        return dfs(graph, 0);
    }

    static long dfs(List<String> expression, int count){

        if(count == 3){
            //절대값 계산은 연산 후 맨 마지막에 적용
            return Math.abs(
                    Long.parseLong(expression.get(0))
            );
        }

        long answer = 0;

        for(int i = 0 ; i < 3 ; i++){
            if(operated[i]) continue;

            operated[i] = true;
            answer = Math.max(
                    //Math.abs( //절대값 연산은 맨 마지막에 진행
                    answer,
                    dfs(
                            applyOperation(expression, operations[i]),
                            count + 1
                    )
                    //)
            );
            operated[i] = false;
        }

        return answer;
    }

    static List<String> applyOperation(List<String> expression, String operation){

        //연산이 연속적으로 있을 경우를 고려한다.
        List<String> newExpression = new ArrayList<>();

        /*
         * 모든 expression을 순회하면서 연산 적용 및 가공
         */
        int i = 0 ;
        while(i < expression.size()){

            if(expression.get(i).equals(operation)){

                long left = Long.parseLong(newExpression.remove(newExpression.size() - 1));
                long right = Long.parseLong(expression.get(i+1));
                long value = calculate(left, right, operation);

                i+=1;

                newExpression.add(String.valueOf(value));

            }else {

                newExpression.add(expression.get(i));

            }

            i++;
        }

        return newExpression;

    }

    static long calculate(long left, long right, String operation){

        if(operation.equals("*")) return left * right;
        if(operation.equals("-")) return left - right;

        return left + right;
    }
}
