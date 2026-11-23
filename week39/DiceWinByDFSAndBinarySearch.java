package week39;

public class DiceWin_MakeCombination_조합_ByDFS {
    static int n;
    static int pick;
    static int[] selected;

    public int[] solution(int[][] dice) {

        /*
         * A/B -> n개 주사위(*1~6의 숫자가 랜덤으로 쓰여져 있음)
         * A가 먼저 n/2개 , B가 그 후 n/2개 가져가고, 각 주사위 숫자 합 비교하여 큰 쪽이 이김
         * 1) N/2, N/2개씩 가져갈 수 있는 경우의 수 분리
         * 2) 분리된 경우의 수에서 주사위 합 경우의 수 분리해서 이기는 경우의 수 계산
         */

        n = dice.length;
        pick = n/2;

        //무엇을 선택했는가
        selected = new int[pick];
        dfs(0,0);

        return new int[]{0,0};

    }

    static void dfs(int start, int count){
        if(count == pick){
            return;
        }

        for(int i = start ; i < n ; i++){
            dfs(i + 1, count + 1);
        }
    }
}
