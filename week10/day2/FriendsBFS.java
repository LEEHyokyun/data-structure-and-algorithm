package week10.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class FriendsBFS {
    static char[][] graph;
    static boolean[][] visited;
    static int[] start;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        visited = new boolean[N][M];
        graph = new char[N][M];
        for(int i = 0 ; i < N ; i++){

            graph[i] = br.readLine().toCharArray();
            for(int j = 0 ; j < M ; j++){
                if(graph[i][j] == 'I') start = new int[]{i,j};
            }
        }

        int result = bfs(start, N, M);
        System.out.println((result == 0) ? "TT" : result);
    }

    static int bfs(int[] start, int N, int M){

        int answer = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(graph[x][y] == 'P') answer++;

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == 'X') continue;

                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }

        return answer;
    }
}
