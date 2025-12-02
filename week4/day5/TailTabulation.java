package week4.day5;

public class TailTabulation {
    public long solution(int n) {
        return tabulation(n);
    }

    static long tabulation(int n){

        long[] result = new long[n+1];

        if((n % 2) == 1) return 0;
        if(n == 2) return 3;

        if(n >= 4){
            //짝수일 경우만 가능하고 홀수인 경우에는 아예 0
            result[0] = 1;
            result[2] = 3;

            for(int i = 4 ; i <= n ; i+=2){
                result[i] = (result[i-2] * 3) % 1000000007; //대칭패턴

                for(int j = 4 ; j <= i ; j+=2){
                    result[i] = (result[i] + result[i-j] * 2) % 1000000007; //특수패턴
                }
            }
        }

        return result[n];
    }
}
