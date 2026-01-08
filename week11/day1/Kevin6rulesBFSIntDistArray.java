package week11.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kevin6rulesBFSIntDistArray {
    static List<Integer>[] list;
    static int count;
    static int person;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        list = new ArrayList[N+1];


        for(int i = 1 ; i <= N ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(token2.nextToken());
            int v = Integer.parseInt(token2.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        //1 -> 2 , 1 -> 3, .... 1 -> N          1에 대한 합산 = answer
        //2 -> 1 , 2 -> 3, 2 -> 4, ... 2 -> N   2에 대한 합산 = answer
        int answer = Integer.MAX_VALUE;
        person = 0;
        for(int i = 1 ; i <= N ; i++){
            int sum = bfs(i);
            if(sum < answer){
                answer = sum;
                person = i;
            }

        }

        System.out.println(person);
    }

    static int bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);

        q.offer(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list[cur]){
                //start -> ... -1이 아닌 경우는 이미 방문한 것임
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        int sum = 0 ;
        for(int dis : dist){
            sum += dis;
        }

        return sum;
    }
}
