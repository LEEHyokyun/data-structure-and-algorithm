package week9.day2;

public class TheMostSumThroughGroundsMaticesDFS {
    static int answer = 0;

    int solution(int[][] land) {
        dfs(land, 0, -1, 0);
        return answer;
    }

    static void dfs(int[][] land, int row, int prevCol, int sum){

        if(row == land.length){
            answer = Math.max(answer, sum);
            return;
        }

        for(int col = 0 ; col < 4 ; col++){
            if(col == prevCol) continue;
            sum += land[row][col];
            dfs(land, row + 1, col, sum);
            sum -= land[row][col];
        }
    }
}
