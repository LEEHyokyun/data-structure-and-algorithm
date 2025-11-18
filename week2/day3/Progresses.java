package week2.day3;

import java.util.ArrayList;

public class Progresses {
    public int[] solution(int[] progresses, int[] speeds) {

        //각 progress마다 소요시간 먼저 저장하고
        //순회하면서 작으면 -> 배포수 증가, 크면 -> 새로운 배포그룹 생성

        int[] buildTimes = new int[progresses.length];
        for(int i = 0 ; i < progresses.length ; i++){
            int buildTime = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            buildTimes[i] = buildTime;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int prev = buildTimes[0];
        int count = 1;

        for(int i = 1 ; i < buildTimes.length ; i++){
            if(buildTimes[i] <= prev){
                count++;
            }else{
                result.add(count);
                count = 1;
                prev = buildTimes[i];
            }
        }

        result.add(count);

        //ArrayList -> int[] 배열로 다시 변환한다.
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
