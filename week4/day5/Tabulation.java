package week4.day5;

public class Tabulation {
    public long solution(int n) {
        long answer = 0;

        //조합의 "방법의 수"
        //모든 "경로"를 탐색하는 것이 아닌 "방법의 수"

        /*
         * 마지막에 1칸 뛴 경우 → 나머지 n-1칸을 뛸 경우의 수 = dp[n-1]
         * 마지막에 2칸 뛴 경우 → 나머지 n-2칸을 뛸 경우의 수 = dp[n-2]
         * 최종 경우의 수 = ~~ + 1 의 경우의 수 + ~~ + 2의 경우의 수
         */

        answer = tabulation(n);

        return answer;
    }

    static long tabulation(int n){

        if(n == 1) return 1;
        if(n == 2) return 2;

        long[] result = new long[n+1];

        if(n >= 3){
            result[0] = 0;
            result[1] = 1;
            result[2] = 2;

            for(int i = 3 ; i <= n ; i++){
                result[i] = (result[i-1] + result[i-2]) % 1234567;
            }
        }

        return result[n];
    }
}
