package week28;

public class Simulation_Block_removing_and_pushing_key_point_is_considering_logics {
    public int solution(int m, int n, String[] board) {
        //m * n

        char[][] map = new char[m][n];

        for(int i = 0 ; i < m ; i++){
            map[i] = board[i].toCharArray();
        }

        int answer = 0;

        while(true){
            boolean[][] removed = new boolean[m][n];
            boolean found = false;

            for(int i = 1 ; i < m ; i++){
                for(int j = 1 ; j < n; j++){
                    if(map[i][j] == '.') continue;
                    if(isPossible(map, i, j)) {
                        removed[i][j] = true;
                        removed[i][j-1] = true;
                        removed[i-1][j-1] = true;
                        removed[i-1][j] = true;

                        found = true;
                    }
                }
            }

            if(!found) break;

            //제거하고, 제거한 수 만큼 answer++
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(removed[i][j]){
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }

            //push
            for(int col = 0 ; col < n ; col++){

                int cur = m - 1;

                //밀고
                for(int row = m - 1 ; row >= 0 ; row--){
                    if(map[row][col] != '.') {
                        map[cur][col] = map[row][col];
                        cur--;
                    }
                }

                //빈칸
                while(cur >= 0){
                    map[cur][col] = '.';
                    cur--;
                }
            }
        }

        return answer;
    }

    static boolean isPossible(char[][] map, int i, int j){

        if(
                map[i][j] == map[i][j-1] &&
                        map[i][j] == map[i-1][j-1] &&
                        map[i][j] == map[i-1][j]
        ) return true;
        else return false;

    }
}
