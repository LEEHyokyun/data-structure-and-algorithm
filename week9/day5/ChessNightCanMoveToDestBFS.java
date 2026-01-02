package week9.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class ChessNightCanMoveToDestBFS {
    static int[][] graph;
    static int[] start = new int[2];
    static int[] dest = new int[2];
    static boolean[][] visited;
    static int answer;
    static int[] dx = {1,1,2,2,-1,-1,-2,-2};
    static int[] dy = {2,-2,1,-1,2,-2,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            int I = Integer.parseInt(br.readLine());
            StringTokenizer token1 = new StringTokenizer(br.readLine());
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(token1.nextToken());
            start[1] = Integer.parseInt(token1.nextToken());
            dest[0] = Integer.parseInt(token2.nextToken());
            dest[1] = Integer.parseInt(token2.nextToken());

            graph = new int[I][I];
            visited = new boolean[I][I];

            //최소 몇번만에. = bfs
            bfs(graph, start, dest);
            System.out.println(answer);

            answer = 0;
        }
    }

    static void bfs(int[][] graph, int[] start, int[] dest){

        int path = 0;
        int leng = graph.length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], path});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            path = cur[2];

            if(x == dest[0] && y == dest[1]) {
                answer = path;
                return;
            }

            for(int i = 0 ; i < 8 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= leng || ny >= leng) continue;
                if(visited[nx][ny]) continue;

                q.offer(new int[]{nx,ny,path + 1});
                visited[nx][ny] = true;
            }
        }
    }
}
