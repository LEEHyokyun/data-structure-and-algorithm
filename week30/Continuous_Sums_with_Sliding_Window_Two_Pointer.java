package week30;

public class Continuous_Sums_with_Sliding_Window_Two_Pointer {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;

        int[] answer = new int[2];

        while(true){

            //배열 끝까지 반복
            //if(right == sequence.length - 1) break;
            //if(sum < k && right == sequence.length - 1) break;

            if(sum == k){
                //System.out.println("현재 합 : " + sum);
                //System.out.println("현재 길이 : " + (right - left + 1));
                //System.out.println("left : " + left);
                //System.out.println("right : " + right);

                if((right - left + 1) < length){
                    length = right - left + 1;

                    answer[0] = left;
                    answer[1] = right - 1;
                }

                //sum += sequence[right++];
                sum -= sequence[left++];
            }

            if(sum < k){
                //합이 k보다 작은데 right가 끝까지 간 상태라면 더이상 도달 불가
                if(right == sequence.length) break;
                sum += sequence[right++];
                //if(right == sequence.length) break;
            }

            if(sum > k){
                //if(left == sequence.length) break;
                sum -= sequence[left++];
                //if(left == sequence.length) break;
            }

            //if(right > sequence.length - 1 && left > sequence.length - 1) break;
        }

        return answer;
    }
}
