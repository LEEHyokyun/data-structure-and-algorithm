package week28;

public class Words_Convertion_from_begin_to_target_dfs {
    static boolean[] selected;

    public int solution(String begin, String target, String[] words) {

        selected = new boolean[words.length];

        int ans = dfs(begin, target, words, 0);

        return (ans == Integer.MAX_VALUE) ? 0 : ans; //최종적인 판정은 바깥에서 진행.

    }

    static int dfs(String begin, String target, String[] words, int count){

        if(begin.equals(target)) return count;

        int answer = Integer.MAX_VALUE;

        for(int i = 0 ; i < words.length ; i++){

            if(selected[i]) continue;

            if(isPossible(begin, words[i])){
                selected[i] = true;
                answer = Math.min(answer, dfs(words[i], target, words, count + 1));
                selected[i] = false;
            }

        }

        return answer; //마지막 도달하고 dfs를 벗어날때 이 부분까지 최소값 산출에 영향을 미칠 수 있다.

    }

    static boolean isPossible(String from, String to){

        int count = 0;

        for(int i = 0 ; i < to.length() ; i++){

            if(from.charAt(i) != to.charAt(i)) {
                count++;
                if(count > 1) return false;
            }else continue;
        }

        return true;

    }
}
