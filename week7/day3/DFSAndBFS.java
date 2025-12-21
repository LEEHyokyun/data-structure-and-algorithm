package week7.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSAndBFS {
    static List<Integer>[] graph;
    static boolean[] dVisited;
    static boolean[] bVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer init = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        int V = Integer.parseInt(init.nextToken());

        graph = new ArrayList[N+1];
        dVisited = new boolean[N+1];
        bVisited = new boolean[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M ; i++){
            StringTokenizer edge = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(edge.nextToken());
            int v = Integer.parseInt(edge.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i = 1 ; i <= N ; i++){
            Collections.sort(graph[i]);
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    static void dfs(int start){
        System.out.print(start + " ");
        dVisited[start] = true;

        for(int next : graph[start]){
            if(!dVisited[next])
                dfs(next);
        }
    }

    static void bfs(int start){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        bVisited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");

            for(int v : graph[cur]){
                if(!bVisited[v]){
                    bVisited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
}
