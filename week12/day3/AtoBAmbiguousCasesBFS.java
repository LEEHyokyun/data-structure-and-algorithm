package week12.day3;

import java.util.ArrayDeque;
import java.util.Queue;

public class AtoBAmbiguousCasesBFS {
    public int solution(int x, int y, int n) {
        int answer = bfs(x, new int[]{y, 0}, n);
        return (answer == 1000001) ? -1 : answer;
    }

    static int bfs(int target, int[] path, int n){

        //int min = 1000001;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(path);
        //전역적인 카운팅 관리가 아니라 경로별 별도 관리

        while(!q.isEmpty()){
            int[] curs = q.poll();
            int cur = curs[0];
            int count = curs[1];

            if(cur == target) {
                //min = Math.min(min, count);
                return count; //bfs - 최단경로 보장
            }

            if(cur % 2 == 0){
                q.offer(new int[]{cur / 2 , count +1});
            }

            if(cur % 3 == 0){
                q.offer(new int[]{cur / 3 , count +1});
            }

            if(cur - n >= target){
                q.offer(new int[]{cur - n , count +1});
            }
        }

        return min;
    }
}
