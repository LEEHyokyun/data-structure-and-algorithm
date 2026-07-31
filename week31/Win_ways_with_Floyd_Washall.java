package week31;

public class Win_ways_with_Floyd_Washall {
    public int solution(int n, int[][] results) {
        //전이관계의 확장 = 플로이드 워셜
        //(*MST = 크루스칼)

        boolean[][] win = new boolean[n+1][n+1];

        for(int[] result : results){

            int from = result[0];
            int to = result[1];

            win[from][to] = true;

        }

        for(int k = 1 ; k <= n ; k++){
            for(int j = 1 ; j <= n ; j++){
                for(int i = 1 ; i <= n ; i++){
                    //conditions & apply
                    if(win[i][k] && win[k][j]){
                        win[i][j] = true;
                    }
                }
            }
        }


        int answer = 0;
        for(int i = 1 ; i <= n ; i++){
            int count = 0;

            for(int j = 1 ; j <= n ; j++){
                //i가 순위 확정 = 나머지 상대 인원의 경우의 수가 n-1(본인 제외)개만큼 도출되어야 가능
                if(i == j) continue;
                if(win[i][j] || win[j][i]) count++;
            }

            if(count == n - 1) answer++;
        }

        return answer;
    }
}
