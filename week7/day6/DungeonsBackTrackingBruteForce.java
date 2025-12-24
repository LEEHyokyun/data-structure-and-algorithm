package week7.day6;

public class DungeonsBackTrackingBruteForce {
    static int count = 0 ;
    static int N = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {

        //init
        N = dungeons.length;
        visited = new boolean[N];

        //brute force
        bf(k, dungeons, 0);

        return count;
    }

    static void bf(int k, int[][] dungeons, int num){
        if(num > count) count = num;

        for(int i = 0 ; i < N ; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                bf(k-dungeons[i][1], dungeons, num + 1);

                //초기화
                visited[i] = false;
            }
        }
    }
}
