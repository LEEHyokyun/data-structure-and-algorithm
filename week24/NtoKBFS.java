package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class NtoKBFS {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        //1초 -> cur - 1, cur + 1
        //0초 -> cur * 2

        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dist[N] = 0; //해당 구간에 가는데 걸린 시간

        int next = 0;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == K){
                System.out.println(dist[cur]);
                return;
            }

            next = cur * 2;
            if(next >= 0 && next <= 100000 && dist[next] > dist[cur]){
                dist[next] = dist[cur];
                q.offer(next);
            }

            next = cur - 1;
            if(next >= 0 && next <= 100000 && dist[next] > dist[cur] + 1){
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }

            next = cur + 1;
            if(next >= 0 && next <= 100000 && dist[next] > dist[cur] + 1){
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }
    }
}
