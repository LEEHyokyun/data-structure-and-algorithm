package week33;

import java.util.ArrayList;
import java.util.List;

public class DartResult_with_String_Simulation_and_ArrayList_순서주의 {
    public int solution(String dartResult) {
        //3번, 0 ~ 10점
        //S : Single(점수 1제곱) D : Double(점수 2제곱) T : Triple(점수 3제곱)
        //스타상(*) -> 해당 점수 * 2, 바로 전에 얻은 점수 * 2 (*첫번째 나올 경우 해당 점수만 2배), 중첩 가능(바로 전에 얻은 점수 또 2배 혹은 -일 경우 그 -값을 2배)
        //아차상(#) -> 해당 점수 -,

        /*
         * 1S2D*3T
         * = 1^1 * 2+ 2*2 + 3 ^ 3
         */

        List<Integer> list = new ArrayList<>();

        //list size가 idx를 따라가지 않는다.
        for(int idx = 0 ; idx < dartResult.length() ; idx++){

            char c = dartResult.charAt(idx);

            //숫자면 추가하고 다른 옵션 및 보너스면 연산 처리
            if(Character.isDigit(c)){
                int num = Integer.parseInt(String.valueOf(c));

                if(num == 1){
                    if(idx < dartResult.length() - 2 && Character.isDigit(dartResult.charAt(idx + 1)) && Integer.parseInt(String.valueOf(dartResult.charAt(idx + 1))) == 0){
                        list.add(10);
                        idx++;
                    }else {
                        list.add(1);
                    }
                }
                else list.add(num);
            }else {
                list = operate(list, c, idx);
            }

        }

        System.out.println("list size : " + list.size());

        int answer = 0;
        for(int val : list) answer += val;
        return answer;
    }

    static List<Integer> operate(List<Integer> list, char c, int idx){

        int size = list.size();
        System.out.println("현재 list 현황(size) : " + list.size());

        if(c == 'S'){

            return list;

        }else if(c == 'D'){

            int prev = list.get(size - 1);
            System.out.println(" D 적용 : " + prev);
            list.remove(size - 1);
            list.add(prev * prev);

        }else if(c == 'T'){

            int prev = list.get(size - 1);
            System.out.println(" T 적용 : " + prev);
            list.remove(size - 1);
            list.add(prev * prev * prev);

        }else if(c == '*'){


            if(size < 2){

                int prev = list.get(size - 1);
                list.remove(size - 1);
                list.add(prev * 2);

            }else {
                int prev = list.get(size - 1);
                int pprev = list.get(size - 2);
                list.remove(size - 1);
                list.remove(size - 2);
                //list.add(prev * 2);
                list.add(pprev * 2);
                list.add(prev * 2); //삽입 순서 주의
            }

        }else if(c == '#'){

            int prev = list.get(size - 1);
            list.remove(size - 1);
            list.add(prev * (-1));

        }

        return list;
    }
}
