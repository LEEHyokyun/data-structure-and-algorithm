package week27;

import java.util.Arrays;

public class Kruskal_find_and_kruskal {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        //건설비용 cost = (n-1) * n / 2
        //모든 정점에 대해 가중치의 합이 최소가 되는
        //MST - 크루스칼

        parent = new int[n];

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        //비용 기준 오름차순 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int answer = 0;
        int edgeCount = 0;

        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            //부모가 다를때 연결(*크루스칼 핵심 : getParent / union)
            if(getParent(from) != getParent(to)){

                union(from, to);

                answer += weight;
                edgeCount++;

                //없어도 됨
                //if(edgeCount == n-1) break;

            }
        }

        return answer;
    }

    //교집합 갱신
    static int getParent(int node){

        if(parent[node] == node) return node; //자기 자신

        return parent[node] = getParent(parent[node]); //다르다면 조상 찾기 + 이어지는 node마다 조상을 모두 갱신한다

    }

    //서로 다른 두 영역 통합
    static void union(int from, int to){
        int parentOfFrom = getParent(from);
        int parentOfTo = getParent(to);

        //통합 시 대표자끼리 연결
        if(parentOfFrom != parentOfTo) parent[parentOfFrom] = parentOfTo;
    }
}
