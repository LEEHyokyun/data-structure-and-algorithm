package week25;

import java.util.TreeMap;

public class MinAndMaxByTreeMap {
    public int[] solution(String[] operations) {
        // I -> queue에 삽입
        // D 1 -> 최대값 삭제
        // D -1 -> 최소값 삭제
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        //firstKey -> 최소
        //lastKey -> 최대

        for(String op : operations){
            String[] ops = op.split(" ");
            String in = ops[0];
            int input = Integer.parseInt(ops[1]);

            if(in.equals("I")){
                System.out.println("값 삽입 : " + input);
                if(tm.getOrDefault(input, 0) == 0){
                    tm.put(input, 1);
                }else {
                    int cur = tm.get(input);
                    tm.put(input, cur + 1);
                }
            }else{
                if(input == 1){
                    //최대값 삭제
                    if(tm.isEmpty()) continue;

                    int max = tm.lastKey();
                    System.out.println("현재의 최대값은 : " + max);

                    if(tm.get(max) == 1){
                        tm.remove(max);
                    }else {
                        int cur = tm.get(max);
                        tm.put(max, cur - 1);
                    }
                }else {
                    //최소값 삭제
                    if(tm.isEmpty()) continue;

                    int min = tm.firstKey();
                    System.out.println("현재의 최소값은 : " + min);

                    if(tm.get(min) == 1){
                        System.out.print("최소값 " + min + "을 완전 삭제합니다.");
                        tm.remove(min);
                    }else {
                        int cur = tm.get(min);
                        tm.put(min, cur - 1);
                    }
                }
            }
        }

        if(tm.isEmpty()) return new int[]{0,0};
        else{

            int resMax = tm.lastKey();
            int resMin = tm.firstKey();
            int[] answer = new int[2];

            answer[0] = resMax;
            answer[1] = resMin;

            return answer;

        }
    }
}
