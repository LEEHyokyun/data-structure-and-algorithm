package week28;

public class Dungeons_dfs_초기값설정 {
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        //최소 필요 피로도, 소모 피로도
        return dfs(k, dungeons, 0); //최초 시작 지점도 방문한 것임

    }

    static int dfs(int k , int[][] dungeons, int count){

        /*
         * 초기값 설정
         * 현재 상태에서 더 갈 수 없는 경우가 생김
         * 그렇다면 새로운 값(0)이 아니라, 누적된 answer를 사용해야 함
         */
        int answer = count ;

        if(count == dungeons.length) return count;

        for(int i = 0 ; i < dungeons.length ; i++){

            int required = dungeons[i][0];
            int wasted = dungeons[i][1];

            if(visited[i]) continue;
            if(k - required < 0) continue; //단순히 넘기기만 하면 됨

            //System.out.println("현재 피로도 : " + k);
            //System.out.println("현재 방문 인덱스  : " + i);
            //System.out.println("방문 횟수 : " + count);

            visited[i] = true;
            //System.out.println("현재 " + i + "에 대한 방문은 dfs로 더 깊이 탐색한다");

            answer = Math.max(
                    answer,
                    dfs(k - wasted, dungeons, count + 1) //이게 안되는 경우
            );
            visited[i] = false;
            //System.out.println("현재 " + i + "에 대한 방문은 탐색 불가, 백트래킹 실시");
        }

        return answer;
    }
}
