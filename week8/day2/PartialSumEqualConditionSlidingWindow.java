package week8.day2;

public class PartialSumEqualConditionSlidingWindow {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int N = sequence.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0 ; right < N ; right++){
            sum = sum + sequence[right];

            while(sum >= k){
                if(sum == k && right-left+1 < min){
                    min = Math.min(min, right-left+1);
                    answer = new int[]{left, right};
                }
                sum = sum - sequence[left++];
            }
        }

        return answer;
    }
}
