package week39;

public class 순위_ByFloydWashall_3iterations {
    public int solution(int n, int[][] results) {
        /*
         * 전이 관계의 확장 = 플로이드 워셜(3중 반복)
         */
        boolean[][] win = new boolean[n+1][n+1];

        for(int[] result : results){
            int from = result[0];
            int to = result[1];

            win[from][to] = true;

        }

        //A > B, B > C = A > C
        for(int k = 1 ; k <= n ; k++){
            for(int j = 1 ; j <= n ; j++){
                for(int i = 1 ; i <= n ; i++){
                    if(win[j][k] && win[k][i]) win[j][i] = true;
                }
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= n ; i++){
            int count = 0;

            for(int j = 1 ; j <= n ; j++){
                if(i == j) continue;
                if(win[i][j] || win[j][i]) count++;
            }

            //순위를 매길 수 있는 선수 = 본인 제외 n - 1명 모두 전적이 존재해야 함
            if(count == n - 1) answer++;
        }

        return answer;
    }
}
