package week33;

import java.util.ArrayList;
import java.util.List;

public class TrafficLogs_with_String_Simulations {
    static class Log{

        long start;
        long end;

        public Log(long start, long end){
            this.start = start;
            this.end = end;
        }

    }

    static List<Log> list = new ArrayList<>();

    public int solution(String[] lines) {

        for(String line : lines){

            String[] l = line.split(" ");
            String times = l[1];
            String durations = l[2];

            String[] t = times.split(":");
            long hh = Long.parseLong(t[0]) * 60 * 60 * 1000;
            long mm = Long.parseLong(t[1]) * 60 * 1000;
            long ss = (long)(Double.parseDouble(t[2]) * 1000);
            //System.out.println("end time(ss) : " + ss);
            long end = hh + mm + ss;

            String d = durations.replace("s", "");
            long duration = (long)((Double.parseDouble(d) * 1000)) - 1;
            //System.out.println("duration : " + duration);

            list.add(new Log(
                    end - duration,
                    end
            ));
        }

        int count = 0;
        for(Log log : list){

            //1s = 999ms
            int searched = 0;
            for(Log searchingLog : list){
                if(searchingLog.end >= log.end && searchingLog.start <= (log.end + 999)) searched++;
            }

            count = Math.max(count, searched);
        }

        return count;
    }
}
