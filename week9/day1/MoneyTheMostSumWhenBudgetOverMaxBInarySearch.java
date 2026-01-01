package week9.day1;

public class MoneyTheMostSumWhenBudgetOverMaxBInarySearch {
    public int solution(int[] d, int budget) {
        //딱 그만큼 지원, 적은 금액 지원 불가
        //갯수

        int N = d.length;
        int max = 0;
        int ideal = 0;
        for(int i = 0 ; i < N ; i++){
            max = Math.max(max, d[i]);
            ideal += d[i];
        }

        int left = 1;
        int right = max;
        int answer = 0;
        int sum = 0;

        if(budget >= ideal){
            answer = N;
        }else{
            while(left <= right){
                int count = 0;
                int mid = (left + right) / 2;

                for(int i = 0 ; i < N ; i++){

                    if(d[i] > mid){
                        sum += 0;
                    }else{
                        sum += d[i];
                        count ++;
                    }

                }

                if(sum > budget) right = mid - 1;
                else {
                    answer = count;
                    left = mid + 1;
                }
            }
        }


        return answer;
    }
}
