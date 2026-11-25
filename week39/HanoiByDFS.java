package week39;

import java.util.ArrayList;
import java.util.List;

public class HanoiByDFS {
    static List<int[]> answer = new ArrayList<>();

    public int[][] solution(int n) {
        /*
         * n개의 원판을 3번 원판으로 옮길 수 있는 최소 횟수
         * 원판 N개 옮기기
         * = 가장 큰 원판을 제외한 2개를 보조 기둥으로 옮긴다.
         * = 가장 큰 원판을 목적 기둥으로 옮긴다.
         * = 보조 기둥에 있던 2개의 원판을 목적 기둥으로 옮긴다.
         */

        /*
         * 반복 작업 :
         * = N-1개의 원판을 보조 기둥으로 옮긴다.
         *   = N-2개의 원판을 보조 기둥으로 옮긴다.
         *   = 1개의 원판을 목적 기둥으로 옮긴다.
         *   = ....(반복)
         * = 큰 원판을 목적 기둥으로 옮긴다.
         * = N-1개의 원판을 목적 기둥으로 옮긴다.
         */

        hanoi(n, 1, 2, 3);

        int[][] result = new int[answer.size()][2];

        for(int i = 0 ; i < answer.size() ; i++) result[i] = answer.get(i);

        return result;
    }

    static void hanoi(int n, int start, int mid, int end){

        if(n == 1){
            answer.add(new int[]{start, end}); //나머지 1개의 원판을 목적 기둥으로 옮김
            return;
        }

        hanoi(n - 1, start, end, mid); //n-1개 원판을 보조 기둥으로 옮긴다.

        answer.add(new int[]{start, end}); //가장 큰 원판을 목적 기둥으로 옮긴다.

        hanoi(n - 1, mid, start, end); //보조기둥의 원판들을 목적지로 이동한다.

    }
}
