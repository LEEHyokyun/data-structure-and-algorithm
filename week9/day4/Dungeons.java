package week9.day4;

public class Dungeons {
    static boolean[] visited;
    static int answer;

    public int solution(int k, int[][] dungeons) {

        int length = dungeons.length;
        visited = new boolean[length];

        //dfs
        dfs(k, dungeons, 0);

        return answer;
    }

    static void dfs(int k , int[][] dungeons, int count){
        int length = dungeons.length;

        answer = Math.max(count, answer);

        for(int i = 0 ; i < length ; i++){

            int[] cur = dungeons[i];

            if(visited[i]) continue;
            if(!isPossible(k, cur)) continue;

            visited[i] = true;
            dfs(k-cur[1], dungeons, count+1);
            visited[i] = false;
        }
    }

    static boolean isPossible(int k, int[] cur){
        if(k >= cur[0]) return true;
        return false;
    }
}
