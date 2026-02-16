package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortestPathesBFS {
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] start;
    static int[][] graph;
    static int[][] answer;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        answer = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                int value = Integer.parseInt(token2.nextToken());
                graph[i][j] = value;

                if(value == 2) {
                    start = new int[]{i,j};
                    answer[i][j] = 0;
                }

                if(value == 0) answer[i][j] = 0;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x < 0 || y < 0 || x >= n || y >= m) continue;
                if(graph[x][y] == 0) continue;
                if(visited[x][y]) continue;

                q.offer(new int[]{x,y});
                visited[x][y] = true;
                answer[x][y] = answer[cur[0]][cur[1]] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(graph[i][j] == 1 && !visited[i][j])  //아직 안갔고 1이어야 함
                    sb.append(-1).append(" ");
                else //나머지는 그대로 출력
                    sb.append(answer[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
