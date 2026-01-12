package week12.day2;

public class JumpDP {
    public int solution(int n) {
        int ans = 0;

        // +K *2
        // +K -> 건전지 사용 -K
        // 0 -> N 점프 이동 최소 사용 건전지 사용량의 최소값.

        //dp
        //n까지 이동하였을때, 최소 샤용량
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            if(i%2 == 0){
                //n 짝수
                dp[i] = dp[i/2];        //2 = 1, 4 = 1, 6 = 2
            }
            else{
                //n 홀수
                dp[i] = dp[i-1] + 1;    //3 - 2, 5 = 2
            }
        }

        return dp[n];
    }
}
