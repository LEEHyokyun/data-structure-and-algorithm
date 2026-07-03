package week27;

public class CircularSticker_with_2dp_arrays {
    public int solution(int sticker[]) {
        //인접한 스티커 선택 연속 선택 불가

        //선택하는 경우의 수가 특정된다 = DP
        //i번째 항목에서 최대 값 = i-2 + i or i-1 이 중 최대

        int n = sticker.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        int answer = dp1[0];

        //첫번쨰 선택 -> 마지막 선택 불가
        for(int i = 2 ; i < n ; i++){

            if(i == n-1) {
                dp1[i] = dp1[i-1];
                break;
            }

            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
            answer = Math.max(dp1[i], answer);
        }

        //두번째 선택 -> 마지막 선택 OK
        for(int i = 2 ; i < n ; i++){
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
            answer = Math.max(dp2[i], answer);
        }

        return answer;
    }
}
