package week31;

import java.util.Arrays;

public class MST_with_Kruskal {
    //MST .. 크루스칼
    static int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int answer = 0;
        for(int[] cost : costs){

            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            //현재까지 알려진 최소한의 비용을 기준으로 부모가 다르다면 잇는다.
            if(getParent(from) != getParent(to)){
                union(from, to);

                answer += weight;
            }

        }

        return answer;
    }

    //부모 일치화 : node의 parent, 부모의 부모를 현재 node의 부모와 일치화한다.
    static int getParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = getParent(parent[node]);
    }

    //부모가 다를 경우 통합한다.
    static void union(int from, int to){

        int parentFrom = getParent(from);
        int parentTo = getParent(to);

        if(parentFrom != parentTo)
            parent[parentFrom] = parentTo;
    }
}
