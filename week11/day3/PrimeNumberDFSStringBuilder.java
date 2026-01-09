package week11.day3;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberDFSStringBuilder {
    static boolean[] selected;
    static int count;
    static Set<Integer> used = new HashSet<>();;

    public int solution(String numbers) {
        int n = numbers.length();
        selected = new boolean[n];
        char[] chars = numbers.toCharArray();
        StringBuilder sb = new StringBuilder();

        dfs(chars, sb);

        return count;

    }

    static void dfs(char[] chars, StringBuilder sb){

        if(sb.length() > 0){
            int num = Integer.parseInt(sb.toString());

            if(!used.contains(num)){
                used.add(num);

                if(isPrime(num)) count++;
            }
        }

        if(sb.length() == chars.length){
            return;
        }

        //순열 i = 0 //조합 i = start
        for(int i = 0 ; i < chars.length ; i++){
            if(selected[i]) continue;

            selected[i] = true;

            int len = sb.length();
            sb.append(chars[i]);

            dfs(chars, sb);

            sb.setLength(len);
            selected[i] = false;
        }

        return;
    }

    static boolean isPrime(int N){
        if(N < 2) return false;

        for(int i = 2 ; i * i <= N ; i++){
            if(N % i == 0) return false;
        }

        return true;
    }
}
