package week34;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dron_with_BFS_beforeRefactoring_일반적인_BFS_회전고려하지_않은경우 {
    static class Dron{

        int x1;
        int y1;
        int x2;
        int y2;

        public Dron(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

    }

    static boolean[][] visited;
    /*
     * 아래 - 위 - 오른쪽 - 왼쪽
     * 왼쪽 축 기준 회전 : x1/y1는 그대로 x2/y2만 1/-1
     * 오른쪽 축 기준 회전 : x2/y2는 그대로 x1/y1만 1/-1
     */
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] rx = {1,-1,1,-1};
    static int[] ry = {1,1,-1,-1};

    public int solution(int[][] board) {

        visited = new boolean[board.length][board.length];

        /*
         * 로봇은 2*1 크기
         * 왼쪽 상단 -> 1,1(0:0) => N,N(N-1:N-1) 으로 이동(*어느 한 쪽이라도 도착)
         * 가로이동 -> y + 1 , 세로이동 -> x + 1
         * 회전 가능(x,y + x,y+1 -> x+1,y + x,y+1) 단, 장애물이 없는 경우에만
         * 0이 갈 수 있고 1은 갈 수 없음
         */
        return bfs(new Dron(0,0,0,1), board, board.length);
    }

    static int bfs(Dron curDron, int[][] board, int N){

        Queue<Dron> q = new ArrayDeque<>();
        q.offer(curDron);
        visited[curDron.x1][curDron.y1] = true;

        int answer = 0;

        while(!q.isEmpty()){

            Dron cur = q.poll();

            if((cur.x1 == N-1 && cur.y1 == N-1) || (cur.x2 == N-1 && cur.y2 == N-1)) break;

            int beforeX1 = cur.x1;
            int beforeY1 = cur.y1;
            int beforeX2 = cur.x2;
            int beforeY2 = cur.y2;

            //위아래좌우
            for(int i = 0 ; i < 4 ; i++){

                int afterX1 = beforeX1 + dx[i];
                int afterY1 = beforeY1 + dy[i];
                int afterX2 = beforeX2 + dx[i];
                int afterY2 = beforeY2 + dy[i];

                if(
                        afterX1 < 0 || afterY1 < 0 || afterX2 < 0 || afterY2 < 0 ||
                                afterX1 > N-1 || afterY1 > N-1 || afterX2 > N-1 || afterY2 > N-1
                ) continue;
                if(board[afterX1][afterY1] == 1 || board[afterX2][afterY2] == 1) continue;
                if(visited[afterX1][afterY1]) continue;

                q.offer(new Dron(afterX1, afterY1, afterX2, afterY2));
                visited[afterX1][afterY1] = true;
            }

            //오른쪽 축 기준 회전
            for(int i = 0 ; i < 2 ; i++){
                int afterX1 = beforeX1 + rx[i];
                int afterY1 = beforeY1 + ry[i];

                if(
                        afterX1 < 0 || afterY1 < 0 || afterX1 > N-1 || afterY1 > N-1 || afterY1 - 1 < 0
                ) continue;
                if(board[afterX1][afterY1-1] == 1) continue; //회전 중 걸리는 영역
                if(board[afterX1][afterY1] == 1) continue;
                if(visited[afterX1][afterY1] && visited[beforeX2][beforeY2]) continue;

                q.offer(new Dron(afterX1, afterY1, beforeX2, beforeY2));
                visited[afterX1][afterY1] = true;
            }

            //왼쪽 축 기준 회전
            for(int i = 2 ; i < 4 ; i++){
                int afterX2 = beforeX2 + rx[i];
                int afterY2 = beforeY2 + ry[i];;

                if(
                        afterX2 < 0 || afterY2 < 0 || afterX2 > N-1 || afterY2 > N-1 || afterY2 - 1 < 0
                ) continue;
                if(board[afterX2][afterY2-1] == 1) continue; //회전 중 걸리는 영역
                if(board[afterX2][afterY2] == 1) continue;
                if(visited[beforeX1][beforeY1] && visited[afterX2][afterY2]) continue;

                q.offer(new Dron(beforeX1, beforeY1, afterX2, afterY2));
                visited[afterX2][afterY2] = true;
            }

            answer++;

        }

        return answer;
    }
}
