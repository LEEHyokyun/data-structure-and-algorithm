package week28;

import java.util.Arrays;

public class MST_make_minimum_weights_union_and_find_Kruskal {
    static int[] parent;

    /*
     * 최소 비용으로 그래프 완성하기
     * = MST
     * = 크루스칼
     */

    public int solution(int n, int[][] costs) {
        parent = new int[n];

        //최초 각 노드의 부모는 자기 자신
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        //비용 기준 오름차순 정렬
        //다익스트라와 마찬가지로, 일단 최소 비용을 찾아서 해당 지점을 기준으로 잇는다.
        Arrays.sort(costs, (a, b) -> a[2]-b[2]);

        //교집합 갱신 / 도메인 통합(*union/find)
        int answer = 0;
        int edgeCount = 0;

        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            //from -> to union/find + weight.
            if(getParent(from) != getParent(to)){
                union(from, to);

                answer += weight;
                edgeCount++;
            }
        }

        return answer;
    }

    //find
    static int getParent(int node){
        if(parent[node] == node) return node;

        return parent[node] = getParent(parent[node]);
    }

    //union
    static void union(int from, int to){
        int parentOfFrom = getParent(from);
        int parentOfTo = getParent(to);

        if(parentOfFrom != parentOfTo) parent[parentOfFrom] = parentOfTo;
    }
}
