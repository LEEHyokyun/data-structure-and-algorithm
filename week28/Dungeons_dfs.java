package week28;

public class Dungeons_dfs {
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        //최소 필요 피로도, 소모 피로도
        return dfs(k, dungeons, 1); //최초 시작 지점도 방문한 것임

    }

    static int dfs(int k , int[][] dungeons, int count){

        int answer = 0 ;

        for(int i = 0 ; i < dungeons.length ; i++){

            int required = dungeons[i][0];
            int wasted = dungeons[i][1];

            if(visited[i]) continue;
            if(k - required < 0) return count;

            //System.out.println("현재 피로도 : " + k);
            //System.out.println("현재 방문 인덱스  : " + i);
            //System.out.println("방문 횟수 : " + count);

            visited[i] = true;
            //System.out.println("현재 " + i + "에 대한 방문은 dfs로 더 깊이 탐색한다");

            answer = Math.max(
                    answer,
                    dfs(k - wasted, dungeons, count + 1)
            );
            visited[i] = false;
            //System.out.println("현재 " + i + "에 대한 방문은 탐색 불가, 백트래킹 실시");
        }

        return answer;
    }
}
