package week21;

import java.util.ArrayList;
import java.util.List;

public class SequentialProgresses {
    public int[] solution(int[] progresses, int[] speeds) {

        /*
         * progresses 작업 진도
         * 각 작업의 개발 속도
         * 배포는 하루에 한번만
         */
        // Queue<Integer> q1 = new ArrayDeque<>();
        // Queue<Integer> q2 = new ArrayDeque<>();
        //Map<Integer, Integer> map = new HashMap<>();

//         for(int progress : progresses){
//             q1.offer(progress);
//         }

//         for(int speed : speeds){
//             q2.offer(speed);
//         }

        int timeToComplete = 0;
        int count = 0;

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < progresses.length ; i++){
            int time = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if(time > timeToComplete){
                if(count > 0) list.add(count); //지금까지한거 등록

                timeToComplete = time;
                count = 1;
            } else {
                count++;
            }

        }

        list.add(count);

//         while(!q1.isEmpty()){
//             int progress = q1.poll();
//             int speed = q2.poll();
//             int time = (int) Math.ceil((100.0 - progress) / speed);

//             if(time > timeToComplete){
//                 idx++;
//                 timeToComplete = time;
//                 map.put(idx, 1);
//             }else{
//                 int count = map.getOrDefault(idx, 0);

//                 map.put(idx, count + 1);
//             }

//         }

//         int size = map.size();
//         int[] answer = new int[size];

//         for(int i = 0 ; i < size ; i++){
//             answer[i] = map.get(i);
//         }


        int[] answer = new int[list.size()];

        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
