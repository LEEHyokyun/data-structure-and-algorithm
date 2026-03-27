package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CleanerBySimulationNotByBFS {
    static int N,M;
    static int x,y;
    static int direction;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //청소 영역의 개수

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        StringTokenizer token3 = new StringTokenizer(br.readLine());
        x = Integer.parseInt(token3.nextToken());
        y = Integer.parseInt(token3.nextToken());
        direction = Integer.parseInt(token3.nextToken());

        //0 : 북
        //1 : 동
        //2 : 남
        //3 : 서

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                graph[i][j] = Integer.parseInt(token2.nextToken());
                //0 = 청소되지 않은 곳
                //1 = 벽
            }
        }

        //한방향, 정해진 방향 = 시뮬레이션
        int count = 0 ;

        while(true){
            if(!visited[x][y]) {
                //청소
                count++;
                visited[x][y] = true;
            }

            //주변탐색
            boolean canMoved = false;
            for(int i = 0 ; i < 4 ; i++){
                //북동남서 0123 -> 서북동남 3012
                direction = (direction + 3) % 4;

                //방향틀고 그방향에 따라 청소가능한 영역인지 확인
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                //청소가능하면 방향틀고 그대로 이동 그리고 위 로직 반복
                if(graph[nx][ny] == 0 && !visited[nx][ny]){
                    x = nx;
                    y = ny;
                    canMoved = true;
                    break;
                }
            }

            if(!canMoved){
                //후진, direction은 유지
                int back = (direction + 2) % 4;

                //북동남서 0123 ->
                //x+1, y-1, x-1, y+1
                //2 3 0 1
                //+2 %4


                int bx = x + dx[back];
                int by = y + dy[back];

                if(graph[bx][by] == 1) break;// 벽이면 중단

                x = bx;
                y = by;
            }
        }

        System.out.println(count);
    }
}
