package week37;

public class EmoticonDiscountByBruteForce {
    static int[] discount = {10, 20, 30, 40};
    static int[] selected;
    static int[] answer = {0,0};

    public int[] solution(int[][] users, int[] emoticons) {
        /*
         * 1. 플러스 서비스 가입자 최대로, 2. 이모티콘 판매액 최대로
         * n명의 카카오톡 사용자들에게 m개를 할인하여 판매
         * - 각 사용자들은 일정 비율 이상 할인하는 이모티콘을 모두 구매
         * - 각 사용자들이 구매한 이모티콘 비용 합이 일정 가격 이상 시 플러스 서비스 가입(*이때 이모티콘 구매 비용 모두 0)
         * - 할인율은 10,20,30,40 중 하나
         */

        /*
         * Return
         * 이모티콘 플러스 서비스 가입 수 최대(1순위) + 이모티콘 매출액 최대(2순위)
         */
        selected = new int[emoticons.length];

        dfs(0, users, emoticons);

        return answer;
    }

    static void dfs(int depth, int[][] users, int[] emoticons){

        if(depth == emoticons.length){

            int[] result = getResult(users, emoticons);

            if(
                    result[0] > answer[0] ||
                            (result[0] == answer[0] && result[1] > answer[1])
            ) answer = result;

            return;

        }

        /*
         * 이모티콘 선택하기
         */
        for(int i = 0 ; i < discount.length ; i++){
            selected[depth] = discount[i];
            dfs(depth + 1, users, emoticons);
        }

    }

    /*
     * 각 이모티콘마다 할인율을 다르게 지정하고 계산한다.
     */
    static int[] getResult(int[][] users, int[] emoticons){

        int members = 0;
        int totalPrice = 0;

        for(int[] user : users){

            int price = 0;

            for(int i = 0 ; i < emoticons.length ; i++){
                if(selected[i] >= user[0]) price += emoticons[i] * (100 - selected[i]) / 100;
            }

            if(price >= user[1]) members++;
            else totalPrice += price;

        }

        return new int[]{members, totalPrice};
    }
}
