package week9.day6;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringChangingBeginToTargetBFS {
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {

        int length = words.length;
        visited = new boolean[length];

        int result = bfs(begin, target, words, 0);

        return result;
    }

    static int bfs(String begin, String target, String[] words, int start){
        Queue<String> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        q1.offer(begin);
        q2.offer(start);

        while(!q1.isEmpty()){
            String cur = q1.poll();
            int depth = q2.poll();

            if(cur.equals(target)) return depth;

            for(int i = 0 ; i < words.length ; i++){
                if(canMove(cur, words[i]) && !visited[i]){
                    q1.offer(words[i]);
                    q2.offer(depth + 1);
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    static boolean canMove(String cur, String next){

        int differ = 0;

        char[] curArray = cur.toCharArray();
        char[] nextArray = next.toCharArray();

        for(int i = 0 ; i < nextArray.length ; i++){
            if(curArray[i] != nextArray[i]) differ++;
        }

        if(differ == 1) return true;

        return false;
    }
}
