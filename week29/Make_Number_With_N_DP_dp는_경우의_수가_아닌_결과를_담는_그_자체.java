package week29;

import java.util.HashSet;
import java.util.Set;

public class Make_Number_With_N_DP_dp는_경우의_수가_아닌_결과를_담는_그_자체 {
    /*
     * 결과의 누적 = DP / memoization
     * 5를 1번 사용한 결과를 2번 사용한 결과에 활용하고
     * 5를 2번 사용한 결과를 3번 사용한 결과에 활용하고
     * 5를 3번 사용한 결과를 4번 사용한 결과에 활용하여 누적하는 식
     * 다만, 경우의 수가 아니라 수 자체를 직접 넣는다.
     * dp[i] = dp[j]와 dp[i-j]의 모든 원소를 서로 사칙연산해서 얻은 결과들의 "집합"
     */

    public int solution(int N, int number) {
        //숫자N을 사용한 사칙연산, number를 만드는
        //나눗셈일 경우 나머지 무시
        //최소값 return, 8이상이라면 -1 return

        /*
         * dp[i] = N을 i번 사용해서 만들 수 있는 숫자
         * 각 연산 수행 후 to Set, Set에 number가 존재한다면 최소값 OK.
         */
        if(N == number) return 1;

        //어차피 최대 사용 횟수는 8회, 넘어가면 -1 return
        Set<Integer>[] dp = new HashSet[9];
        for(int i = 0 ; i <= 8 ; i++){
            dp[i] = new HashSet<>();
        }

        dp[0].add(0);

        for(int i = 1 ; i <= 8 ; i++){
            //init : N을 i번 사용하여 얻을 수 있는 모든 수
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(repeated);

            //dp[i] = dp[i-j]의 집합 + dp[j]의 집합
            //여기서 dp는 경우의 수가 아니라, "실제 만들 수 있는 수의 집합 그 자체"
            for(int j = 1 ; j < i ; j++){ //j는 i에 도달하기 위해 그 방법을 사용하는
                for(int a : dp[j]){
                    for(int b : dp[i-j]){
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);

                        if(b != 0) dp[i].add(a / b);
                    }
                }
            }

            if(dp[i].contains(number)) return i;
        }

        //사용할 수 있는 숫자의 개수가 8회를 넘어간다면 -1 return
        return -1;
    }
}
