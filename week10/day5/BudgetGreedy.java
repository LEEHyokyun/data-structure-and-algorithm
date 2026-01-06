package week10.day5;

import java.util.Arrays;

public class BudgetGreedy {
    public int solution(int[] d, int budget) {
        //budget -> 전체 합산 예산 상한액
        //return 지원가능 부서수
        int min = 1;
        int max = budget;
        int length = d.length;

//         while(min <= max){
//             int mid = (min + max) / 2;  //forward to budget.

//             for(int i = 0 ; i < length ; i++){

//             }
//         }

        Arrays.sort(d);
        int count = 0;

        for(int i = 0 ; i < length ; i++){
            if(budget - d[i] >= 0) {
                budget = budget - d[i];
                count++;
            }
        }

        return count;
    }
}
