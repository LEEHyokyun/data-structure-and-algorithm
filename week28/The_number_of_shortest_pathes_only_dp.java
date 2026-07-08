package week28;

import java.util.ArrayDeque;
import java.util.Queue;

public class The_number_of_shortest_pathes_only_dp {
    static int[][] graph;

    public int solution(int m, int n, int[][] puddles) {
        //only dp : bfs 추가 시 시간복잡도에서 걸린다.
        //dp = dp 바로 위 + dp 왼쪽
        //n * m , 좌표 상 위치와 배열상 위치가 서로 반대
        int row = n;
        int col = m;

        int[][] dp = new int[row][col];
        int[][] graph = new int[row][col];

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                graph[i][j] = 1;
            }
        }

        for(int i = 0 ; i < puddles.length ; i++){
            int x = puddles[i][1] - 1;
            int y = puddles[i][0] - 1;

            graph[x][y] = 0;
        }

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(graph[i][j] == 0)
                    continue; //이게 반드시 선제 필터링 요건

                /*
                 * 무조건 i == 0 || j == 0일때 1이면 안됨, 그 행 또는 열에 물이 있을 수 있음.
                 * 조건에 따라 dp 점화식을 별도로 세우는 전략으로 접근 + only dp(bfs x)
                 */
                if(i == 0) {
                    if(j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j-1] % 1000000007;
                    continue;
                }

                if(j == 0){
                    if(i == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j] % 1000000007;
                    continue;
                }

                dp[i][j] = dp[i][j-1] % 1000000007 + dp[i-1][j] % 1000000007;
            }
        }

        return dp[row-1][col-1] % 1000000007;
    }
}
