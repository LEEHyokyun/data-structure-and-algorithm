package week34;

public class MinesAndTools_with_DFS {
    static int[][] graph = {
            {1,1,1},
            {5,1,1},
            {25,5,1}
    };

    //static boolean used = new boolean[3];
    static int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        /*
         * 곡괭이로 광물을 캘때 소모하는 피로도
         * 광물 상관없이 총 5개를 캔 후에는 사용 불가
         * 광산 모든 광물 캐거나, 모든 곡괭이 더이상 사용할 수 없을때까지
         */
        int[] rubies = new int[minerals.length];
        int idx = 0;
        for(String mineral : minerals){

            if(mineral.equals("diamond")){
                rubies[idx++] = 0;
            }else if(mineral.equals("iron")){
                rubies[idx++] = 1;
            }else {
                rubies[idx++] = 2;
            }
        }

        dfs(picks, rubies, 0, 0);

        return answer;
    }

    static void dfs(int[] picks, int[] rubies, int idx, int res){

        if(idx == rubies.length){
            answer = Math.min(answer, res);
            return;
        }

        if(picks[0] + picks[1] + picks[2] == 0) {
            answer = Math.min(answer, res);
            return;
        }

        for(int pick = 0 ; pick < 3 ; pick++){

            if(picks[pick] == 0) continue;

            picks[pick]--;

            int fatigue = 0;
            int count = 0;

            //현재 선택한 곡괭이(pick)로 rubies 5개 채굴
            while(count < 5 && idx + count < rubies.length){
                fatigue += graph[pick][rubies[idx + count]];
                count++;
            }

            //채굴 다했으면 다음 곡괭이 선택
            dfs(
                    picks,
                    rubies,
                    idx + count, //count = 다음 count 누적된 상태임.
                    res + fatigue
            );

            //해당 조합이 안되면 다른 조합의 곡괭이 선택을 위해 백트래킹
            picks[pick]++;

        }

    }
}
