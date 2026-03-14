package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Make6NumbersDFS {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] graph = new int[5][5];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 5 ; i++){

            StringTokenizer token = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < 5 ; j++){
                graph[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                dfs(new int[]{i,j}, 0, "");
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int[] start, int path, String value){

        int cx = start[0];
        int cy = start[1];

        value = value + graph[cx][cy];

        if(path == 5){
            set.add(Integer.parseInt(value));
            return;
        }

        for(int i = 0 ; i < 4 ; i++){

            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            dfs(new int[]{nx, ny}, path + 1, value);
        }
    }
}
