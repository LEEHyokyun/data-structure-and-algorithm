package week22;

import java.util.ArrayDeque;
import java.util.Queue;

public class TruckSimulationByQueue {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        //단순 순차 처리가 아니라
        //chunk 기반의 처리가 필요

        //다리 위 = queue
        //다리 길이 = 다리에 올라갈 수 있는 트럭의 수 = 그만큼의 시간이 지나야 통과 가능
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < bridge_length ; i++){
            q.offer(0);
        }

        int sum_weight = 0;
        int idx = 0;
        int count = 0;

        while(idx < truck_weights.length){

            sum_weight -= q.poll();

            if(sum_weight + truck_weights[idx] <= weight){

                q.offer(truck_weights[idx]);
                sum_weight += truck_weights[idx];
                idx++;
            }else{
                q.offer(0);
            }

            count++;

        }

        //queue의 모든 요소를 제거해야 총 지나가는 시간을 구할 수 있음
        return count + q.size();
    }
}
