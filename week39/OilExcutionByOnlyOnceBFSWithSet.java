package week39;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class OilExcutionByOnlyOnceBFSWithSet {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(int[][] land) {
        /*
         * 세로 n 가로 m(n*m)
         * 시추관을 단 하나만 뚫을 수 있고, 가장 많은 석유 영역을 뽑을 수 있는 연속 구간 중 하나에.
         */

        /*
         * 한번 훑고 지나가면서 닿는 영역에 대해 bfs를 진행하고 그 영역 수를 모두 합하고, 이 중 최대.
         */
        int depth = land.length;
        int range = land[0].length;

        graph = new int[depth][];
        visited = new boolean[depth][land[0].length];

        for(int i = 0 ; i < depth ; i++){
            graph[i] = land[i];
        }

        int[] amounts = new int[range];
        for(int i = 0 ; i < depth ; i++) {
            /*
             * 열마다 반복 탐색이 아니라 아예 최초 한번 순회로 끝내는 방법
             */
            for(int j = 0 ; j < range ; j++){
                if(graph[i][j] == 0 || visited[i][j]) continue;
                bfs(i, j, amounts);
            }
//             int amount = 0;
//             visited = new boolean[depth][range];

//             for(int j = 0 ; j < depth ; j++){
//                 if(visited[j][i]) continue;
//                 if(graph[j][i] == 0) continue;
//                 amount += bfs(j, i, range, depth);
//             }

            //answer = Math.max(answer, amount);
        }

        int answer = 0;
        for(int amount : amounts) answer = Math.max(answer, amount);

        return answer;
    }

    static void bfs(int x, int y, int[] amounts){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{x,y});
        visited[x][y] = true;

        int count = 1;

        //**덩어리를 계산하면서 해당 덩어리의 "열" 정보 기록
        Set<Integer> set = new HashSet<>();
        set.add(y);

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) continue;
                if(visited[nx][ny] || graph[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;

                count++;
                set.add(ny); //열 정보 갱신
            }
        }

        /*
         * bfs 종료 = 현재 지점에서 연결된 모든 석유의 양
         * = 결국 나중에 해당 열을 뚫으면 해당 영역은 계산이 될텐데, 지금 미리 계산하자는 것.
         * = 해당 열 정보에 대해 현재 누적된 석유의 양을 count 시킨다.
         */

        for(int val : set){
            amounts[val] += count;
        }
    }

//     static int bfs(int depth, int range, int maxRange, int maxDepth){

//         Queue<int[]> q = new ArrayDeque<>();

//         q.offer(new int[]{depth, range});
//         visited[depth][range] = true;

//         int count = 1;

//         while(!q.isEmpty()){
//             int[] cur = q.poll();
//             int cx = cur[0];
//             int cy = cur[1];

//             for(int i = 0 ; i < 4 ; i++){
//                 int nx = cx + dx[i];
//                 int ny = cy + dy[i];

//                 if(nx < 0 || ny < 0 || nx >= maxDepth || ny >= maxRange) continue;
//                 if(visited[nx][ny]) continue;
//                 if(graph[nx][ny] == 0) continue;

//                 q.offer(new int[]{nx, ny});
//                 visited[nx][ny] = true;
//                 count++;
//             }
//         }

//         return count;
//     }
}
