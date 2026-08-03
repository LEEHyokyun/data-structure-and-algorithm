package week32;

import java.util.Arrays;

public class MST_with_Kruskal {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0 ; i < n; i++) parent[i] = i;

        int answer = 0;

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for(int[] cost : costs){

            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

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

        int parentFrom = parent[from];
        int parentTo = parent[to];

        if(parentFrom != parentTo)
            parent[parentFrom] = parentTo;

    }
}
