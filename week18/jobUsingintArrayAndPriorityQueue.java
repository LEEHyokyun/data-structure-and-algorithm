package week18;

import java.util.Arrays;
import java.util.PriorityQueue;

import static java.util.Arrays.*;

public class jobUsingintArrayAndPriorityQueue {
    public int solution(int[][] jobs) {

        int answer = 0;

        //index : 작업번호 0 : 작업 요청시각 1 : 작업 소요시각
        //우선순위 : 작업 소요시간 짧은 것 - 요청 시각이 빠른 것 - 번호가 작은 것

        sort(jobs, (a, b) -> a[0] - b[0]); //요청시간 짧은 순 배열

        //대기큐 운용
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> a[1] - b[1]  ///소요시각 짧은 것
        );

        int time = 0;
        int idx = 0;
        int total = 0;
        int leng = jobs.length;
        int jobCount = jobs.length;


        while(jobCount > 0){
            //대기큐 기준 .. 요청시각 빠른 순으로 정렬된 job을 넣는다.
            //현재 time보다 요청시각이 빠르면 그대로 수행

            while(idx < leng && jobs[idx][0] <= time){
                pq.offer(jobs[idx++]); //0초에 들어온 작업이 2개 이상일 수 있음(누적)
            }

            if(pq.isEmpty()){
                time = jobs[idx][0]; //time -> 다음 time (요청시각)으로.
            }else{
                int[] job = pq.poll();
                time = time + job[1];
                total = total + time - job[0]; //구하고자하는 것
                jobCount--;
            }

            //중간에 탈출 조건이 있으면 큐를 비우기 전에 탈출하여 중간 과정 누락.
        }

        return total / jobs.length;
    }
}
