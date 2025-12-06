package week5.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //연산
        //자연수 -> 배열에 x 추가
        //0 -> 가장 큰 값 출력하고 배열에서 제거
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(br.readLine());

            if(x > 0){
                pq.offer(x);
            }else{
                if(pq.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
