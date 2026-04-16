package week24;

import java.util.TreeMap;

public class MaxValueAndMinValueByTreeMap {
    public int[] solution(String[] operations) {
        // I -> queue에 삽입
        // D 1 -> 최대값 삭제
        // D -1 -> 최소값 삭제
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        //오름차순(Natural) -> last  : 최대  first  : 최소
        //내림차순(Collections.reverseOrder()) -> last  : 최소 first  :  최대

        for(String operation : operations){
            String[] op = operation.split(" ");
            String o = op[0];
            int p = Integer.parseInt(op[1]);

            //16 -> 16, 1
            //-5643 -> -5643, 1
            //-1 -> max -> 16 삭제
            //1 -> min -> -5643 삭제
            //1 -> min -> x
            //

            if(o.equals("I")){
                int count = tm.getOrDefault(p, 0);
                tm.put(p, count + 1);
            }else{
                if(tm.isEmpty()) continue;

                if(p == 1){
                    //최대값 삭제

                    int min = tm.lastKey();
                    int count = tm.getOrDefault(min, 0);

                    if(count == 0) continue;
                    if(count == 1) tm.remove(min);
                    else tm.put(min, count - 1);

                }else{

                    //최대값 삭제

                    int max = tm.firstKey();
                    int count = tm.getOrDefault(max, 0);

                    if(count == 0) continue;
                    if(count == 1) tm.remove(max);
                    else tm.put(max, count - 1);
                }
            }
        }

        if(tm.isEmpty()) return new int[]{0,0};
        else {
            return new int[]{tm.lastKey(), tm.firstKey()};
        }

    }
}
