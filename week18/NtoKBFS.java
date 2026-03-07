package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class NtoKBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int MAX = 100000;

        //그곳에 도달하는데 걸린 시간
        int[] time = new int[MAX + 1];

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(N);
        time[N] = 1;

        //BFS = 방문한 시점이 곧 최단거리 혹은 최단시간을 보장
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == K) break;

            //방문하지 않았을 경우에만 방문 및 누적하면 됨
            if(cur + 1 <= MAX && time[cur + 1] == 0){
                time[cur + 1] = time[cur] + 1;
                q.offer(cur + 1);
            }

            if(cur - 1 >= 0 && cur - 1 <= MAX && time[cur - 1] == 0){
                time[cur - 1] = time[cur] + 1;
                q.offer(cur - 1);
            }

            if(cur * 2 <= MAX && time[cur * 2] == 0){
                time[cur * 2] = time[cur] + 1;
                q.offer(cur * 2);
            }
        }

        System.out.println(time[K] - 1); //첫시작이 1초라서 누적 소요시간은 1초를 빼줘야 함
    }
}
