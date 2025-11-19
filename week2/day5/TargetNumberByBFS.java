package week2.day5;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumberByBFS {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        //BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int sum = now[0];
            int idx = now[1];

            //기저조건 : 끝까지 시행했을때(애초에 이게 문제 조건임)
            if(idx == numbers.length){
                if(sum == target)
                    answer++;
                continue;   //다음 queue 진행
            }
            //주어진 모든 원소를 활용해야하므로 아래 분기처리는 모순이다.
            // }else{
            //     if(sum == target)
            //         answer++;
            // }

            //idx = 시행횟수 1회 ~ length까지
            q.offer(new int[]{sum + numbers[idx], idx + 1}); //+
            q.offer(new int[]{sum - numbers[idx], idx + 1}); //-
        }

        return answer;
    }
}
