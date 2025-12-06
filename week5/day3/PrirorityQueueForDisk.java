package week5.day3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PrirorityQueueForDisk {
    public int solution(int[][] jobs) {
        int answer = 0;

        //대기큐 = 작업번호, 작업요청시각, 작업소요시간
        //대기큐 비어있지 않다면 우선순위 가장 높은 작업을 꺼내서 하드디스크에.
        //우선순위 = 작업소요시간 짧은, 작업 요청시각 빠른(가장 오래된), 작업 번호가 작은
        //작업 시작 = 작업 마칠때까지 지속
        //그 순간에 우선순위가 높은 작업을 진행
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> a[1] - b[1] //처리 시간
        );

        int time = 0;
        int idx = 0;
        int total = 0;
        int count = jobs.length;

        while(count > 0){
            //작업을 대기큐에 먼저 넣기
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(jobs[idx++]);
            }

            if(pq.isEmpty()){
                //pq 비어있으면 다음 작업 바로 이어서 수행
                time = jobs[idx][0];
            }else{
                int[] job = pq.poll();
                time = time + job[1]; //소요시간
                total = total + time - job[0]; //작업의 반환시각
                //큐에 넣어진 시각이 겹쳐도 어차피 처리하는 항목은 겹치지 않는다
                //=시간누적
                count--;
            }
        }

        return total/jobs.length;
    }
}
