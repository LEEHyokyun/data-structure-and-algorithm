package week15;

import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FeesUsingMapAndTreeMap {
    static Map<String, Integer> map = new TreeMap<>();
    static int[] cars;
    static int maxTime = 23 * 60 + 59;
    static int[] count = new int[10000];

    public int[] solution(int[] fees, String[] records) {
        //누적 주차시간에서
        //먼저 분단위로 바꾸고
        //180 이상 -> 기본요금 + 나머지 분당 단위요금 적용
        //180 미만 -> 기본요금
        //분당 단위요금 적용할 경우 나누어 떨어지지 않는다면 Math.floor

        //차량번호 key : 주차시간 Integer
        for(String record : records){
            StringTokenizer token = new StringTokenizer(record);

            String time = token.nextToken();
            String num = token.nextToken();
            String status = token.nextToken();

            String[] HHMM = time.split(":");
            int HH = Integer.parseInt(HHMM[0]) * 60;
            int MM = Integer.parseInt(HHMM[1]);

            if(status.equals("IN")){
                if(map.get(num) == null){
                    map.put(num, maxTime - (HH + MM));
                }else{
                    int t = map.get(num);
                    map.put(num, t + maxTime - (HH + MM));
                }
            }else{
                int t = map.get(num);
                map.put(num, t - maxTime + (HH + MM));
            }

        }

        Set<String> keySet = map.keySet();

        int[] answer = new int[keySet.size()];
        int idx = 0;
        for(String num : keySet){
            int totalTime = map.get(num);

            if(totalTime > fees[0]){
                answer[idx++] = fees[1] + ((int) Math.ceil((double)(totalTime - fees[0]) / fees[2])) * fees[3];
            }else{
                answer[idx++] = fees[1];
            }

        }

        return answer;
    }
}
