package week32;

import java.util.ArrayDeque;
import java.util.Queue;

public class Trucks_on_Bridge_with_Simulation_and_Queue {
    static class Truck{
        int weight;
        int idx;

        public Truck(int weight, int idx){
            this.weight = weight;
            this.idx = idx;
        }
    }

    Queue<Truck> bridge = new ArrayDeque<>();
    Queue<Truck> ready = new ArrayDeque<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        for(int i = 0 ; i < truck_weights.length ; i++){

            ready.offer(new Truck(truck_weights[i], i));

        }

        for(int i = 0 ; i < bridge_length ; i++){

            bridge.offer(new Truck(0, -1));

        }

        int answer = 0;
        int current = 0;

        //ready
        while(!ready.isEmpty()){

            //올라가든 못올라가든 무조건 시간은 지난다.
            Truck out = bridge.poll();
            current -= out.weight;

            //그리고 무게 제한에 대한 처리
            if(current + ready.peek().weight <= weight){

                Truck in = ready.poll();
                bridge.offer(in);
                current += in.weight;


            }else {

                bridge.offer(new Truck(0, -1));

            }

            //시간은 무조건 지난다.
            answer++;

        }

        //bridge에 남아있는 트럭을 모두 제거한다.
        /*
         * bridge_length가 가능한 이유 : ready가 비는 시점
         * = 즉, 마지막 트럭이 bridge에 올라간 시점까지 진행하므로
         * 최종적으로 모든 다리 위에 있는 트럭은 길이만큼 시간이 흘러야 된다.
         */
        answer += bridge_length;

        return answer;
    }
}
