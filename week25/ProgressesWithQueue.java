package week25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ProgressesWithQueue {
    public int[] solution(int[] progresses, int[] speeds) {

        //각 배포마다 몇개의 기능 배포 가능한지
        Queue<Integer> q1 = new ArrayDeque<>();
        for(int progress : progresses){
            q1.offer(progress);
        }

        Queue<Integer> q2 = new ArrayDeque<>();
        for(int speed : speeds){
            q2.offer(speed);
        }

        List<Integer> list = new ArrayList<>();

        while(!q1.isEmpty()){
            int answer = 1;
            int remained = 100 - q1.poll();
            int speed = q2.poll();

            /*
             * 소요 시간 = 올림
             */
            int required = (int) Math.ceil((double)remained / speed);

            while(true){

                if(q1.isEmpty()) break;

                int nextRemained = 100 - q1.peek();
                int nextSpeed = q2.peek();

                if(required >= (int) Math.ceil(((double)nextRemained / nextSpeed))){
                    answer++;
                    q1.poll();
                    q2.poll();
                }else{
                    break;
                }
            }

            list.add(answer);

        }

        int size = list.size();
        int[] result = new int[size];

        for(int i = 0 ; i < size ; i++)
            result[i] = list.get(i);

        return result;
    }
}
