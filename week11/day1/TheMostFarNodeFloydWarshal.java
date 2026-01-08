package week11.day1;

public class TheMostFarNodeFloydWarshal {
    public int solution(int n, int[][] edge) {

        //paths init , 무조건 2차원 .. start가 각기 다름
        int[][] paths = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i == j) paths[i][j] = 0;
                else paths[i][j] = 100000;
            }
        }

        //init
        for(int i = 0 ; i < edge.length ; i++){
            int u = edge[i][0];
            int v = edge[i][1];

            paths[u][v] = 1;
            paths[v][u] = 1;
        }

        //fw for paths
        //2,3 -> INF
        //2,4 + 4,3 -> 2
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(paths[i][j] > paths[i][k] + paths[k][j]){
                        paths[i][j] = paths[i][k] + paths[k][j];
                    }
                }
            }
        }

        //k = 1
        int count = 0;
        int max = 0;
        for(int i = 2 ; i <= n ; i++){
            if(paths[1][i] == max) count++;
            if(paths[1][i] > max) {
                count = 1;
                max = paths[1][i];
            }
        }

        return count;
    }
}
