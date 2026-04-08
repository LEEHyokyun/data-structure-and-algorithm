package week23;

import java.util.ArrayDeque;
import java.util.Queue;

public class TruckQueueSimulation {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < bridge_length ; i++){
            q.offer(0);
        }

        int time = 0;
        int idx = 0;
        int truck = 0;

        while(true){
            if(idx == truck_weights.length) break;

            truck -= q.poll();
            time++;

            if(truck + truck_weights[idx] <= weight){
                truck += truck_weights[idx];
                q.offer(truck_weights[idx]);
                idx++;
            }else{
                q.offer(0);
            }
        }

        return time + q.size();
    }
}
