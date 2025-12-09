package week5.day5;

public class SlidingWindowAndNumbersSum {
    public int solution(int n) {
        int left = 1;
        int right = 1;
        int sum = 0;
        int count = 0;

        while(true){
            if(sum > n){
                sum = sum - left;
                left++;
            }else if(sum < n){
                if(right > n) break;
                sum = sum + right;
                right++;
            }else{
                count++;
                sum = sum - left;
                left = left + 1;
            }
        }

        return count;
    }
}
