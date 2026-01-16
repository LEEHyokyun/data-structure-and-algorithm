package week12.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AvoidToBeMonitoredByTeachersDFSWithBFS {
    static int N;
    static char[][] graph;
    static String answer = "NO";
    static List<int[]> blanks = new ArrayList<>();
    static List<int[]> teachers = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                char c = token.nextToken().charAt(0);
                graph[i][j] = c;

                if(c == 'X') blanks.add(new int[]{i,j});
                if(c == 'T') teachers.add(new int[]{i,j});
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int index, int count){
        if(count == 3){
            if(isPossible()){   //조건 만족한 상태에서 판단
                answer = "YES";
            }

            return;
        }

        //2차원 배열 전체를 도는게 아니라, list를 활용하여 배치 가능한 경우의 수에 대해 1차원 DFS 진행.
        //dfs를 2차원화 하지말고, 순회를 1차원화 하는 방법을 고민
        //arrayList 활용
        for(int i = index ; i < blanks.size() ; i++){
            int[] cur = blanks.get(i);

            graph[cur[0]][cur[1]] = 'O';
            dfs(i+1, count+1);
            graph[cur[0]][cur[1]] = 'X';
        }
    }

    static boolean isPossible(){
        for(int i = 0 ; i < teachers.size() ; i++){
            int[] cur = teachers.get(i);

            int x = cur[0];
            int y = cur[1];

            //BFS
            for(int j = 0 ; j < 4 ; j++){
                //dx -> 끝까지, //dy -> 끝까지
                int curx = x;
                int cury = y;
                while(true){
                    curx = curx + dx[j];
                    cury = cury + dy[j];

                    if(curx < 0 || cury < 0 || curx >= N || cury >= N) break;
                    if(graph[curx][cury] == 'O') break; //OK
                    if(graph[curx][cury] == 'S') return false;
                }
            }
        }

        return true;
    }
}
