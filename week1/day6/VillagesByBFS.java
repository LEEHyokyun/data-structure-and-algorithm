package week1.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VillagesByBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //for BFS
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        //단지별 집의 개수
        List<Integer> houseCounts = new ArrayList<>();

        //map 초기화
        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < N ; j++){
                //char -> int
                map[i][j] = line.charAt(j) - '0';
            }
        }

        //BFS 시작
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && visited[i][j] == false){
                    //방문하지 않은 곳이면서 집이 있다면 단지의 시작점 = BFS의 시작점
                    int cnt = BFS(map, visited, i, j, N); //현재 위치를 시작점으로 하여 2차원 BFS
                    houseCounts.add(cnt);
                }
            }
        }

        houseCounts.sort(Comparator.naturalOrder());
        //or : Collections.sort(houseCounts);

        System.out.println(houseCounts.size());
        for(int cnt : houseCounts){
            System.out.println(cnt);
        }
    }

    public static int BFS(int[][] map, boolean[][] visited, int x, int y, int N){
        //한 단지 = 연결된 집들의 개수 = 서로 인접한 노드들의 집합
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y}); //시작점(={x,y} = 배열)
        visited[x][y] = true;

        int count = 1;

        //2차원 배열에서의 인접노드 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] cur = q.poll(); //시작점
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                //반복문을 순회하기때문에 현재 위치에서 4방향으로 인접노드를 모두 탐색 보장한다.
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                //기저조건
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                //이동했는데 집이 있는 상태이고 방문하지 않은 곳
                if(map[nx][ny] == 1 && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                    count++;
                }
            }
        }

        return count;
    }
}
