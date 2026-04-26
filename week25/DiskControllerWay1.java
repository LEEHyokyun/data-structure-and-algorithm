package week25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DiskControllerWay1 {
    public int solution(int[][] jobs) {

        int[][] updated = jobs;

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

        int idx = 0;
        int time = 0;
        int answer = 0;
        while(idx < jobs.length){

//             Queue<int[]> q = new ArrayDeque<>((a,b) -> {

//                 if(a[1] == b[1]) return a[0] - b[0];

//                 return a[1] - b[1];
//             });
            Queue<int[]> q = new ArrayDeque<>();

            for(int i = idx ; i < jobs.length ;){
                List<int[]> list = new ArrayList<>();

                while(true){
                    if(jobs[i][0] <= time) {
                        System.out.println("가능한 작업 내역 확인 : " + jobs[i][0]);
                        list.add(jobs[i]);
                        i++;
                    }else{
                        break;
                    };
                }


                list.sort((a,b) -> {

                    if(a[1] == b[1]) return a[0] - b[0];

                    return a[1] - b[1];
                });


                for(int j = 0 ; j < list.size() ; j++)
                    q.offer(list.get(j));
            }

            while(!q.isEmpty()){
                int[] cur = q.poll();

                answer += (time + cur[1]) - cur[0];
                System.out.println("현재 작업의 요청시간과 작업시간은 : " + cur[1] + " " + cur[0]);
                time += cur[1];

                System.out.println("answer : "+ answer);
                System.out.println("time : "+ time);
            }

        }

        return answer / jobs.length;

    }
}
