package week3.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ApartByBFS {
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> houseCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        houseCounts = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    int cnt = BFS(i, j , N);
                    houseCounts.add(cnt);
                }
            }
        }

        houseCounts.sort(Comparator.naturalOrder());

        System.out.println(houseCounts.size());
        for(int count : houseCounts){
            System.out.println(count);
        }
    }

    static int BFS(int x, int y, int N){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        int count = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    count++;
                }
            }
        }

        return count;
    }
}
