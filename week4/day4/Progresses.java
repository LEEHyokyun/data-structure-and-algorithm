package week4.day4;

import java.util.ArrayList;
import java.util.List;

public class Progresses {
    public int[] solution(int[] progresses, int[] speeds) {

            int[] buildingDays = new int[progresses.length];
            for(int i = 0 ; i < buildingDays.length ; i++){
                //double to int
                buildingDays[i] = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            }

            List<Integer> result = new ArrayList<>();
            int prev = buildingDays[0];
            int count = 1;

            for(int i = 1 ; i < buildingDays.length ; i++){
                if(buildingDays[i] <= prev){
                    count++;
                }else{
                    result.add(count);
                    count = 1;
                    prev = buildingDays[i];
                }
            }

            result.add(count);

            int[] answer = new int[result.size()];

            for(int i = 0 ; i < result.size() ; i++){
                answer[i] = result.get(i);
            }

            return answer;
        }
}
