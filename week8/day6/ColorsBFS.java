package week8.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class ColorsBFS {
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new char[N][N];


        for(int i = 0 ; i < N ; i++){
            graph[i] = br.readLine().toCharArray();
        }

        //normal
        visited = new boolean[N][N];
        int normal = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[i][j]) {
                    bfs(graph, new int[]{i,j}, N, false);
                    normal++;
                }
            }
        }

        //blind
        visited = new boolean[N][N];
        int blind = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[i][j]) {
                    bfs(graph, new int[]{i,j}, N, true);
                    blind++;
                }
            }
        }

        System.out.print(normal + " " + blind);
    }

    static void bfs(char[][] graph, int[] start, int N, boolean isBlind){
        int[] cur = start;
        int cx = cur[0];
        int cy = cur[1];
        char c = graph[cx][cy];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(cur);
        visited[cx][cy] = true;

        while(!q.isEmpty()){
            int[] n = q.poll();
            int nx = n[0];
            int ny = n[1];

            for(int i = 0 ; i < 4 ; i++){
                int x = nx + dx[i];
                int y = ny + dy[i];

                if(x < 0 || y < 0 || x >= N || y >= N) continue;
                if(visited[x][y]) continue;

                if(isSameColor(c, graph[x][y], isBlind)){
                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                }
            }
        }
    }

    static boolean isSameColor(char cur, char next, boolean isBlind){
        if(!isBlind) return cur == next;
        if(cur == 'B') return next == 'B';
        return next == 'R' || next == 'G';
    }
}
