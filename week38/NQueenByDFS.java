package week38;

public class NQueenByDFS {
    static int answer;
    static int[] chess;

    public int solution(int n) {
        /*
         * row, col
         * 위에서부터 1row에 col(1,2,3,4) 배치 후 각 row에 배치하면서 가능한 경우의 수 확인
         */
        chess = new int[n];
        dfs(0, n);

        return answer;
    }

    /*
     * row 0 1 2 3
     * = 1번째 row에 몇번째 col에 저장할 것인가.
     */
    static void dfs(int row, int n){

        if(row == n){
            answer++;
            return;
        }

        for(int col = 0 ; col < n ; col++){
            if(isOK(row, col)){
                chess[row] = col; //col에 위치시킨다.
                dfs(row + 1, n); //다음 row
            }
        }
    }

    /*
     * 가로, 세로, 대각선
     * 내가 놓은 말의 위치가 row, col이며 이것이 가능한가가 관건.
     */
    static boolean isOK(int row, int col){
        for(int i = 0 ; i < row ; i++){
            if(chess[i] == col) return false;
            if(Math.abs(col - chess[i]) == Math.abs(row - i)) return false;
        }

        return true;
    }
}
