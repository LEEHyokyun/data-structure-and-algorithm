package week34;

import java.util.ArrayList;
import java.util.List;

public class MakeMaximumValue_With_String_Simulation_and_State_and_AppliedState_Class {
    static class State{
        List<Long> numbers;
        List<String> opers;

        public State(List<Long> numbers, List<String> opers){
            this.numbers = numbers;
            this.opers = opers;
        }
    }

    static State applyOperation(
            List<Long> numbers,
            List<String> opers,
            String operation
    ){
        List<Long> newNumbers = new ArrayList<>();
        List<String> newOpers = new ArrayList<>();

        newNumbers.add(numbers.get(0));

        for(int i = 0 ; i < opers.size() ; i++){

            String operator = opers.get(i);

            if(operator.equals(operation)){

                long left = newNumbers.remove(newNumbers.size() - 1);
                long right = numbers.get(i + 1);

                newNumbers.add(
                        calculate(left, right, operator)
                );

            }else {

                newOpers.add(operator);
                newNumbers.add(numbers.get(i+1));

            }
        }

        return new State(newNumbers, newOpers);
    }

    static long calculate(long left, long right, String operator){

        if(operator.equals("*")) return left * right;
        if(operator.equals("-")) return left - right;

        return left + right;

    }

    static String[] operations = {"*", "-", "+"};
    static boolean[] operated = new boolean[3];

    public long solution(String expression) {

        List<Long> numbers = new ArrayList<>();
        List<String> opers = new ArrayList<>();

        StringBuilder value = new StringBuilder();

        for(int i = 0 ; i < expression.length() ; i++){

            char ch = expression.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*'){
                numbers.add(Long.parseLong(value.toString()));
                opers.add(String.valueOf(ch));

                value.setLength(0);
            }else {

                value.append(ch);
            }
        }

        numbers.add(Long.parseLong(value.toString()));

        return dfs(numbers, opers, 0);

    }

    static long dfs(List<Long> numbers, List<String> opers, int count){

        if(count == 3) return Math.abs(numbers.get(0));

        long answer = 0;

        for(int i = 0 ; i < 3 ; i++){

            if(operated[i]) continue;

            operated[i] = true;
            State next = applyOperation(
                    numbers,
                    opers,
                    operations[i]
            );

            answer = Math.max(
                    answer,
                    dfs(
                            next.numbers,
                            next.opers,
                            count + 1
                    )
            );

            operated[i] = false;
        }

        return answer;
    }
}
