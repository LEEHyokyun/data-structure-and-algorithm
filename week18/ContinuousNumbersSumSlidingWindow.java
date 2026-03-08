package week18;

public class ContinuousNumbersSumSlidingWindow {
    public int[] solution(int[] sequence, int k) {

        //합이 k인 부분 수열 중 길이가 짧은 수열
        //길이가 짧은 수열이 여러 개인 경우, 시작 인덱스가 작은 수열.

        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int sum = 0;
        int size = Integer.MAX_VALUE;

        while(true){

            if(sum < k){
                if(right == sequence.length) break;
                sum += sequence[right++];
            }else if(sum > k){
                sum -= sequence[left++];
            }else{
                int len = right - left + 1;

                if(len < size) {
                    answer[0] = left;
                    answer[1] = right - 1; //idex = right - 1
                    size = len;
                }

                sum -= sequence[left++];
            }
        }



        return answer;
    }
}
