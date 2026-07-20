package week30;

import java.util.Arrays;

public class MST_make_minimum_weights_kruskal {
    /*
     * 그래프 가중치 합이 최소가 되도록 모든 정점을 연결하는 방법
     * MST(크루스칼 알고리즘)
     */
    static int[] parent;

    public int solution(int n, int[][] costs) {

        //parent
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i;

        //sort : 최소비용 순서대로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int answer = 0;

        for(int[] cost : costs){

            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            /*
             * 최소비용 순서대로 간선 선택
             * 사이클이 생기지 않는다면 연결, 최소 비용의 간선을 기준으로 사이클이 생기지 않도록 연결
             */
            if(getParent(from) != getParent(to)){
                union(from, to);

                answer += weight;
            }

        }

        return answer;
    }

    static int getParent(int node){
        if(parent[node] == node) return node;

        return parent[node] = getParent(parent[node]);
    }

    static void union(int from, int to){
        int parentFrom = getParent(from);
        int parentTo = getParent(to);

        if(parentFrom != parentTo) parent[parentFrom] = parentTo;
    }
}
