package week14;

import java.util.Arrays;

public class ShuttlebusesStringParsing {
    public String solution(int n, int t, int m, String[] timetable) {

        //마지막 셔틀 도착 시각에 대해
        //탑승인원이 m명 미만 -> 마지막 셔틀 시간 그대로
        //탑승인원이 m명 이상 -> 마지막으로 타는 사람 - 1분

        //시간 -> 분
        int length = timetable.length;
        int[] crew = new int[length];
        for(int i = 0 ; i < length ; i++){
            String[] time = timetable[i].split(":");
            crew[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }

        Arrays.sort(crew); //숫자 오름차순

        int idx = 0; //크루 태우기
        int lastTime = 0;
        int count = 0; //탄 사람

        //태우기
        for(int i = 0 ; i < n ; i++){
            int arrived = 540 + i * t; //최초 도착 시각 : 9시 = 540분
            count = 0;

            while(idx < crew.length && crew[idx] <= arrived && count < m){
                idx++;
                count++;
            }

            lastTime = arrived;
        }

        //다 태우고 -> idx = length
        //마지막까지 다 태우거나, 다 못태웠거나 -> idx = 못탄사람

        //가장 마지막에 탄 사람 = idx - 1

        int answer = 0;

        if(count < m){
            answer = lastTime;
        }else{
            answer = crew[idx - 1] - 1; //마지막에 탄 사람 = idx -1
        }



        int hour = answer / 60;
        int min = answer % 60;

        return String.format("%02d:%02d", hour, min);
    }
}
