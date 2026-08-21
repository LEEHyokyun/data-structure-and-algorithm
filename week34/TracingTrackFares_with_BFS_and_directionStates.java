package week34;

import java.util.ArrayDeque;
import java.util.Queue;

public class TracingTrackFares_with_BFS_and_directionStates {
    static class Car{

        int x;
        int y;
        int dir; //0 : 가로방향(y방향) 1 : 세로방향(x방향)
        int fare;

        public Car(int x, int y, int dir, int fare){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.fare = fare;
        }

    }

    static Car[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][] visited;

    public int solution(int[][] board) {
        /*
         * N*N 크기의 정사각형 격자, 0은 갈 수 있고 1은 벽
         * 0,0 -> N-1,N-1로 가는 최단 경로와 그 경로에서의 비용
         * 직선도로 100원 꺾인 도로 500원
         */
        int size = board.length;
        visited = new boolean[size][size][2];
        graph = new Car[size][size];

        return bfs(new Car(0,0,0,0), size, board);
    }

    static int bfs(Car start, int size, int[][] board){

        Queue<Car> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.x][start.y][0] = true;
        visited[start.x][start.y][1] = true;

        int answer = Integer.MAX_VALUE;

        while(!q.isEmpty()){

            Car cur = q.poll();

            if(cur.x == size - 1 && cur.y == size - 1) {
                System.out.println("도착");
                answer = Math.min(answer, cur.fare);
                //break;
            }

            for(int i = 0 ; i < 4 ; i++){

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];


                if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                if(board[nx][ny] == 1) continue;

                //최초 이동은 무조건 직선 비용
                if(cur.x == 0 && cur.y == 0){
                    System.out.println("현재는 출발점입니다. 방향에 상관이 없습니다");
                    System.out.println("다음 좌표 : " + nx + ", " + ny);

                    if(nx == cur.x) {
                        System.out.println("y방향(가로) 이동 : 100원 추가");
                        q.offer(new Car(nx, ny, 0, cur.fare + 100)); //y방향이동
                        visited[nx][ny][0] = true;
                    }
                    if(ny == cur.y) {
                        System.out.println("x방향(세로) 이동 : 100원 추가");
                        q.offer(new Car(nx, ny, 1, cur.fare + 100)); //x방향이동
                        visited[nx][ny][1] = true;
                    }
                    continue;
                }

                //y방향 이동인데 방향 그대로
                if(nx == cur.x && ny != cur.y && cur.dir == 0 && !visited[nx][ny][0]){
                    System.out.println("현재 : " + cur.x + ", " + cur.y);
                    System.out.println("[y방향 이동인데 방향 그대로/100원 추가]다음 좌표 : " + nx + ", " + ny);
                    visited[nx][ny][0] = true;
                    q.offer(new Car(nx, ny, 0, cur.fare + 100));
                }
                //y방향 이동인데 방향 전환
                else if(nx == cur.x && ny != cur.y && cur.dir == 1 && !visited[nx][ny][0]){
                    System.out.println("현재 : " + cur.x + ", " + cur.y);
                    System.out.println("[y방향 이동인데 방향 전환/600원 추가]다음 좌표 : " + nx + ", " + ny);
                    visited[nx][ny][0] = true;
                    q.offer(new Car(nx, ny, 0, cur.fare + 600));
                }
                //x방향 이동인데 방향 그대로
                else if(ny == cur.y && nx != cur.x && cur.dir == 1 && !visited[nx][ny][1]){
                    System.out.println("현재 : " + cur.x + ", " + cur.y);
                    System.out.println("[x방향 이동인데 방향 그대로/100원 추가]다음 좌표 : " + nx + ", " + ny);
                    visited[nx][ny][1] = true;
                    q.offer(new Car(nx, ny, 1, cur.fare + 100));
                }
                //x방향 이동인데 방향 전환
                else if(ny == cur.y && nx != cur.x && cur.dir == 0 && !visited[nx][ny][1]){
                    System.out.println("현재 : " + cur.x + ", " + cur.y);
                    System.out.println("[x방향 이동인데 방향 전환/600원 추가]다음 좌표 : " + nx + ", " + ny);
                    visited[nx][ny][1] = true;
                    q.offer(new Car(nx, ny, 1, cur.fare + 600));
                }
            }
        }

        return answer;
    }
}
