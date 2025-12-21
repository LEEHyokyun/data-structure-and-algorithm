package week7.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingScheduleGreedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //init
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        for(int[] meeting : meetings){
            StringTokenizer schedule = new StringTokenizer(br.readLine(), " ");

            meeting[0] = Integer.parseInt(schedule.nextToken());
            meeting[1] = Integer.parseInt(schedule.nextToken());
        }

        //greedy
        Arrays.sort(meetings, (a, b) -> {
            if(b[1] == a[1]) return a[0] - b[0];
            return a[1] - b[1]; //종료시간 오름차순, 시작시간 오름차순
        });

        int count = 0;
        int end = 0;

        for(int[] meeting : meetings){
            if(meeting[0] >= end){
                count++;
                end = meeting[1];
            }
        }

        System.out.println(count);
    }
}
