package week23;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskControllerByPriorityQueue {
    public int solution(int[][] jobs) {

        //대기 큐 ..
        //우선순위가 높은 작업부터 작업
        //소요시간 짧은 것, 요청 시각이 빠른 것, 번호가 작은 것

        Arrays.sort(jobs, (a, b) -> {
            //if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        }); //대기큐..이것도 2차적으로 요청시간 순 정렬도 필요함

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //작업소요시각

        // for(int i = 0 ; i < jobs.length ; i++){
        //     pq.offer(jobs[i]);
        // }

        int time = 0;
        int answer = 0;
        int idx = 0;
        while(idx < jobs.length || !pq.isEmpty()){

            //작업대상만 pq에 넣고
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(jobs[idx]);
                idx++;
            }

            //처리
            if(!pq.isEmpty()){
                int[] cur = pq.poll();

                time += cur[1];
                answer += time - cur[0];
            }else{
                //time = jobs[idx][0];
                time++;
            }

        }

        return answer / jobs.length;
    }
}
