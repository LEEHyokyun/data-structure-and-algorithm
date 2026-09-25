package week35;

import java.util.ArrayList;
import java.util.List;

public class Traffics_Log_Searching_추석트래픽_By_StringAPI_And_Utils_And_Simulations {
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

            String[] info = line.split(" ");
            String times = info[1];
            String durations = info[2];

            String[] timeInfo = times.split(":");

            long hh = Long.parseLong(timeInfo[0]) * 60 * 60 * 1000;
            long mm = Long.parseLong(timeInfo[1]) * 60 * 1000;
            long ss = (long)(Double.parseDouble(timeInfo[2]) * 1000);

            long end = hh + mm + ss;

            String durationInfo = durations.replace("s", "");

            long duration = (long)((Double.parseDouble(durationInfo) * 1000) - 1);

            list.add(new Log(
                    end - duration,
                    end
            ));
        }

        int count = 0;

        for(Log log : list){

            long startRange = log.end;
            long endRange = log.end + 999;

            int matched = 0;
            for(Log target : list){

                if(target.end >= startRange && target.start <= endRange) matched++;

            }

            count = Math.max(count, matched);

        }

        return count;
    }
}
