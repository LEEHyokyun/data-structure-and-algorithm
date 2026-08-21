package week34;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TrackingTrackFares_with_dijkstra_and_PriorityQueue {
    static class Car{

        int x;
        int y;
        int dir; //0 : 가로방향, 1 : 세로방향
        int fare;

        public Car(int x, int y, int dir, int fare){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.fare = fare;
        }

    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int INF = Integer.MAX_VALUE;

    /*
     * 방향에 따른 상태관리와 비용관리가 동시에 이루어져야 한다.
     */

    public int solution(int[][] board) {

        int size = board.length;

        return dijkstra(board, size);
        //return 1;
    }

    static int dijkstra(int[][] board, int size){

        int[][][] cost = new int[size][size][2];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                Arrays.fill(cost[i][j], INF);
            }
        }

        //다음 인접노드로 갈때 가중치가 작은 노드를 선택해서 인접노드로 가는 다익스트라 선택을 해야한다.
        PriorityQueue<Car> pq = new PriorityQueue<>((a, b) -> a.fare - b.fare);

        //시작점 : 방향 상관없다.
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;

        pq.offer(new Car(0,0,0,0));
        pq.offer(new Car(0,0,1,0));

        while(!pq.isEmpty()){

            /*
             * 인접노드로 왔는데 그 비용이 이미 와서 계산한 cost 비용보다 많으면 그것은 최적의 경로가 아니므로 건너뛴다.
             */
            Car cur = pq.poll();

            /*
             * 다익스트라는 끝까지 순회해야 한다.
             */
            // if(cur.x == size - 1 && cur.y == size - 1) {
            //     answer = cur.fare;
            // }
            if(cur.fare > cost[cur.x][cur.y][cur.dir]) continue;

            for(int i = 0 ; i < 4 ; i++){

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                if(board[nx][ny] == 1) continue;

                //다음 이동 방향은 좌표 이동 상황에 따라 가로 혹은 세로 방향 규정.
                int nextDir = -1;
                if(nx == cur.x) nextDir = 0;
                else if(ny == cur.y) nextDir = 1;

                //기본 직선 비용 + 방향 전환 시 500 추가 발생
                int nextFare = cur.fare + 100;
                if(cur.dir != nextDir) nextFare += 500;

                //다익스트라 비용 갱신
                if(nextFare < cost[nx][ny][nextDir]){
                    cost[nx][ny][nextDir] = nextFare;
                    pq.offer(new Car(nx, ny, nextDir, nextFare));
                }

            }

        }

        return Math.min(
                cost[size-1][size-1][0],
                cost[size-1][size-1][1]
        );
    }
}
