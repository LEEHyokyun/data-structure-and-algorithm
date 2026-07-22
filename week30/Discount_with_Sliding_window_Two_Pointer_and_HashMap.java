package week30;

import java.util.HashMap;
import java.util.Map;

public class Discount_with_Sliding_window_Two_Pointer_and_HashMap {
    public int solution(String[] want, int[] number, String[] discount) {
        //금액 지불 시 10일 동안 회원 자격 부여
        //투포인터로 옮겨가면서 해당 항목에 모두 want 항목이 존재한다면 이동


        int left = 0;
        int right = 9;
        int answer = 0;

        while(true){

            //System.out.println("현재 오른쪽 끝 : " + right);
            if(right == discount.length) break;

            if(isPossible(want, number, discount, left, right)){
                //System.out.println("할인가능");
                answer++;
            }else {
                if(right == discount.length) break;
            }

            left++;
            right++;
        }

        return answer;
    }

    static boolean isPossible(String[] want, int[] number, String[] discount, int left , int right){

        int idx = 0;
        Map<String, Integer> map = new HashMap<>();

        for(String product : want){

            map.put(product, number[idx++]);

        }

        for(int i = left ; i <= right ; i++){

            //이런 연산 후 판별 분기는 반복문 초입이 아닌 끝에 두는 것이 맞다.
            // if(map.size() == 0) {
            //     System.out.println("품목 모두 제거 완료");
            //     return true;
            // }
            //System.out.println("현재 품목 탐색 인덱스 : " + i);
            String product = discount[i];
            //System.out.println("현재 discount 품목 : " + product);
            int count = map.getOrDefault(product, -1);
            //System.out.println("현재 discount 품목의 map 상태(카운팅) : " + count);

            if(count == -1) continue;
            else {

                if(count == 1) {
                    map.remove(product);
                    if(map.size() == 0) return true;
                    //System.out.println(product + " 제거");
                }else if(count > 1) map.put(product, count - 1);
                else continue;

            }

        }

        return false;

    }
}
