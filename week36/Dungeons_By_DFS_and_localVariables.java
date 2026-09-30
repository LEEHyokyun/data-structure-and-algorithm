package week36;

public class Dungeons_By_DFS_and_localVariables {
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        return dfs(k, dungeons, 0);
    }

    static int dfs(int k, int[][] dungeons, int count){

        int answer = count;

        //기저조건 : 끝까지 탐색이 이루어졌을때
        if(count == dungeons.length) return count;

        for(int i = 0 ; i < dungeons.length ; i++){

            if(visited[i]) continue;
            if(k < dungeons[i][0]) continue;

            visited[i] = true;

            answer = Math.max(
                    answer,
                    dfs(k - dungeons[i][1], dungeons, count + 1)
            );

            visited[i] = false;

        }

        return answer;
    }
}
