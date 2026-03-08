package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ApartmentsBFS {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            //StringTokenizer token = new StringTokenizer(br.readLine());
            //그대로 받자
            String token = br.readLine();

            for(int j = 0 ; j < N ; j++){
                graph[i][j] = token.charAt(j) - '0'; //char > int
            }
        }


        int count = 0 ;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(visited[i][j]) continue;
                if(graph[i][j] == 0) continue;

                list.add(bfs(new int[]{i,j}));
                count++;
            }
        }

        //list.add(count);
        System.out.println(count);
        list.sort(Comparator.naturalOrder());

        for(int answer : list){
            System.out.println(answer);
        }
    }

    static int bfs(int[] start){
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x < 0 || y < 0 || x >= N || y >= N) continue;
                if(visited[x][y]) continue;
                if(graph[x][y] == 0) continue;

                q.offer(new int[]{x,y});
                visited[x][y] = true;
                count++;
            }
        }

        return count;
    }
}
