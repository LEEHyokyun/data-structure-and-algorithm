package week33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Mountain_Pathes_with_Dijkstra_and_BFS {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        //n개 지점, 출입구, 쉼터 혹은 산봉우리
        //intensity : 휴식없이 이동해야 하는 시간 중 가장 긴 시간, 이 시간을 최소
        //즉 처음 -> 산봉우리, 산봉우리 -> 처음으로 이어지는 다익스트라 2번
        //그러면서 intensity 최소 = 가중치의 합 최소
        //휴식지점은 고려안해도 됨, 산봉우리는 한번만 포함.

        graph = new ArrayList[n + 1];
        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] path : paths){
            int from = path[0];
            int to = path[1];
            int weight = path[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        int[] answer = new int[2];
        /*
         * start에 대한 다익스트라를 각각 적용하는게 아니라,
         * 모든 start 지점을 0으로 두고 시작
         * 즉, 시작점을 모두 고려한 상태로 다익스트라 최초 1회만 시행한다.
         * 그리고 출발지점 > 산봉우리 올라가는 한번의 시행만으로 intensity 도출 가능함.
         */
//         for(int start : gates){
//             //gate -> summit dijk

//             answer = dijkstra(start);
//         }
        answer = dijkstra(summits, gates, n);
        //return 산봉우리 최소 번호(여러개일 경우) + intensity 최소값
        return answer;
    }

    //이건 다익스트라라기보다는 bfs에 가깝다.
    static int[] dijkstra(int[] summits, int[] gates, int nodes){

        int[] intensity = new int[nodes + 1];
        Arrays.fill(intensity, INF);

        //for(int gate : gates) distance[gate] = 0;

        boolean[] isGate = new boolean[nodes + 1];
        boolean[] isSummit = new boolean[nodes + 1];

        /*
         * 현재까지 알려진 가장 작은 intensity를 추출하기 위해 출발지점을 가중치 기준 정렬로 하는 것.
         * 이후 인접노드를 정렬할때도 가중치가 적은 순으로 배열하여 intensity가 작은 경로를 우선으로 지난다.
         * BFS처럼 탐색하지만, 최단거리/최소비용을 결정하는 원리는 Dijkstra
         */
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a,b) -> a.weight - b.weight
        );

        /*
         * 다익스트라의 방식을 지금까지 알려진 최소 가중치를 중심으로 구하는 것이 아니라
         * 애초부터 정해진 출발점(gates)로 지정한다.
         */
        for(int gate : gates) {
            isGate[gate] = true;
            intensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }
        for(int summit : summits) isSummit[summit] = true;

        //intensity 갱신 : 다익스트라 같지만 bfs와 유사하다.
        while(!pq.isEmpty()){

            Node cur = pq.poll();

            int to = cur.to;
            //to로 도달하기 위해 intensity가 가장 큰 가중치를 고른 것.
            int nextWeight = cur.weight;

            /*
             * 우리가 원하는 것은 가중치가 적은 경로로 가는 것.
             * 새로 가는 경로가 지금의 가중치보다 더 크다면 고려하지 않는다.
             * 즉, 굳이 빙 돌아서 가지 않는 과정과 유사.
             */
            if(nextWeight > intensity[to]) continue;

            //산봉우리 도착하면 끝
            if(isSummit[to]) continue;

            for(Node next : graph[to]){

                if(isGate[next.to]) continue;

                //intensity 갱신은 최대값으로 한다.
                //인접노드로 가면서 가장 최대의 값으로 갱신한다.
                int nextMax = Math.max(
                        nextWeight,
                        next.weight
                );

                //to로 가는 가중치 중 가장 적은 가중치를 intensity로 고려.
                //to로 가는 가중치 중 최대를 고르고, 그 최대 중 가장 작은 값을 intensity로 고려.
                //결국 요하는 것은 최대 중 최소.
                if(nextMax < intensity[next.to]){
                    intensity[next.to] = nextMax;
                    pq.offer(
                            new Node(next.to, nextMax)
                    );
                }
            }
        }

        int bestSummit = -1;
        int bestIntensity = INF;

        for(int s : summits){
            if(intensity[s] < bestIntensity){
                bestIntensity = intensity[s];
                bestSummit = s;
            } else if (intensity[s] == bestIntensity){
                bestSummit = Math.min(bestSummit, s);
            }
        }

        return new int[]{
                bestSummit,
                bestIntensity
        };


//         for(int i = 0 ; i < nodes ; i++){

//             int minNode = -1;
//             int miDist = INF;
//             boolean[] visited = new boolean[nodes + 1];

//             for(int j = 1 ; j <= nodes ; j++){
//                 /*
//                 * 마찬가지로 지금까지 알려진 최소 거리(intensity)를 탐색 대상으로 삼되,
//                 * 갱신 과정을 가중치의 합이 아닌 가중치 중 가장 큰 값이 결국 intensity.
//                 * 다만 출발지점을 선택할 수는 없다.
//                 */
//                 if(visited[j]) continue;
//                 if(distance[j] != 0 && distance[j] < INF) {
//                     minNode = j;
//                     minDist = distance[j];
//                 }
//             }

//             if(minNode == -1) break;
//             visited[minNode] = true;

//             //이후 인접노드로 가면서 경로를 탐색해갈때 가중치의 최대를 찾는다(intensity)


//         }
    }
}
