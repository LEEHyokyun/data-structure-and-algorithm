package week33;

import java.util.*;

public class Parking_Fees_with_Simulations_Math_ceil_and_Type_Casting {
    class Solution {

        //Map<Integer, Integer> map = new HashMap<>();
        //Map<Integer, <String, Integer>> map = new HashMap<>();
        /*
        * key 자동 오름차순 정렬 가능한 TreeMap 사용!
        * */
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        /*
         * 나중에 out만 계산하면 되고, in이 있으면 23:59 기준으로 out에 계산하면 됨
         */

//     static class Car{
//         int number;
//         int fee;

//         public Car(int number, int fee){
//             this.number = number;
//             this.fee = fee;
//         }
//     }

        public int[] solution(int[] fees, String[] records) {
            //출차 기록 없으면 23:59에 나간 것으로 간주
            //기본 시간 이하면 기본 요금으로 계산, 그 이후는 단위 시간 만큼 계산
            //단위 시간의 경우 올림(ceil)

//         Arrays.sort(records, (a,b) -> {

//             String[] aRecords = a.split(" ");
//             String[] bRecords = b.split(" ");

//             int numA = Integer.parseInt(aRecords[1]);
//             int numB = Integer.parseInt(bRecords[1]);

//             return numA - numB;

//         });

            List<Integer> keys = new ArrayList<>();
            for(String record : records){

                String[] str = record.split(" ");
                String[] time = str[0].split(":");
                int hour = Integer.parseInt(time[0]) * 60;
                int min = Integer.parseInt(time[1]);
                int cur = hour + min;

                int number = Integer.parseInt(str[1]);
                String status = str[2];

                //Map<String, Integer> m = map.getOrDefault(number, new HashMap<String, Integer>);

                //System.out.println("--------------현재 번호는 : " + number);

                if(status.equals("IN")){
                    //System.out.println("들어갑니다.");
                    //System.out.println("in : " + cur);
                    in.put(number, cur);

                    if(!keys.contains(number)) keys.add(number);
                }else {
                    /*
                     * 나가면 들어간 내역에서 제거해야 한다.
                     */
                    //System.out.println("나갑니다.");
                    int t1 = in.get(number);
                    int t2 = out.getOrDefault(number, 0);

                    //System.out.println("원래 시간 누적 : " + t2);
                    //System.out.println("시간 최종 누적 : " + (t2 + (-t1 + cur)));
                    //최종 시간 = in 시간 추출(t1) + 원래 시간(t2)
                    out.put(number, t2 + (-t1 + cur));
                    in.remove(number);


                }

            }

            //out 못하고 남은것들 계산
            Collections.sort(keys);
            for(int key : in.keySet()){

                //System.out.println("--------------나가지 못한 차 : " + key);


                //추가 계신해야하는 시간
                int t1 = in.get(key);
                int t = (23 * 60 + 59) - t1;

                //누적 시간
                int t2 = out.getOrDefault(key, 0);
                //System.out.println("원래 시간 : " + t2);
                //System.out.println("여기에 누적해야 하는 시간 : " + t);
                //System.out.println("최종 누적 시간 : " + (t2 + t));

                out.put(key, t2 + t);
            }

            /*
             * map에 key값 오름차순으로 삽입한다 하더라도, map 탐색 시 오름차순 정렬된 상태의 탐색을 보장할 수 없다.
             */
            List<Integer> result = new ArrayList<>();
            //for(int key : out.keySet()){
            for(int key : keys){

                int totalTime = out.get(key);

                System.out.println("현재 차 번호 : " + key);
                System.out.println("최종 시간 : " + totalTime);

                if(totalTime > fees[0]){
                    System.out.println("초과요금 정산");
                    System.out.println("곱해야 하는 값 확인 : " + (int) Math.ceil((totalTime - fees[0]) / fees[2]));
                    result.add(
                            //A/B -> 단순히 정수 몫, 따라서 올림해도 정수 몫 그대로.
                            //(double) 타입 캐스팅 + ceil -> 12.4의 올림 = 13.
                            fees[1] + fees[3] * (int) Math.ceil((double)(totalTime - fees[0]) / fees[2])
                    );

                }else {


                    System.out.println("기본요금 정산");
                    result.add(
                            fees[1]
                    );
                }

            }

            int[] answer = new int[result.size()];
            for(int i = 0 ; i < result.size() ; i++){
                answer[i] = result.get(i);
            }

            return answer;

        }
    }
}
