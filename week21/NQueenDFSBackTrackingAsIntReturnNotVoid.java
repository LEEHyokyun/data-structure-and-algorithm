package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueenDFSBackTrackingAsIntReturnNotVoid {
    static int[] col;
    static int N;
    //static int count;

    public static void main(String[] args) throws IOException {
        //N*N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        //같은 열, 같은 대각선에 위치하면 안됨
        //index 행에 위치한 queen의 열 위치

        int count = dfs(0);

        System.out.println(count);
    }

    static int dfs(int row){

        if(row == N) {
            return 1;
        }

        int total = 0;

        //brute force
        for(int i = 0 ; i < N ; i++){
            col[row] = i; //idx - row , value - col
            if(isPossible(row)) total += dfs(row + 1);

            //불가능하면 col[row] 다음 열로
            //가능하면 그대로 dfs
        }

        return total;
    }

    static boolean isPossible(int row){
        for(int i = 0 ; i < row ; i++){
            if(col[i] == col[row]) return false;
            if(Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }

        return true;
    }
}
