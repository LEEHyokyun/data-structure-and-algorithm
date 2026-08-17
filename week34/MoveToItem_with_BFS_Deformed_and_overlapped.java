package week34;

import java.util.ArrayDeque;
import java.util.Queue;

public class MoveToItem_with_BFS_Deformed_and_overlapped {
    //static boolean[][] visited;
    //static int[][] graph;

    //static int[][] graph = new int[102][102];

    static boolean[][] border = new boolean[101][101]; // 1~100
    //static boolean[][] area = new boolean[101][101];
    static boolean[][] inside = new boolean[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        /*
         * 초기캐릭터위치 -> 아이템 위치로 가는데 필요한 최단 거리
         * 전형적인 BFS
         */
        /*
         * 그래프를 만들고 테두리를 만들었을때
         * 직사각형의 테두리로만 이동 가능하다.
         * 좌표 2배 = 기존 표현할 수 없었던 겹치는 부분을 정의할 수 있다(좌표체계를 2배로 해서 실수/소수부를 정수부로 표현 가능하다).
         * 즉, 사각형 길이가 길지 않아 테두리 길이가 0.5 등으로 표현된다면 *2배해서 바로 해결 가능.
         */
        characterX = characterX * 2;
        characterY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;


//         for(int[] r : rectangle){

//             int x1 = r[0] * 2;
//             int y1 = r[1] * 2;
//             int x2 = r[2] * 2;
//             int y2 = r[3] * 2;

//             for(int x = x1 ; x <= x2 ; x++){
//                 for(int y = y1 ; y <= y2 ; y++){
//                     //graph[x][y] = 1;
//                     area[x][y] = true;
//                 }
//             }
//         }

        //테두리
        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for(int x = x1 ; x <= x2 ; x++){
                //graph[x][y] = 1;
                border[x][y1] = true;
                border[x][y2] = true;
            }

            for(int y = y1 ; y <= y2 ; y++){
                //graph[x][y] = 1;
                border[x1][y] = true;
                border[x2][y] = true;
            }
        }

        for(int[] r : rectangle){

            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            //사각형이 겹칠때 변이 겹치지 않으므로
            for(int x = x1 + 1 ; x < x2 ; x++){
                for(int y = y1 + 1 ; y < y2 ; y++){
                    inside[x][y] = true;
                }
            }

        }

        //최종적으로 그 직사각형이 내부에 들어간 직사각형이라면 테두리에서 제외
        for(int[] r : rectangle){

            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            //사각형이 겹치면 테두리만 갈 수 있고 내부는 못간다
            for(int x = x1 ; x <= x2 ; x++){
                for(int y = y1 ; y <= y2 ; y++){
                    if(inside[x][y]) border[x][y] = false;
                }
            }

        }

        //BFS
        Queue<int[]> q = new ArrayDeque<>();

        int[][] distance = new int[101][101];
        boolean[][] visited = new boolean[101][101];

        q.offer(new int[]{characterX, characterY});
        distance[characterX][characterY] = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            if(x == itemX && y == itemY){
                return (distance[x][y]) / 2;
                //return (distance[x][y]);
            }

            for(int i = 0 ; i < 4 ; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                //좌표계 : 1 ~ 50
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if(visited[nx][ny]) continue;
                //if(graph[nx][ny] == 0) continue;
                if(!border[nx][ny]) continue;
                //if(!area[nx][ny]) continue;

                distance[nx][ny] = distance[x][y] + 1;

                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;

            }

        }

        return -1;
    }
}
