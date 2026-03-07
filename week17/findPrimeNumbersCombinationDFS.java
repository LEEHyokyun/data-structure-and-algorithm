package week17;

import java.util.HashSet;

public class findPrimeNumbersCombinationDFS {
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] selected;

    //12 != 21 .. 조합
    public int solution(String numbers) {

        selected = new boolean[numbers.length()];

        dfs(numbers, "");

        for(int i : set){
            System.out.println(i);
        }

        return set.size();
    }

    static void dfs(String numbers, String current){
        char[] chars = numbers.toCharArray();

        if(!current.equals("")){
            int number = Integer.parseInt(current);

            if(isPrimeNumber(number)){
                set.add(number);
            }
        }

        for(int i = 0 ; i < chars.length ; i++){

            if(selected[i]) continue;

            selected[i] = true;
            dfs(numbers, current + chars[i]);
            selected[i] = false;
        }
    }

    static boolean isPrimeNumber(int num){

        if(num == 0) return false;
        if(num == 1) return false;

        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
