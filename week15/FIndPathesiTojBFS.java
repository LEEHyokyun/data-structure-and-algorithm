package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FIndPathesiTojBFS {
    static List<Integer>[] graph;
    static int[][] answer;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        answer = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N ; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                int X = Integer.parseInt(token.nextToken());

                if(X == 1) {
                    graph[i].add(j);
                } else
                    continue;
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(bfs(new int[]{i,j}))
                    answer[i][j] = 1;
                else
                    answer[i][j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j : answer[i]){
                if(j == 1) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean bfs(int[] cur){
        int from = cur[0];
        int to = cur[1];

        visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(from);
        visited[from] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            //if(now == to) return true;

            for(int next : graph[now]){
                if(next == to) return true;
                if(visited[next]) continue;

                q.offer(next);
                visited[next] = true;
            }
        }

        return false;
    }
}
