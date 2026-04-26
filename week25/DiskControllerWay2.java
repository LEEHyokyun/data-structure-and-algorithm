package week25;

import java.util.PriorityQueue;

public class DiskControllerWay2 {
    public int solution(int[][] jobs) {


        //큐 : 요청시각순
//         Arrays.sort(updated, (a,b) -> {

//             //소요시각 같으면 요청 시각 먼저 순
//             if(a[1] == b[1]) return a[0] - b[0];

//             //소요시각 짧은 순
//             return a[1] - b[1];
//         });

        // Queue<int[]> q1 = new ArrayDeque<>
        // for(int[] job : updated)
        //     q1.offer(job);

        //디스크 컨트롤러 : 작업 x, 대기큐에 있다면 우선순위 높은 작업을 대기큐에서 꺼냄.
        //작업 소요시간 짧은 순, 요청 시각 빠른 순, 작업 번호 작은 순
        //현재 우선순위대로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            if(a[1] == b[1]) return a[0] - b[0];

            return a[1] - b[1];
        });

        int idx = 0;
        int time = 0;
        int answer = 0;
        while(idx < jobs.length){

            for(int i = idx ; i < jobs.length ; i++){
                if(jobs[i][0] <= time) pq.add(jobs[i]);
            }

            while(!pq.isEmpty()){
                int[] cur = pq.poll();

                answer += (time + cur[1]) - cur[0];
                time += cur[1];

                //System.out.println("현재 작업 내역 : " + cur[1] + " " + cur[0]);
                idx++;
            }

        }

        return answer / jobs.length;

    }
}
