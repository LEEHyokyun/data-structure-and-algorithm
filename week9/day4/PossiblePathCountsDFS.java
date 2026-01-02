package week9.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PossiblePathCountsDFS {
    static int R,C,K;
    static char[][] graph;
    static boolean[][] visited;
    static int count = 0;
    static int[] start;
    static int[] dest;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token1.nextToken());
        C = Integer.parseInt(token1.nextToken());
        K = Integer.parseInt(token1.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];
        start = new int[]{R-1,0};
        dest = new int[]{0,C-1};

        for(int i = 0 ; i < R ; i++){
            graph[i] = br.readLine().toCharArray();
        }

        visited[start[0]][start[1]] = true;
        dfs(start, 1);

        System.out.println(count);
    }

    static void dfs(int[] start, int dist){

        if(dist == K){
            if(start[0] == dest[0] && start[1] == dest[1]) {
                count++;
                return;
            }
        }

        for(int i = 0 ; i < 4 ; i++){
            int nx = start[0] + dx[i];
            int ny = start[1] + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(graph[nx][ny] == 'T') continue;

            visited[nx][ny] = true;
            dfs(new int[]{nx,ny}, dist + 1); //백트래킹을 위해 매개변수 증감은 넘겨주면서 동시에
            visited[nx][ny] = false;
        }
    }
}
