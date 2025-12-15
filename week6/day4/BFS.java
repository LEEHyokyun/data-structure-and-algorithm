package week6.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= M ; i++){
            StringTokenizer nodes = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(nodes.nextToken());
            int v = Integer.parseInt(nodes.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N+1];
        int count = 0;

        for(int i = 1 ; i <= N ; i++){
            if(!visited[i]){
                count++;
                bfs(i);
            }
        }


        System.out.println(count);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
