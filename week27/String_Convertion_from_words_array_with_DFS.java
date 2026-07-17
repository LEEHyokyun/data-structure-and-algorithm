package week27;

public class String_Convertion_from_words_array_with_DFS {
    static boolean[] used;

    public int solution(String begin, String target, String[] words) {

        used = new boolean[words.length];

        int answer = dfs(begin, target, words, 0);

        return (answer == Integer.MAX_VALUE) ? 0 : answer ;
    }

    static int dfs(String begin, String target, String[] words, int count){

        if(begin.equals(target)){
            return count;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < words.length ; i++){

            if(used[i]) continue;
            if(isPossible(begin, words[i])){
                used[i] = true;
                ans = Math.min(ans, dfs(words[i], target, words, count + 1));
                used[i] = false;
            }

        }

        return ans;
    }

    static boolean isPossible(String from, String to){

        int count = 0;

        for(int i = 0 ; i < from.length() ; i++){

            char c1 = from.charAt(i);
            char c2 = to.charAt(i);

            if(c1 != c2) {
                count++;
                if(count > 1) return false;
            }
        }

        return true;

    }
}
