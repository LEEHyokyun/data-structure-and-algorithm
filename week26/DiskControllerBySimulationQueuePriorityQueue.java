package week26;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskControllerBySimulationQueuePriorityQueue {
    public int solution(int[][] jobs) {

            Queue<int[]> q = new ArrayDeque<>();
            for(int[] job : jobs){
                q.offer(job);
            };

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

                if(a[1] == b[1]) return a[0] - b[0];

                return a[1] - b[1];
            });

            // for(int[] job : jobs){
            //     pq.offer(job);
            // };

            int time = 0;
            int answer = 0;
            int idx = 0;
            int count = 0;

            while(true){

                /*
                 * 0 ->
                 */
                //일단 현재 시간까지 대기큐에 있는 내역들을 뽑고
                while(idx < jobs.length && jobs[idx][0] <= time){
                    //System.out.println("대기큐 삽입 : " + idx);
                    pq.offer(jobs[idx]);
                    idx++;
                    //System.out.println("삽입 후 다음 idx : " + idx);
                }

                //이 중 우선순위가 가장 높은 애를 처리한다.
                if(!pq.isEmpty()){
                    int[] cur = pq.poll();
                    //System.out.println("현재 처리할 작업의 요청 시각 : " + cur[0] + " 소요 시각 : " + cur[1]);

                    answer += (cur[1] + time) - cur[0];
                    count++;

                    //System.out.println("현재 시각 : " + time);
                    time += cur[1];
                    //System.out.println("처리 후 시각 : " + time);
                }else{
                    time = jobs[idx][0];
                }


                //if(idx >= jobs.length && pq.isEmpty()) break;
                if(count == jobs.length) break;
            }

//         while(!q.isEmpty()){

//             int[] cur = q.poll();
//             int[] priority = pq.poll();

//             if(cur[0] <= time && cur[0] == priority[0] && cur[1] == priority[1]){
//                 answer += (cur[1] + time) - cur[0];
//                 time += cur[1];
//             }else{
//                 q.offer(cur);
//                 pq.offer(priority);
//             }
//         }

            return answer / jobs.length;
        }
}
