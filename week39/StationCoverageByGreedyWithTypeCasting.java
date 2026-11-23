package week39;

public class StationCoverageByGreedyWithTypeCasting {
    public int solution(int n, int[] stations, int w) {

        /*
         * N개 아파트에서 4g -> 5g
         * 5g : 도달거리 W
         * 5g 기지국을 최소로 설치하면서 모든 아파트에 전파를 전달하려고 하면?
         */

        /*
         * 한개의 기지국이 커버하는 범위 = 1 + 2 * w
         * stations만 살펴보고, 설치해야 하는 기지국 수를 누적한다.
         */

        int answer = 0;
        int initial = 1;
        int coverage = 2 * w + 1;

        for(int station : stations){

            int left = station - w;
            int right = station + w;

            int length = left - initial;

            if(length > 0) //기지국 설치가 1에 있을 수 있음, 이 경우 continue
                answer += Math.ceil((double) length / coverage);

            //다음 미커버 구간
            initial = right + 1;
        }

        //마지막 기지 이후
        if(initial <= n)
            answer += Math.ceil((double)(n - initial + 1) / coverage);

        return answer;

    }
}
