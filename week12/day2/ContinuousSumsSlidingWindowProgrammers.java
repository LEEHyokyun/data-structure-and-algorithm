package week12.day2;

public class ContinuousSumsSlidingWindowProgrammers {
    public int[] solution(int[] sequence, int k) {

        //연속된 부분 수열의 합
        //누적합 or 슬라이딩 윈도우
        int[] answer = new int[2];
        //길이가 짧은 수열, 짧은 수열이 여러개라면 시작 인덱스가 작은.
        //sum에 대한 단조성

        int sum = 0;
        int left = 0;
        int right = 0;
        int length = sequence.length;
        int min = Integer.MAX_VALUE;

        while(true){
            if(sum == k){
                //left -> left
                //right -> right - 1
                int len = right - left + 1;

                if(len < min) {
                    answer[0] = left;
                    answer[1] = right - 1;
                    min = Math.min(min, len);
                }

                sum -= sequence[left];
                left++;
            }else if(sum < k){
                if(right == length) break;
                sum += sequence[right];
                right++;
            }else if(sum > k){
                sum -= sequence[left];
                left++;
            }
        }


        //answer[0] = left;
        //answer[1] = right - 1;

        return answer;
    }
}
