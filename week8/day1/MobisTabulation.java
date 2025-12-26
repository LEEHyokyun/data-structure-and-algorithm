package week8.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MobisTabulation {
    static final int INF = 1_000_000_000;

    public int solution(int k, int n, int[][] reqs) {

        //init
        //상담유형 k
        //n = k[1] + k[2] + ....k[k+1]
        List<int[]>[] byType = new ArrayList[k + 1];
        for(int i = 1 ; i <= k ; i++){
            byType[i] = new ArrayList<>(); //정의
        }

        for(int[] r : reqs){
            int start = r[0];
            int duration = r[1];
            int type = r[2];

            byType[type].add(new int[]{start, duration});
        }

        //cost = dp[i][j] = i번째 상담 유형에서 상담원 j명을 사용한 최소 대기시간
        int[][] cost = new int[k + 1][n + 1];

        //cost brute force
        for(int type = 1 ; type <= k ; type++){
            for(int mentors = 1 ; mentors <= n ; mentors++){
                cost[type][mentors] = simulate(byType[type], mentors);
            }
        }

        int[][] dp = new int[k+1][n+1];
        for(int i = 0 ; i <= k ; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for(int type = 1 ; type <= k ; type++){
            for(int used = 1 ; used <= n ; used++){ //1유형에 1명할당 부터 k유형에 n명 할당까지
                for(int assign = 1 ; assign <= used ; assign++){
                    dp[type][used] = Math.min(
                            dp[type][used],
                            dp[type-1][used - assign] + cost[type][assign]
                    );
                }
            }
        }

        return dp[k][n];
    }

    static int simulate(List<int[]> reqs, int mentors){
        if(reqs.isEmpty()) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < mentors ; i++){
            pq.offer(0);
        }

        int wait = 0;

        for(int[] r : reqs){
            int start = r[0];
            int duration = r[1];
            int available = pq.poll();

            if(available > start){
                wait = wait + (available - start);
                pq.offer(available + duration);
            }else{
                pq.offer(start + duration);
            }

        }

        return wait;
    }
}
