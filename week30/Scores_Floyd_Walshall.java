package week30;

public class Scores_Floyd_Walshall {
    /*
     * i > k & k > j 가 가능하다면 k의 순위 결정 가능
     * 플로이드 워셜
     * 전이관계의 확장
     */

    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];

        for(int[] result : results){

            int from = result[0];
            int to = result[1];

            win[from][to] = true;
        }

        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(win[i][k] && win[k][j]){
                        win[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        //int count = 0;

        for(int i = 1 ; i <= n ; i++){

            int count = 0;

            for(int j = 1 ; j <= n ; j++){
                if(i == j) continue;
                if(win[i][j] || win[j][i]) {
                    count++;
                    if(count == n - 1) answer++;
                }
            }
        }

        return answer;
    }
}
