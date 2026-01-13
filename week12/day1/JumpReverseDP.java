package week12.day1;

public class JumpReverseDP {
    public int solution(int n) {

        // +K *2
        // +K -> 건전지 사용 -K
        // 0 -> N 점프 이동 최소 사용 건전지 사용량의 최소값.

        //dp
        //n까지 이동하였을때, 최소 샤용량
        //int[] dp = new int[n+1];
        //dp[0] = 0;
        //dp[1] = 1;

        //점화식에 대한 역방향 접근
        //해 도출 자체를 역방향 접근
        int answer = 0;
        int N = n;

        //최초 위치는 0이다.
        while(N > 0){
            if(N % 2 == 0){
                N = N / 2;    //6 -> 3  // 2 -> 1
            }else{
                N = N - 1;    //3 -> 2  // 1 -> 0 0-> 종료 .. N = 0 -> 도착
                answer ++;
            }
        }

        return answer;
    }
}
