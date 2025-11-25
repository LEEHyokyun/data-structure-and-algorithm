package week3.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//DFS
public class VirusByDFS {
    static boolean[] visited;
    //key point : 2차원 배열이 아닌 1차원 배열로만 문제조건이 주어졌을때 연결정보를 표현하는 방법
    //=arrayList가 요소인 배열
    static ArrayList<Integer>[] graph;
    //1번 컴퓨터 제외
    static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1 ; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        //연결정보
        for(int i = 0 ; i < M ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1);
        System.out.print(count);
    }

    static void dfs(int start){
        //방문하면 인접노드, count++
        visited[start] = true;

        //노드 계속 파고들면서 방문
        for(int next : graph[start]){
            //인접노드 있으면 방문(방문X했을때)
            if(!visited[next]){
                count++;
                dfs(next);
            }
        }
    }
}
