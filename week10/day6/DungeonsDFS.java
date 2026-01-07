package week10.day6;

public class DungeonsDFS {
    static int answer = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        answer = dfs(k, dungeons, 0);

        return answer;
    }

    static int dfs(int k , int[][] dungeons, int count){
        int length = dungeons.length;
        answer = Math.max(answer, count);

        for(int i = 0 ; i < length ; i++){
            int least = dungeons[i][0];
            int consume = dungeons[i][1];

            if(visited[i]) continue;
            if(!isPossible(least, k)) continue;

            visited[i] = true;
            dfs(k - consume, dungeons, count + 1); //visited -> 전체순회 가능
            visited[i] = false;
            // 0 -> 1  OK
            // 1 -> 0 OK
        }

        return answer;
    }

    static boolean isPossible(int least, int k){
        if(k >= least) return true;
        else return false;
    }
}
