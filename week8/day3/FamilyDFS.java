package week8.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FamilyDFS {
    static boolean[] visited;
    static List<Integer>[] list;
    static int answer;

    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer problem = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(problem.nextToken());
        int p2 = Integer.parseInt(problem.nextToken());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1]; //사람관계
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= m ; i++){
            StringTokenizer people = new StringTokenizer(br.readLine());


            int u = Integer.parseInt(people.nextToken());
            int v = Integer.parseInt(people.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        visited = new boolean[n+1];
        dfs(p1, 0, p2);

        System.out.println(answer == 0? -1 : answer);

    }

    static void dfs(int from, int depth, int target){

        if(from == target) {
            answer = depth;
            return;
        }

        visited[from] = true;

        for(int next : list[from]){
            if(!visited[next]){
                dfs(next, depth + 1, target);
            }
        }
    }
}
