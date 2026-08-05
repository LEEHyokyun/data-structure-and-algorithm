package week32;

import java.util.Arrays;

public class ShuttleBus_with_String_Simulation {
    public String solution(int n, int t, int m, String[] timetable) {

        int[] times = new int[timetable.length];
        for(int i = 0 ; i < timetable.length ; i++){

            String[] time = timetable[i].split(":");

            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);

            times[i] = hour * 60 + min;

        }

        Arrays.sort(times);

        //승객을 태우다가
        //마지막 버스까지 못태운다 -> 맨 마지막 승객 도착 시각 -1분
        //마지막 버스에서 태울 수 있다 -> 그 버스의 도착 시각

        //셔틀은 09:00부터 n회 t분 간격으로 도착한다.
        int start = 9 * 60;
        int end = start + t * n;

        int curTime = 0;
        int count = 0;
        int idx = 0;
        for(int i = start ; i < end ; i += t){

            curTime = i;
            //System.out.println("***현재 도착한 버스는 : " + curTime + " ***");

            count = 0;

            while(idx < times.length && times[idx] <= curTime && count < m){ //시점이 1시점 늦으니까 미만 조건으로 판별
                //System.out.println("현재 승객 : " + times[idx]);
                count++;
                //System.out.println("수용 가능! 카운팅 : " + count);
                idx++;
            }

            //사람 태우는 것 상관없이 마지막 도착 버스까지는 도달해야 한다.

        }

        //마지막 탄 사람 = idx - 1;
        int answer = 0;

        //탈 수 없으면 마지막 탄 사람 -1분,
        //탈 수 있으면 마지막 도착한 버스 도착 시간
        //System.out.println("마지막 버스에 탄 사람의 수 : " + count);
        //System.out.println("버스에 태울 수 있는 총 승객의 수 : " + m);
        if(count < m) {
            //System.out.println("수용 가능 : 마지막 도착한 버스의 시간");
            answer = curTime;
        }
        else {
            //System.out.println("수용 불가 : 마지막 탄 사람 -1분");
            //System.out.println("수용 불가 : 마지막 탄 사람의 시간 : " + times[idx - 1]);
            answer = times[idx - 1] - 1;
        }

        int hr = answer / 60;
        int mn = answer % 60;

        return String.format("%02d:%02d", hr, mn);
    }
}
