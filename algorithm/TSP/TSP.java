package algorithm.TSP;

import java.util.Arrays;

public class TSP {
    int[][] costs = {
            {0, 2, 9, 0},
            {1, 0 ,6, 4},
            {0, 7, 0, 8},
            {6, 3, 0, 0}
    };

    /*
    * O번도시에서 출발하여 O번 도시로 가는 경로의 최소비용
    * 중간결과의 저장 = 특정 도시 -> O번 도시로 가는 비용의 반영
    */
    public int tsp(int city, int visited_cities){
        int[][] dpTable = new int[costs.length][(1 << costs.length) - 1];

        for(int[] row : dpTable){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        //모든 도시를 방문
        if(visited_cities == ((1 << costs.length) - 1)){
            return costs[city][0];
        }

        //계산 결과있을 경우 계산결과 그대로 반환
        if(dpTable[city][visited_cities] != Integer.MAX_VALUE){
            return dpTable[city][visited_cities];
        //계산 결과없을 경우 새로 계산
        }else{
            //모든 도시를 반복
            for(int i = 0 ; i < costs.length; i++){
                //방문하지 않았고 자기자신이 아닌 경우
                if((visited_cities & (1 << i)) == 0 && costs[city][i] != 0){
                    dpTable[city][visited_cities] = Math.min(dpTable[city][visited_cities], costs[city][i] + tsp(i, visited_cities | (1 << i)));
                }
            }

            return dpTable[city][visited_cities];
        }
    }
}

//dp(0, 1)