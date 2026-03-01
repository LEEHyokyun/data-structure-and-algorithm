package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SeperateAreaBFS {
    static int M,N,K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken()); //가로
        N = Integer.parseInt(token.nextToken()); //세로
        K = Integer.parseInt(token.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        //좌표 - 왼쪽아래 = 0,0 오른쪽 위 = N,M
        //x1, y1 (왼쪽아래) + x2, y2 (오른쪽 위)
        while(K-- >0){
            StringTokenizer token2 = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(token2.nextToken());
            int y1 = Integer.parseInt(token2.nextToken());
            int x2 = Integer.parseInt(token2.nextToken());
            int y2 = Integer.parseInt(token2.nextToken());

            //x좌표와 y좌표가 곧 graph의 위치와 동일
            for(int x = x1 ; x < x2 ; x++){
                for(int y = y1 ; y < y2 ; y++){
                    graph[y][x] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(graph[i][j] == 1) continue;
                if(visited[i][j]) continue;

                list.add(bfs(new int[]{i,j}));
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append('\n');
        for(int res : list){
            sb.append(res).append(" ");
        }

        System.out.println(sb);
    }

    static int bfs(int[] start){
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int x = cx + dx[i];
                int y = cy + dy[i];

                if(x < 0 || y < 0 || x >= M || y >= N) continue;
                if(graph[x][y] == 1) continue;
                if(visited[x][y]) continue;

                q.offer(new int[]{x, y});
                visited[x][y] = true;
                count++;
            }
        }

        return count;
    }
}
