package week20;

import java.util.TreeMap;

public class TreeSetForMinAndMaxWithCounting {
    public int[] solution(String[] operations) {

        // | 숫자 = 큐에 주어진 숫자 삽입
        // D 1 => 큐의 최대값 삭제
        // D -1 => 큐의 최속밧 삭제

        //모든 연산 처리 후 비어있으면 [0,0]
        //비어있지 않으면 최대값, 최소값

        //최대 최소 연산 및 중복 원소 관리까지 가능 -> TreeMap.

        //int - count
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(String operation : operations){
            String[] splited = operation.split(" ");
            String op = splited[0];
            int value = Integer.parseInt(splited[1]);

            if(op.equals("I")){
                tm.put(value, tm.getOrDefault(value, 0) + 1);
            }else{
                if(tm.isEmpty()) continue; //Map 비어있으면 연산하지 않음

                if(value == 1){
                    //1
                    int max = tm.lastKey(); //오름차순에서 최대값은 last
                    if(tm.get(max) == 1) tm.remove(max);
                    else tm.put(max, tm.get(max) - 1);
                }else{
                    //-1
                    int min = tm.firstKey(); //오름차순에서 최소값은 first
                    if(tm.get(min) == 1) tm.remove(min);
                    else tm.put(min, tm.get(min) - 1);
                }
            }
        }

        if(tm.isEmpty()) return new int[]{0,0};
        else return new int[]{tm.lastKey(), tm.firstKey()}; //최대 - 최소
    }
}
