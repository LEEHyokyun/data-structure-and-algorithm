package week28;

import java.util.ArrayDeque;
import java.util.Queue;

public class The_number_of_shortest_pathes_dp_and_bfs {
    static boolean[][] visited;
    static int[][] graph;
    static int[][] count;

    public int solution(int m, int n, int[][] puddles) {
        //배열 상 n * m
        //가장 왼쪽 위 = 좌표 상 1,1
        //오른쪽 아래 = 좌표 상 m,n

        visited = new boolean[n][m];
        graph = new int[n][m];
        count = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                graph[i][j] = 1;
            }
        }

        for(int i = 0 ; i < puddles.length ; i++){
            int x = puddles[i][1] - 1; //여기 좌표랑 배열상 좌표가 다르다.
            int y = puddles[i][0] - 1;

            graph[x][y] = 0;
        }

        int[] start = new int[]{0,0};
        return bfs(graph, start, n, m);

    }

    //도착지점 : n -1 , m -1(배열상)
    static int bfs(int[][] graph, int[] start, int row, int col){

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            //오른쪽(curCol+1) / 아래쪽(curRow+1)
            int[] adj1 = new int[]{curRow, curCol + 1};
            int[] adj2 = new int[]{curRow + 1, curCol};

            /*
             * 거길 갈 수 있으면 누적한다.
             */

            if(curRow + 1 < row && graph[curRow + 1][curCol] != 0){
                q.offer(adj2);
                //visited[curRow + 1][curCol] = true;
                count[curRow + 1][curCol]++;
            }

            if(curCol + 1 < col && graph[curRow][curCol + 1] != 0){
                q.offer(adj1);
                //visited[curRow][curCol + 1] = true;
                count[curRow][curCol + 1]++;
            }


        }

        return count[row-1][col-1] % 1000000007;
    }
}
