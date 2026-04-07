package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpByDFS {
    static int N;
    static int[][] graph;
    static int[] dx = {0,1}; //오른쪽
    static int[] dy = {1,0}; //아래
    static boolean[][] visited;
    static boolean finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        //출발점 = 0,0
        //오른쪽 + 아래만 이동 가능
        //N-1, N-1 위치에 도착 시 승리
        //한번에 이동할 수 있는 "칸 수" = 그 칸에 쓰여있는 수

        N = Integer.parseInt(token.nextToken());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < N ; j++){
                graph[i][j] = Integer.parseInt(token2.nextToken());
            }
        }

        //한번에 이동 가능한 경로 지정 X 일괄 이동
        dfs(new int[]{0,0});

        if(finished) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }

    //bfs와 같은 dfs
    static void dfs(int[] cur){

        int x = cur[0];
        int y = cur[1];

        //기저
        if(x < 0 || x >= N || y < 0 || y >= N) return;
        if(visited[x][y]) return;

        if(x == N-1 && y == N-1){
            finished = true;
            return;
        }

        visited[x][y] = true;

        int steps = graph[x][y];

        if(steps == 0) return;

        //칸 수 만큼 일괄적으로 이동한다.
        for(int i = 0 ; i < 2 ; i++){
            int nx = x + dx[i] * steps;
            int ny = y + dy[i] * steps;

            dfs(new int[]{nx, ny});
        }
    }
}
