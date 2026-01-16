package week12.day6;

import java.util.ArrayDeque;
import java.util.Queue;

public class CovidFarDIstanceConditionalBFS {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int[] solution(String[][] places) {

        //대기실 5개, 5x5
        //최소 경로가 2이하 X (>2 or >=3)
        //중간 파티션 OK
        //응시자 P 빈 테이블 O 파티션 X
        //거리두기 판별 영역 = places의 행 정보.
        int[] answer = new int[5];

        //String[i] -> answer[i]
        for(int i = 0 ; i < 5 ; i++){
            answer[i] = check(places[i]) ? 1 : 0;
        }

        return answer;
    }

    static boolean check(String[] place){
        char[][] map = new char[5][5];

        for(int i = 0 ; i < 5 ; i++){
            map[i] = place[i].toCharArray();
        }

        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(map[i][j] == 'P'){
                    //P를 시작점으로 하는 BFS
                    //P기준 bfs하여 거리 및 파티션 여부 확인
                    if(!bfs(map, i, j)) return false;
                }
            }
        }

        return true;
    }

    static boolean bfs(char[][] map, int i , int j){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];

        q.offer(new int[]{i,j,0});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];

            if(cd >= 3) continue;

            for(int k = 0 ; k < 4 ; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                int nd = cd + 1;

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(visited[nx][ny] || map[nx][ny] == 'X') continue;

                if(map[nx][ny] == 'P') return false;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, nd + 1});

            }
        }

        return true;
    }
}
