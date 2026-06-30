package week27;

public class ConvertToKNumAndPrime_JavaUtil {
    public int solution(int n, int k) {

        //n을 k로 바꿀때 int로 바꾸면 10진수로 바꾸는 것. 문자열로 다룬다.
        //중요한 기점은 0, spli을 활용해보자. 굳이 StringBuilder 사용 필요 없다.

        String converted = Long.toString(n, k);

        System.out.println("CHECK!");

        String[] nums = converted.split("0+"); //0이 기점

        int ans = 0;

        if(nums.length == 0) return 0;

        for(String num : nums){

            //숫자가 매우 클 수 있음
            long val = Long.parseLong(num);

            if(isPrime(val)) ans++;

        }

        return ans;
    }

    static boolean isPrime(long num){

        if(num == 1) return false;
        if(num == 2) return true;

        for(long i = 2 ; i * i <= num ; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
