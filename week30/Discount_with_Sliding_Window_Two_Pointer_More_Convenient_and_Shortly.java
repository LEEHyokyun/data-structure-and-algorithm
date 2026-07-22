package week30;

import java.util.HashMap;
import java.util.Map;

public class Discount_with_Sliding_Window_Two_Pointer_More_Convenient_and_Shortly {
    public int solution(String[] want, int[] number, String[] discount) {
        //금액 지불 시 10일 동안 회원 자격 부여
        //투포인터로 옮겨가면서 해당 항목에 모두 want 항목이 존재한다면 이동

        int idx = 0;
        Map<String, Integer> map1 = new HashMap<>();
        for(String product : want){
            map1.put(product, number[idx++]);
        }

        Map<String, Integer> map2 = new HashMap<>();

        int left = 0;
        int right = 10;
        for(int i = left ; i < right ; i++){
            String product = discount[i];
            int count = map2.getOrDefault(product, 0);
            map2.put(product, count + 1);
        }

        int answer = 0;

        //sliding window
        while(true){

            if(isPossible(map1, map2)) answer++;
            if(right == discount.length) break;

            String removed = discount[left];
            String plused = discount[right];
            //right = right + 1;

            //제거 따로
            int count1 = map2.getOrDefault(removed, 0);

            if(count1 == 1) map2.remove(removed);
            else map2.put(removed, count1 - 1);

            //추가 따로
            int count2 = map2.getOrDefault(plused, 0);
            map2.put(plused, count2 + 1);

            left++;
            right++;
        }

        return answer;
    }

    static boolean isPossible(Map<String, Integer> map1, Map<String, Integer> map2){

        //System.out.println("조건 만족 판별");

        for(String key : map1.keySet()){

            //System.out.println("현재 품목 : " + key);
            //System.out.println("map1(want) : " + map1.getOrDefault(key, 0));
            //System.out.println("map2(discount) : " + map2.getOrDefault(key, 0));

            if(map2.getOrDefault(key, 0) < map1.getOrDefault(key, 0)) {
                //System.out.println("불가 판정");
                return false;
            }
        }

        return true;
    }

//     static boolean isPossible(String[] want, int[] number, String[] discount, int left , int right){
//         /*
//         * 지금처럼 순회 하여 기준을 생성하거나(시간복잡도 충분)
//         * map = new HashMap<>(original); 로 복사하여 로직을 간편화하거나
//         * s
//         */
//         int idx = 0;
//         Map<String, Integer> map = new HashMap<>();

//         for(String product : want){

//             map.put(product, number[idx++]);

//         }

//         for(int i = left ; i <= right ; i++){

//             //이런 연산 후 판별 분기는 반복문 초입이 아닌 끝에 두는 것이 맞다.
//             // if(map.size() == 0) {
//             //     System.out.println("품목 모두 제거 완료");
//             //     return true;
//             // }
//             //System.out.println("현재 품목 탐색 인덱스 : " + i);
//             String product = discount[i];
//             //System.out.println("현재 discount 품목 : " + product);
//             int count = map.getOrDefault(product, -1);
//             //System.out.println("현재 discount 품목의 map 상태(카운팅) : " + count);

//             if(count == -1) continue;
//             else {

//                 if(count == 1) {
//                     map.remove(product);
//                     if(map.size() == 0) return true;
//                     //System.out.println(product + " 제거");
//                 }else if(count > 1) map.put(product, count - 1);
//                 else continue;

//             }

//         }

//         return false;

//     }
}
