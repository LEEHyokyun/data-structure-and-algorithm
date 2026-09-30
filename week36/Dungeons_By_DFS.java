package week36;

public class Dungeons_By_DFS {
    static boolean[] visited;
    static int result;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        return dfs(k, dungeons, 0);
    }

    static int dfs(int k, int[][] dungeons, int count){

        result = Math.max(result, count);

        for(int i = 0 ; i < dungeons.length ; i++){

            if(visited[i]) continue;
            if(k < dungeons[i][0]) continue;

            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, count + 1);
            visited[i] = false;

        }

        return result;
    }
}
