package week7.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueenBackTracking {
    static int N;
    static int[] col; //index = row
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];

        backTracking(0);

        System.out.println(count);
    }

    static void backTracking(int row){
        if(row == N){
            count++;
            return;
        }

        for(int i = 0 ; i < N ; i++){
            col[row] = i;    //index  = row, col = 0 ~ N-1
            if(isPossible(row)){
                backTracking(row + 1);
            }
        }
    }

    static boolean isPossible(int row){

        //if row = 0 -> 항상 참

        for(int i = 0 ; i < row ; i++){
            if(col[i] == col[row]) return false;
            if(Math.abs(col[row] - col[i]) == Math.abs(row - i)) return false;
        }

        return true;
    }
}
