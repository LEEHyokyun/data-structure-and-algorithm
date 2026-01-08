package week11.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinsCombinationDFS {
    static int[] used;
    static int[] list;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        list = new int[N];
        used = new int[N];

        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int result = dfs(K, 0, 0);
        System.out.println(result);
    }

    static int dfs(int K, int sum, int start){

        if(sum == K){
            count++;
            return 1;
        }

        if(sum > K){
            return 0;
        }

        int count = 0;
        for(int i = start ; i < list.length ; i++){
            count += dfs(K, sum + list[i], i);
        }

        return count;
    }
}
