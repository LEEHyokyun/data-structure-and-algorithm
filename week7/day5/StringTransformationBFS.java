package week7.day5;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringTransformationBFS {
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {

        int N = words.length;
        visited = new boolean[N];
        Queue<String> q = new ArrayDeque<>();
        Queue<Integer> depth = new ArrayDeque<>();

        //begin -> target
        //변환가능 : words에서 선택
        q.offer(begin);
        depth.offer(0);

        while(!q.isEmpty()){
            String cur = q.poll();
            int cnt = depth.poll();

            if(cur.equals(target)){
                return cnt;
            }

            for(int i = 0 ; i < N ; i++){
                if(!visited[i] && canMove(cur, words[i])){
                    visited[i] = true;
                    q.offer(words[i]);
                    depth.offer(cnt+1);
                }
            }

        }

        return 0;
    }

    static boolean canMove(String from, String to){
        int diff = 0;
        int n = to.length();

        for(int i = 0 ; i < n ; i++){
            char c1 = from.charAt(i);
            char c2 = to.charAt(i);

            if(c1 != c2){
                diff+= 1;
            }
        }

        if(diff != 1) return false;

        return true;
    }
}
