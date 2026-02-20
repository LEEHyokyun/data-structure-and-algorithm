package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BinaryGraphBFSWithColor {
    static int k;
    static List<Integer>[] graph;
    //static boolean[] visited; //단순 bfs가 아닌 이분 그래프 탐색을 위해 색깔 그래프 운용이 필요
    static int[] color; //0: 미방문, -1:파랑, 1:빨강

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        while(k-- > 0){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(token.nextToken());
            int e = Integer.parseInt(token.nextToken());

            graph = new ArrayList[v+1];
            //visited = new boolean[v+1];
            color = new int[v+1];

            for(int i = 0 ; i <= v ; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 1 ; i <= e ; i++){
                StringTokenizer token2 = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(token2.nextToken());
                int v2 = Integer.parseInt(token2.nextToken());

                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            System.out.println(bfs(1,v));
        }
    }

    static String bfs(int start, int v){
        String answer = "YES";

        //visited[start] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        //전 구간에 대해 인접 색깔 칠하기 및 사이클 판단 필요
        for(int i = 1 ; i <= v ; i++){
            if(color[i] != 0) continue;

            q.offer(i);
            color[i] = 1;

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int next : graph[cur]){
                    if(color[next] == 0){
                        color[next] = -color[cur];
                        q.offer(next);
                    }else if(color[next] == color[cur]){
                        answer = "NO";
                    }
                }
            }
        }

        //모든 인접노드의 검수가 완료되어야 이분 그래프는 자명해진다.

        return answer;
    }
}
