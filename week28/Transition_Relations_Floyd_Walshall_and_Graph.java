package week28;

public class Transition_Relations_Floyd_Walshall_and_Graph {
    /*
     * 특정 선수의 순위 내역이 n-1일때 순위 확정이 가능.
     * 이 특정 선수를 모든 선수 쌍에 대해 조사
     * = 플로이드 워셜(*전이관계 확장 / 모든 정점을 경유지로 고려)
     */
    public int solution(int n, int[][] results) {

        int[][] graph = new int[n+1][n+1];

        for(int[] result : results){
            int p1 = result[0];
            int p2 = result[1];

            graph[p1][p2] = 1; //단방향.."이겼다/전이관계"가 확실해야 한다(출발지/경유지 이런 개념이 아님).
            //graph[p2][p1] = 1;
        }

        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1; //단방향
                }
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= n ; i++){
            int count = 0;
            //각 항목에 대해 순위 정립이 가능한 경우
            for(int j = 1 ; j <= n ; j++){
                if(j == i) continue;
                if(graph[i][j] == 1 || graph[j][i] == 1) count++; //여기서는 쌍방향, 전이 관계 카운팅
            }

            if(count == n - 1) answer++;
        }

        return answer;
    }
}
