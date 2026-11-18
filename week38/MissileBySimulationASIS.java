package week38;

import java.util.ArrayList;
import java.util.List;

public class MissileBySimulationASIS {
    static class Missile{

        private int start;
        private int end;

        public Missile(int start, int end){
            this.start = start;
            this.end = end;
        }

    }

    static List<Missile> list = new ArrayList<>();

    public int solution(int[][] targets) {
        /*
         * A(공격) -> B(수비)
         * 미사일을 최소로 사용하면서 모든 폭격 미사일을 요격
         * A : x축 평행, (s,e) 개구간 .. 반드시 이 범위 내에서 요격해야 함
         * B : y축 평행, 특정 x 좌표의 모든 미사일 요격 가능
         * 모든 미사일을 요격하기 위해 필요한 요격 미사일 수의 최소값
         */

        for(int[] target : targets) {
            list.add(
                    new Missile(
                            target[0],
                            target[1]
                    )
            );
        }

        list.sort((a,b) -> {

            if(a.start == b.start) return a.end - b.end;

            return a.start - b.start;
        });

        /*
         * 구하고자 하는 core를 한문장으로 표현한다.
         * 이전의 끝부분이 다음의 시작점 "초과" 끝점 "미만"이면 count;
         */

        int start = 0;
        int end = 0;
        int answer = 0;

        for(int i = 0 ; i < list.size() ; i++){
            if(i == 0) {
                start = list.get(i).start;
                end = list.get(i).end;
                answer++;
            }else {
                if(list.get(i).start < end) continue;
                else {
                    answer++;
                    start = list.get(i).start;
                    end = list.get(i).end;
                }
            }
        }

        return answer;
    }
}
