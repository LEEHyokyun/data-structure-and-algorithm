package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NMPickingSerialNumbers {
    static int[] list;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1부터 N까지 수 중 M개의 고른 "수열"(동일 선택 가능, 오름차순)
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = i+1;
        }

        int[] answer = new int[N];
        dfs(0, 0, "");
    }

    static void dfs(int idx, int selected, String values){

        if(selected == M){
            System.out.print(values);
            System.out.println();
            return;
        }

        for(int i = idx ; i < N ; i++){
            dfs(i, selected + 1, values + list[i] + " ");
        }
    }
}
