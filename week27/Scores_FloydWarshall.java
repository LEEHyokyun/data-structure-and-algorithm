package week27;

public class Scores_FloydWarshall {
    public int solution(int n, int[][] results) {
        //A > B + B > C = A > C
        //전이관계(transition Closure)
        //플로이드워셜(C to i to j)

        //node >= 1
        boolean[][] win = new boolean[n+1][n+1];

        for(int[] result : results){
            int from = result[0];
            int to = result[1];

            win[from][to] = true;
        }

        //알아보고자 하는 지점을 중심으로
        //i > k k > j의 관계가 정립이 되어있다면  i > j의 관계 정립도 가능하다.
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

        for(int i = 1 ; i <= n ; i++){
            int count = 0 ;

            //특정 시작점 i에 대하여 관계 정립 가능한 수가 node -1일때 순위 확정 가능
            for(int j = 1 ; j <= n ; j++){
                if(i == j) continue;

                if(win[i][j] || win[j][i]) count++;
            }

            if(count == n - 1) answer++;
        }

        return answer;
    }
}
