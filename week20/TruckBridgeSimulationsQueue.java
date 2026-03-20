package week20;

import java.util.ArrayDeque;
import java.util.Queue;

public class TruckBridgeSimulationsQueue {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        //모든 트럭이 다리를 건너려면 최소 몇 초
        //다리에 가능한 최대 트럭 개수 - 최대 무게 - 주어진 트럭 무게(조건)
        //트럭이 모두 지나가는데 소요되는 시간은 다리의 길이.
        //대기트럭 정렬 불가

        //bridge = 현재 다리위에 올라가있는 트럭, 최초는 0
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0 ; i < bridge_length ; i++){
            bridge.offer(0);
        }

        int time = 0 ;
        int currentWeight = 0;
        int idx = 0;

        //한 트럭이 빠질때 걸리는 시간 = 다리의 길이
        while(idx < truck_weights.length){
            time++;

            //시간 지났음 = bridge 트럭 제거
            currentWeight -= bridge.poll();  //first in first out

            if(currentWeight + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);    //현재 다리위에 트럭 올려짐
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                //위에서 poll 이미 함, offer를 해서 균형 유지됨
                bridge.offer(0); //차이 : 바로 대기큐에 쌓이는지, 시간 지나고 쌓이는지
            }
        }

        //트럭이 다리에 올라간 채로 종료, 모두 지나가야 함 = 다리 길이
        return time + bridge_length;
    }
}
