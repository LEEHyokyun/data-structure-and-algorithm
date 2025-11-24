package week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Printer {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //결국 "인쇄되는 순서"는 인쇄하기까지 우선순위를 기반으로 재배치하여 가장 낮은 우선순위가 나올때까지 인쇄보류
            //후순위가 나왔을때 그때 인쇄
            int T = Integer.parseInt(br.readLine());

            while(T-- >0){
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                int N = Integer.parseInt(tokenizer.nextToken());
                int M = Integer.parseInt(tokenizer.nextToken());

                StringTokenizer nums = new StringTokenizer(br.readLine(), " ");
                Queue<int[]> q = new LinkedList<>(); //큐
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최고중요도 확인

                //conditions
                for(int i = 0 ; i < N ; i++){
                    int priority = Integer.parseInt(nums.nextToken());
                    q.add(new int[]{i, priority});
                    pq.add(priority);
                }

                //solving
                int count = 0;

                while(true){
                    int[] now = q.poll();

                    //우선순위가 크면 인쇄
                    if(now[1] == pq.peek()){
                        pq.poll();
                        count++;

                        //근데 그게 조건 인덱스라면
                        if(now[0] == M){
                            System.out.print(count);
                            break;
                        }
                    }else{
                        //뽑은 숫자의 우선순위가 후순위라면 offer
                        q.offer(now);
                    }
                }
            }

        }
}
