package week27;

public class ConvertString_DFS {
    static boolean[] selected;

    public int solution(String begin, String target, String[] words) {
        selected = new boolean[words.length];
        int answer = dfs(begin, target, words, 0);

        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }

    static int dfs(String begin, String target, String[] words, int turns){

        int answer = Integer.MAX_VALUE;

        if(begin.equals(target)) {
            //System.out.println("현재 단어는 " + begin + "이며, 이 단어는 목표 단어입니다. *answer : " + turns);
            return turns;
        }

        //조합
        for(int i = 0 ; i < words.length ; i++){

            if(selected[i]) continue;
            if(isPossible(begin, words[i])){
                selected[i] = true;
                //System.out.println("현재 단어는 " + begin + ", 이제 " + words[i] + "로 바뀝니다.");
                answer = Math.min(answer, dfs(words[i], target, words, turns + 1));

                selected[i] = false;
            }
        }

        return answer;
    }

    static boolean isPossible(String from, String to){
        int count = 0;

        //System.out.println("from : " + from + " to : " + to);

        for(int i = 0 ; i < from.length() ; i++){
            if(from.charAt(i) != to.charAt(i)) count++;
            else continue;
        }

        return (count > 1) ? false : true;
    }
}
