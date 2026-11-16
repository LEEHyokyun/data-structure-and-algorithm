package week38;

import java.util.ArrayDeque;
import java.util.Queue;

public class 맨해튼거리지키기ByBFS {
    static char[][] graph;
    static int row = 5;
    static int col = 5;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int[] solution(String[][] places) {

        /*
         * 맨해튼거리 2이하로 앉으면 안된다.
         * - 파티션(X)으로 막혀 있을 경우 허용
         * - 응시자(P)와 응시자 간 연속(빈 테이플, O)이면서 거리가 2 이하일 경우 불가
         *  - T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2|
         */

        int[] answer = new int[5];

        for(int i = 0 ; i < 5 ; i++){

            answer[i] = getResult(places[i]);

        }

        return answer;
    }

    static int getResult(String[] graphInput){

        graph = new char[5][5];

        for(int i = 0 ; i < 5 ; i++){
            graph[i] = graphInput[i].toCharArray();
        }

        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(graph[i][j] == 'P'){
                    if(!bfs(graph, i, j)) return 0;
                }
            }
        }

        return 1;
    }

    static boolean bfs(char[][] graph, int startX, int startY){

        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();

        //bfs를 탐색하면서 맨해튼 거리를 계산한다.
        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while(!q.isEmpty()){

            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];

            /*
             * 이러면 첫 시작점이 P일때 모두 걸림
             */
            // if(graph[cx][cy] == 'P') {
            //     if(cd <= 2) return false;
            // }

            for(int i = 0 ; i < 4 ; i++){

                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == 'X') continue;

                /*
                 * 칸막이 건너뜀 -> bfs 안함 -> 자동 필터링
                 */

                if(graph[nx][ny] == 'P' && nd <= 2) return false;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, nd});
            }

        }

        return true;
    }
}
