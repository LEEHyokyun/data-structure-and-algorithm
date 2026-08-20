package week34;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dron_with_BFS_afterRefactoring_while_continue_현재는_분기가_여러개이므로_continue_사용불가_드론의_기준좌표_및_회전시_기준좌표의_이동이_쟁점 {
    /*
     * 상태 단순화 : dir을 0/1로 둔다.
     * - 어차피 회전을 한 이후의 가로 모양은 반드시 x,y + x,y+1 (가로방향으로 누울때)
     * - 어차피 회전을 한 이후의 세로 모양은 반드시 x,y + x+1,y (세로방향으로 누울때)
     * - 방향에 관계없이 회전 후 모양은 일정하며, 가로회전을 0, 세로 회전을 1이라 가정한다.
     */
    static class Dron{
        int x;
        int y ;
        int dir; //현재 드론 방향
        int time;

        public Dron(int x, int y, int dir, int time){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
        }
    }

    static int N;
    static boolean[][][] visited; //기준 몸통 좌표 및 드론의 방향을 기준으로 하여 방문여부 판단

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N][2];

        return bfs(board);
    }

    static int bfs(int[][] board){

        Queue<Dron> q = new ArrayDeque<>();
        q.offer(new Dron(0,0,0,0));
        visited[0][0][0] = true;

        int answer = 0;

        while(!q.isEmpty()){

            Dron cur = q.poll();

            /*
             * 현재 드론 몸상태에 따라 x2/y2를 적절히 도출한다.
             */
            int x2 = cur.x;
            int y2 = cur.y;

            if(cur.dir == 0) {//현재 상태가 가로이다.
                y2++;
            }else {
                x2++;
            }

            //도착
            if((cur.x == N-1 && cur.y == N-1) || (x2 == N-1 && y2 == N-1)) return cur.time;

            //상하좌우
            for(int i = 0 ; i < 4 ; i++){

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                if(
                        nx >= 0 && ny >= 0 && nx2 >= 0 && ny2 >= 0 &&
                                nx < N && ny < N && nx2 < N && ny2 < N
                ){
                    //같은 위치에서 같은 방향의 상태가 중복되면 이미 도달한 상태이므로 continue
                    if(!visited[nx][ny][cur.dir] && board[nx][ny] == 0 && board[nx2][ny2] == 0){
                        visited[nx][ny][cur.dir] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        cur.dir,
                                        cur.time + 1
                                )
                        );
                    }
                }
            }
            /*
             * continue -> 해당 회전을 못하는 것일뿐, 다른 회전 분기도 모두 봐야한다.
             * nx,ny는 현재 좌표에서 왼쪽 혹은 위쪽에 있는 좌표
             */
            //회전
            if(cur.dir == 0) {
                /*
                 * 현재 가로 -> 이후 세로
                 * 위쪽 혹은 아래쪽 방향으로 회전
                 */
                //A축 기준 위쪽 회전
                if(cur.x-1 >= 0 && cur.y+1 <= N-1 && board[cur.x-1][cur.y] == 0 && board[cur.x-1][cur.y+1] == 0){
                    int nx = cur.x-1;
                    int ny = cur.y;

                    if(!visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        1,
                                        cur.time + 1
                                )
                        );
                    }
                }
                //A축 기준 아래쪽 회전
                if(cur.x+1 <= N-1 && cur.y+1 <= N-1 && board[cur.x+1][cur.y] == 0 && board[cur.x+1][cur.y+1] == 0){
                    int nx = cur.x;
                    int ny = cur.y;

                    if(!visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        1,
                                        cur.time + 1
                                )
                        );
                    }
                }

                //B축 기준 위쪽 회전(*이동 / 이동 중 훑는 점)
                if(cur.x-1 >= 0 && cur.y+1 <= N-1 && board[cur.x-1][cur.y] == 0 && board[cur.x-1][cur.y+1] == 0){
                    int nx = cur.x-1;
                    int ny = cur.y+1;

                    if(!visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        1,
                                        cur.time + 1
                                )
                        );
                    }
                }
                //B축 기준 아래쪽 회전(*이동 / 이동 중 훑는 점)
                if(cur.x+1 <= N-1  && cur.y+1 <= N+1 && board[cur.x+1][cur.y] == 0 && board[cur.x+1][cur.y+1] == 0){
                    int nx = cur.x;
                    int ny = cur.y+1;

                    if(!visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        1,
                                        cur.time + 1
                                )
                        );
                    }
                }
            }else {
                /*
                 * 현재 세로 -> 이후 가로
                 * 위쪽 혹은 아래쪽 방향으로 회전
                 */
                //A축 기준 오른쪽 회전(*이동 / 이동 중 훑는 점)
                if(cur.y+1 <= N-1 && cur.x+1 <= N+1 && board[cur.x][cur.y+1] == 0 && board[cur.x+1][cur.y+1] == 0){
                    int nx = cur.x;
                    int ny = cur.y;

                    if(!visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        0,
                                        cur.time + 1
                                )
                        );
                    }
                }
                //A축 기준 왼쪽 회전(*이동 / 이동 중 훑는 점)
                if(cur.y-1 >= 0 && cur.x+1 <= N-1 && board[cur.x][cur.y-1] == 0 && board[cur.x+1][cur.y-1] == 0){
                    int nx = cur.x;
                    int ny = cur.y-1;

                    if(!visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        0,
                                        cur.time + 1
                                )
                        );
                    }
                }

                //B축 기준 오른쪽 회전(*이동 / 이동 중 훑는 점)
                if(cur.y+1 <= N-1 && cur.x+1 <= N-1 && board[cur.x][cur.y+1] == 0 && board[cur.x+1][cur.y+1] == 0){
                    int nx = cur.x+1;
                    int ny = cur.y;

                    if(!visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        0,
                                        cur.time + 1
                                )
                        );
                    }
                }
                //B축 기준 왼쪽 회전(*이동 / 이동 중 훑는 점)
                if(cur.y-1 >= 0 && cur.x+1 <= N+1 && board[cur.x][cur.y-1] == 0 && board[cur.x+1][cur.y-1] == 0){
                    int nx = cur.x+1;
                    int ny = cur.y-1;

                    if(!visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        q.offer(
                                new Dron(
                                        nx,
                                        ny,
                                        0,
                                        cur.time + 1
                                )
                        );
                    }
                }
            }
        }

        return -1;
    }
}
