package week9.day1;

import java.util.Arrays;

public class MoneyTheMostSumWhenBudgetOverMaxDP {
    static int sum = 0;

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int length = d.length;
        int count = 0;

        for(int i = 0 ; i < length ; i++){
            if(isPossible(d[i], budget)){
                sum += d[i];
                count++;
            }else{
                break;
            }
        }

        return count;
    }

    static boolean isPossible(int required, int budget){
        if(sum + required <= budget) return true;

        return false;
    }
}
