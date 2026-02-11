package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class NtoKBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int MAX = 100000;

        //*2 -> 시간 소요x
        //-1, +1 -> 시간 소요o

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[] dist = new int[MAX+1];
        //int[] ways = new int[MAX+1];

        Arrays.fill(dist, -1);

        Queue<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        dist[N] = 0;
        //ways[N] = 1;

        while(!dq.isEmpty()){
            int cur = dq.poll(); //인접노드 앞에서 추출

            if(cur == K) break;

            //가중치가 다름
            int nextWithoutCost = cur * 2;

            if(nextWithoutCost <= MAX && (dist[nextWithoutCost] == -1 || dist[nextWithoutCost] > dist[cur])){
                dist[nextWithoutCost] = dist[cur];
                dq.offer(nextWithoutCost);
            }

            for(int  nextWithCost : new int[]{cur - 1, cur + 1}){
                if(nextWithCost < 0 || nextWithCost > MAX) continue;

                if(dist[nextWithCost] == -1 || dist[nextWithCost] > dist[nextWithCost] + 1){
                    dist[nextWithCost] = dist[cur] + 1;
                    dq.offer(nextWithCost);
                }
            }

        }

        System.out.println(dist[K]);

    }
}
