package week30;

import java.util.HashMap;
import java.util.Map;

public class Borrowing_Clothes_with_HashMap {
    //-1 -> 빌려줌 1 -> 여벌 2 -> lost 3 -> 여벌 있는데 도난 당한 경우
    static Map<Integer, Integer> map = new HashMap<>();

    public int solution(int n, int[] lost, int[] reserve) {

        int v1 = lost.length;
        int v2 = reserve.length;
        int v3 = n - v1 - v2;

        for(int i = 0 ; i < v1 ; i++) map.put(lost[i], 2);
        for(int i = 0 ; i < v2 ; i++) map.put(reserve[i], 1);

        int count = 0;

        for(int key : map.keySet()){

            int val = map.getOrDefault(key, 0);

            if(val == -1) continue;
            if(val == 1) continue;

            //2 : lost
            //System.out.println("현재 " + key);
            if(isPossible(key)) {
                //System.out.println("현재 " + key + "는 여벌 옷을 빌렸습니다.");
                count++;
            }
        }

        return v2 + v3 + count;
    }

    static boolean isPossible(int key){

        //양쪽 확인
        int val1 = map.getOrDefault(key - 1, 0);
        int val2 = map.getOrDefault(key + 1, 0);

        //System.out.println("빌려줄 수 있는 친구 후보 : " + (key - 1) + "의 값 : " + val1);
        //System.out.println("빌려줄 수 있는 친구 후보 : " + (key + 1) + "의 값 : " + val2);

        if(val1 == 1){
            map.put((key - 1), -1);
            return true;
        }

        if(val2 == 1){
            map.put((key + 1), -1);
            return true;
        }

        return false;

    }
}
