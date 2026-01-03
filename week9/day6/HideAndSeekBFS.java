package week9.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeekBFS {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[] dist = new int[MAX+1];
        int[] ways = new int[MAX+1];

        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dist[N] = 0;
        ways[N] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();


            for(int next : new int[]{cur -1, cur +1, cur * 2}){
                if(next < 0 || next > MAX) continue; //점은 0 ~ 100000

                //최초 방문
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;  //시간
                    ways[next] = ways[cur];      //방법수
                    q.offer(next);
                }

                //동일 시간에 방문(cur -> next) .. way도 같이 증가
                else if(dist[next] == dist[cur] + 1){
                    ways[next] = ways[next] + ways[cur];
                }
            }
        }


        //N > K
        System.out.println(dist[K]);
        System.out.println(ways[K]);
    }
}
