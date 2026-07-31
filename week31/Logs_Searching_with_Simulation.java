package week31;

import java.util.ArrayList;
import java.util.List;

public class Logs_Searching_with_Simulation {
    static class Log{
        //소수 포함이므로
        long start;
        long end;

        Log(long start, long end){
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[] lines) {
        //초당 처리량 = 임의 시간부터 1초(1000ms)간 처리하는 요청의 최대 수
        //처리 시간은 0.001 ~ 3.000, 시작 시간 + 끝시간이므로 걸리시간 -0.001초 제외
        //혹은 끝 시간 - 시작 시간 + 0.001
        List<Log> list = new ArrayList<>();

        for(String line : lines){
            String[] info = line.split(" ");
            String[] time = info[1].split(":");

            long hour = Long.parseLong(time[0]);
            long min = Long.parseLong(time[1]);
            double sec = Double.parseDouble(time[2]); //소수

            //00시 기준 start ~ end 구간으로 판별(ms단위)
            long end = (hour * 3600 * 1000 + min * 60 * 1000 + (long) (sec * 1000));
            long duration = (long) (Double.parseDouble(info[2].replace("s", "")) * 1000);
            long start = end - duration + 1;

            list.add(new Log(start, end));
        }

        int answer = 0;

        /*
         * 카운팅이 되는 순간은 처리가 진행되는 구간이 아닌 처리가 종료된 후.
         * end시간을 중심으로 파악하기
         * 모든 로그의 종료지점을 시작지점으로 잡고 계산
         */
        for(Log log : list){

            long s = log.end;
            long e = log.end + 999;

            int count = 0;

            for(Log l : list){
                //탐색 범위내에 "걸치면" 된다.
                //로그의 시작이 탐색점 이상, 로그의
                //if(l.start <= e || l.end >= s) count++;
                //if(!(l.end < s || l.start > e)) continue;
                /*
                 * 구간의 만족
                 * 구간의 끝점이 start 이상
                 * 구간의 시작점이 end 이하 둘다 만족 시 !!!!
                 */
                if(l.end >= s && l.start <= e) count++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
