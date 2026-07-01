package week27;

public class MaxNumberSumTriangle_DP_memoization {
    public int solution(int[][] triangle) {
        //각 구간마다 최대의 값을 선택하면서 내려가자.
        //그걸 memoization하자.


        int len1 = triangle.length;
        int[][] dp = new int[len1][len1];

        dp[0][0] = triangle[0][0];
        for(int i = 1 ; i < len1 ; i++){

            int len2 = triangle[i].length;

            for(int j = 0 ; j < len2 ; j++){
                //왼쪽 끝
                if(j == 0){
                    dp[i][j] = dp[i-1][0] + triangle[i][j];
                    //오른쪽 끝
                }else if(j == len2 - 1){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    //중간
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }

        }

        int max = dp[len1 - 1][0];
        //int max = 0;
        for(int i = 0 ; i < dp[len1 - 1].length ; i++){
            max = Math.max(max, dp[len1 - 1][i]);
        }

        /*
         * 여기서의 핵심은 탐욕이 아니라는 것.
         * 부분합의 최대가 전체합의 최대를 보장하지 않는다.
         * 다만, 누적합이 최대인 지점이든 뭐든 경로는 항상 일정, 이 누적합 최대를 memoization을 통해 구하고
         * 최종적인 최대값 구간을 가장 이후에 비교해가면서 도출해내는 것이 핵심.
         */
        return max;
    }
}
