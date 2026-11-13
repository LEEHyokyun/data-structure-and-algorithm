package week37;

public class BinaryGap {
    public int solution(int N) {
        /*
         * binary gap = 숫자를 이진법 수로 표현하였을때, 연속된 0의 개수(리스트)
         * 9 -> 1001(2) = binary gap is 2
         * 529 -> 1000010001(2) = binary gap is 4/3
         * 이 gap 중 가장 큰 수를 반환하고, 0이면 0
         */
        String converted = Long.toString(N, 2);
        char[] list = converted.toCharArray();

        int isOne = 0;
        int answer = 0;
        int count = 0;

        for(int i = 0 ; i < list.length ; i++){

            int num = list[i] - '0';

            if(num == 1){

                if(count > 0 && isOne > 0) {
                    answer = Math.max(count, answer);
                    count = 0;
                }

                isOne++;
            }else {
                count++;
            }
        }

        return answer;
    }
}
