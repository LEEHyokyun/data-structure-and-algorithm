package week32;

public class Log_TPS_with_String_Simulation {
    static class Log{

        long start;
        long end;
        long duration;

        public Log(long start, long end){

            this.start = start;
            this.end = end;

        }

    }

    public int solution(String[] lines) {
        //초당 최대 처리량
        //처리 기간 = 시작 및 끝시간을 포함
        //start = end - (duration - 1)

        //첫번째 로그의 종료지점을 기준으로 1초 .. 이를 기준으로 처리량 계산
        //다음 로그의 종료지점을 기준으로 1초 .. 이를 기준으로 처리량 계산
        //..
        //2회 순회 로그 2000개, 2회 순회 시 400만회, 수용 가능 수준

        Log[] logs = new Log[lines.length];

        int idx = 0;
        for(String line : lines){

            String[] times = line.split(" ");
            String[] logTimes = times[1].split(":");
            String duration = times[2].replace("s", "");
            //String[] sss = logTimes[2].split("\\."); //escape 처리

            long hh = Long.parseLong(logTimes[0]) * 60 * 60 * 1000;
            long mm = Long.parseLong(logTimes[1]) * 60 * 1000;
            //long ss = Long.parseLong(sss[0]) * 1000 + Long.parseLong(sss[1]);
            long ss = (long)(Double.parseDouble(logTimes[2]) * 1000); //바로 소수점 처리

            long end = hh + mm + ss;
            long start = end - (long)(Double.parseDouble(duration) * 1000 - 1);

            logs[idx++] = new Log(
                    start,
                    end
            );
        }

        int answer = 0;
        for(int i = 0 ; i < logs.length ; i++){

            Log cur = logs[i];

            long searchStart = cur.end;
            long searchEnd = searchStart + 999; //1초 = 시작/끝시간 포함하므로 duration - 1
            int count = 0;

            for(int j = i ; j < logs.length ; j++){

                Log next = logs[j];

                if(next.start <= searchEnd && next.end >= searchStart) count++;
                else break;

            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
