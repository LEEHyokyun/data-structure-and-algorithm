package week4.day2;

public class FactorAndSqrt {
    public int solution1(int left, int right) {
        //약수 = 제곱근
        int answer = 0;

        for(int i = left ; i <= right ; i++){
            int count = 0;
            for(int j = 1 ; j*j <= i ; j++){
                if(i % j == 0){
                    count += (j * j == i)? 1 : 2;   //중근이면 +1개
                }
            }
            if(count % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }

    public int solution2(int left, int right) {
        int answer = 0 ;

        for(int n = left ; n <= right ; n++){
            int sqrt = (int) Math.sqrt(n);

            //중근이 있으면 무조건 홀수개 없으면 짝수개
            if(sqrt * sqrt == n) answer -= n;
            else answer += n;
        }

        return answer;
    }
}
