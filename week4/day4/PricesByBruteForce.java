package week4.day4;

public class PricesByBruteForce {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        int prev = prices[0];

        for(int i = 0 ; i < prices.length ; i++){
            int time = func(prices, i, prices[i]);
            answer[i] = time;
        }

        return answer;
    }

    static int func(int[] prices, int start, int prev){
        if(start == prices.length - 1)
            return 0;

        int time = 0;
        for(int i = start+1 ; i < prices.length ; i++){
            if(prev > prices[i]){
                time++;
                return time;
            }else{
                time++;
            }
        }

        return time;
    }
}
