package week6.day2;

public class DFSForChess {
    static int N;
    static int[] cols;
    static int count = 0 ;

    public int solution(int n) {

        N = n;
        cols = new int[n];
        dfs(0); //starting row 0

        return count;
    }

    static void dfs(int row){
        if(row == N){
            //이상없이 dfs -> 충돌없이 dfs -> count++
            count++;
            return;
        }

        for(int col = 0 ; col < N ; col++){
            if(isOK(row, col)){
                cols[row] = col;  //row 0 -> 해당 위치로 가정(놓고, dfs)
                dfs(row + 1);    //dfs : row + 1

                /*
                 * row = 0
                 *   col = 0  -> dfs(1)  -> col = 2
                 *                              -> dfs(2)  -> col = 0 ~ N-1 (위치 하고 그 이후에 row + 1...)
                 *                                   ...
                 *                       -> col = 3
                 *   col = 1  -> ...
                 */
            }
        }
    }

    static boolean isOK(int row, int col){
        //이 위치가 가능한가?
        for(int i = 0 ; i < row ; i++){
            if(cols[i] == col) return false; //열 동일 존재
            if(Math.abs(col - cols[i]) == Math.abs(row - i)) return false; //동일 대각선 ( 행 offset = 열 offset)
        }

        return true;
    }
}
