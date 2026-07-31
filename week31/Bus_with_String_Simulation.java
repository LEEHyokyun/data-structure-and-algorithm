package week31;

import java.util.Arrays;

public class Bus_with_String_Simulation {
    public String solution(int n, int t, int m, String[] timetable) {

        int length = timetable.length;
        int[] crew = new int[length];

        for(int i = 0 ; i < length ; i++){
            String[] time = timetable[i].split(":");
            crew[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }

        Arrays.sort(crew);

        int start = 9 * 60;
        int end = start + n * t;
        int count = 0;
        int idx = 0;

        int last = 0;

        for(int i = start ; i < end ; i+= t){ //n회 운행 -> 인덱스 상으로 n-1(출발시간 포함하므로)
            count = 0;
            //idx -> 전체 사람
            //count -> 당시 태운 승객 수

            while(idx < crew.length){

                //태우고
                if(crew[idx] <= i){
                    idx++;
                    count++;

                    if(count >= m) break; //태우는데 수용인원 초과 시 다음 버스
                    //아니면 다음 버스
                }else {
                    break;
                }
            }


            last = i;
            if(idx == crew.length) break; //이미 승객을 다채웠으면 마지막 버스와 수용인원 정보를 들고 탈출
        }

        int answer = 0;

        //중요한건 마지막 버스 + 마지막 버스의 수용 상태 + 마지막으로 탄 사람의 인덱스(= idx - 1)
        //승객이 찼다 -> 여기서 탈 수 있는 가장 마지막 승객의 -1
        //승객이 덜 찼다 -> 마지막 버스 그대로 탄다.
        if(count < m) answer = last;
        if(count >= m) answer = crew[idx - 1] - 1;

        int hr = answer / 60;
        int min = answer % 60;

        return String.format("%02d:%02d", hr, min);
    }
}
