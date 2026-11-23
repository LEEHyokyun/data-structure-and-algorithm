package week39;

import java.util.Arrays;

public class MinimumIslandConnectionsByKruskal {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        /*
         * 모든 정점을 연결하면서 그 가중치가 최소 -> MST(크루스칼)
         */
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i; //본인

        int answer = 0;

        //비용 적은 순서대로(다익스트라처럼)
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            if(getParent(from) != getParent(to)){
                union(from, to); //부모가 다르면 부모를 맞춰주자.
                answer += weight; //이미 비용순으로 정렬하였으므로 부모 맞추기만 하면 누적하기
            }
        }


        return answer;
    }

    static int getParent(int node){
        if(parent[node] == node) return node;

        return parent[node] = getParent(parent[node]);
    }

    static void union(int from, int to){
        int parentFrom = parent[from];
        int parentTo = parent[to];

        if(parentFrom != parentTo)
            parent[parentFrom] = parentTo;
    }
}
