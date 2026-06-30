package week27;

public class FriendsBlock4by4_Simulation {
    public int solution(int m, int n, String[] board) {
        //m -> 행 n -> 열

        char[][] map = new char[m][n];

        for(int i = 0 ; i < m ; i++){
            map[i] = board[i].toCharArray();
        }

        int answer = 0;

        while(true){

            boolean[][] remove = new boolean[m][n];
            boolean found = false;

            //제거할 블록 한번에 다 찾는다.
            for(int i = 0 ; i < m - 1; i++){
                for(int j = 0 ; j < n - 1 ; j++){

                    char now = map[i][j];

                    if(now == '.') continue;
                    if(now == map[i][j+1] && now == map[i+1][j] && now == map[i+1][j+1]){
                        remove[i][j] = true; //조건 만족시 지운다
                        remove[i][j+1] = true;
                        remove[i+1][j] = true;
                        remove[i+1][j+1] = true;

                        found = true;
                    }

                }
            }

            //종료
            if(!found) break;

            //제거
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(remove[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }

            //아래로
            for(int col = 0 ; col < n ; col++){

                //현재 열에 대해 들여쓰기 작업 진행

                int write = m - 1;

                for(int row = m - 1 ; row >= 0 ; row--){
                    if(map[row][col] != '.'){
                        //빈칸이면 채우고
                        map[write][col] = map[row][col];
                        //다음 행으로 넘긴다
                        write--;
                    }
                }

                //남은 칸은 빈칸으로
                while(write >= 0){
                    map[write][col] = '.';
                    write--;
                }

            }
        }

        return answer;
    }
}
