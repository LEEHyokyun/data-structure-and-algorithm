package week10.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Chickens {
    static int N, M;
    static List<int[]> chickens;
    static List<int[]> homes;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token1.nextToken());
        M = Integer.parseInt(token1.nextToken()); //치킨집 수

        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                int X = Integer.parseInt(token.nextToken());
                if(X == 2) chickens.add(new int[]{i,j});
                if(X == 1) homes.add(new int[]{i,j});
            }
        }

        selected = new boolean[chickens.size()];

        //모든 경우의 수, dfs
        System.out.println(dfs(0,0));
    }

    static int dfs(int start, int count){

        if(count == M){
            int distance = getDistance();
            answer = Math.min(answer, distance);
        }

        //치킨집 조합에 대한 dfs
        //dfs의 핵심은 시작점의 조정
        for(int i = start ; i < chickens.size() ; i++){
            selected[i] = true;
            dfs(i+1, count+1);
            selected[i] = false;
        }

        return answer;
    }

    static int getDistance(){

        int result = 0;

        for(int[] home : homes){
            int[] h = home;
            int minDistance = Integer.MAX_VALUE;

            for(int i = 0 ; i < chickens.size() ; i++){
                if(selected[i]){
                    int[] c = chickens.get(i);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minDistance = Math.min(minDistance, dist);
                }else{
                    continue;
                }
            }

            result += minDistance;
        }

        return result;
    }
}
