package week26;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberBruteForce {
    static Set<Integer> set = new HashSet<>();
    static boolean[] selected;
    //static int count;

    public int solution(String numbers) {

        selected = new boolean[numbers.length()];

        //if(numbers.length() == 1 && (int) numbers.charAt(0) == 0) return 0;
        //if(numbers.length() == 1 && (int) numbers.charAt(0) == 1) return 0;

        dfs(numbers, "");

        return set.size();
    }

    static void dfs(String numbers, String cur){

        if(!cur.equals("")){
            //System.out.println("cur : " + cur);

            int res = Integer.parseInt(cur);
            //System.out.println("현재 res : " + res);

            if(isPrime(res)) {

                //if(map.getOrDefault(res, 0) == 0) {

                //System.out.println("결과 적용 : " + res);

                set.add(res);
                //count++;
                //}
                //return;

            }
        }

        for(int i = 0 ; i < numbers.length() ; i++){

            if(selected[i]) continue;

            selected[i] = true;
            dfs(numbers, cur + numbers.charAt(i));
            selected[i] = false;
        }
    }

    static boolean isPrime(int num){

        if(num == 0) return false;
        if(num == 1) return false;

        for(int i = 2 ; i * i <= num ; i++){
            if((num % i) == 0) return false;
        }

        return true;
    }
}
