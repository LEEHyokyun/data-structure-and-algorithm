package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class RainyAreaCountingBFS {
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //물에 잠기지 않는 영역의 최대 개수
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0 ; i < N ; i++){

            StringTokenizer token = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < N ; j++){
                int value = Integer.parseInt(token.nextToken());
                graph[i][j] = value;

                min = Math.min(min, value);
                max = Math.max(max, value);

            }
        }

        int answer = 0;

        for(int K = min - 1 ; K <= max ; K++){
            visited = new boolean[N][N];
            int count = 0;

            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){

                    if(visited[i][j]) continue;
                    if(!isPossible(graph[i][j], K)) continue;

                    count++;
                    bfs(visited, K, new int[]{i,j});
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static boolean isPossible(int height, int rain){
        if(height > rain) return true;
        else return false;
    }

    static void bfs(boolean[][] visited, int rain, int[] start){
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(start);

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x < 0 || y < 0 || x >= N || y >= N) continue;
                if(!isPossible(graph[x][y], rain)) continue;
                if(visited[x][y]) continue;

                q.offer(new int[]{x,y});
                visited[x][y] = true;
            }
        }

    }
}
