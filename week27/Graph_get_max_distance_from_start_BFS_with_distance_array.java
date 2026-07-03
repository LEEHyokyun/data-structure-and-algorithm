package week27;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph_get_max_distance_from_start_BFS_with_distance_array {
    /*
     * bfs를 활용한 최단 거리일 경우 거리 배열 등을 별도로 활용할 것.
     */
    static List[] graph;
    static boolean[] visited;
    static int[] dist;

    public int solution(int n, int[][] edge) {

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] vertex : edge){
            int from = vertex[0];
            int to = vertex[1];

            graph[from].add(to);
            graph[to].add(from);
        }

        int answer = bfs(1, graph);

        return answer;
    }

    static int bfs(int start, List[] graph){

        dist[start] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;

        q.offer(start);

        int answer = 0;
        int count = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            List<Integer> list = graph[cur];

            //list = null -> NPE, list가 초기화되어있으나 인접노드가 없다면 size = 0
            //for(int node : graph[i])
            for(int i = 0 ; i < list.size() ; i++){
                if(visited[list.get(i)]) continue;

                //System.out.println(cur + "노드의 인접 노드인 " + list.get(i) + "를 탐색 대상에 추가");

                q.offer(list.get(i));
                visited[list.get(i)] = true;

                dist[list.get(i)] = dist[cur] + 1;

                //answer = Math.max(answer, dist[list.get(i)]);

                if(answer == dist[list.get(i)]) {
                    //System.out.println("최대값 : " + answer + " 현재 거리 : " + dist[list.get(i)] + " 카운트 증가.");
                    count++;
                    //System.out.println("현재 카운트 : " + count);
                }
                else {
                    answer = dist[list.get(i)];
                    count = 1;
                };
            }
        }

        return count;

    }
}
