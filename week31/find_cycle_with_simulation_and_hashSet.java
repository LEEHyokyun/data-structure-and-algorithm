package week31;

import java.util.HashSet;
import java.util.Set;

public class find_cycle_with_simulation_and_hashSet {
    static int[] dx = {0,1,1,1,0,-1,-1,-1}; // 0 ~ 6
    static int[] dy = {1,1,0,-1,-1,-1,0,1}; // 0 ~ 6

    public int solution(int[] arrows) {
        //시계 방향, 0(위쪽)부터 시작
        //사이클이 생겼는가 : 이미 방문한 정점에 지나가지 않은(새로운) 간선으로 도착하는 순간
        //대각선 교차 = 교차점이 생김 = 반으로 쪼개서 생각하는 방향

        /*
         * 방문 정점
         */
        //Set<int[]> vertex = new HashSet<>();
        Set<String> vertex = new HashSet<>();

        /*
         * 지나간 간선(앞/뒤 2개로 지나갔는지 여부를 확인)
         */
        //Set<int[]> edge = new HashSet<>();
        Set<String> edge = new HashSet<>();

        int startX = 0;
        int startY = 0;

        int answer = 0;

        //vertex.add(new int[]{startX, startY});
        vertex.add(startX + "," + startY);

        for(int arrow : arrows){

            //대각선 교차 처리를 위해 반으로 쪼개서 이동(2번 이동)
            for(int i = 0 ; i < 2 ; i++){

                int cx = startX + dx[arrow] ;
                int cy = startY + dy[arrow] ;

                //int[] next = new int[]{cx, cy};
                String next = cx + "," + cy;

                //정방향 : 시작점 > 이동지점
                //역방향 : 이동지점 > 시작점
                //int[] forward = new int[]{startX,startY,cx,cy};
                //int[] back = new int[]{cx,cy,startX,startY};
                String forward = startX + "," + startY + ":" + cx + "," + cy;
                String back = + cx + "," + cy + ":" + startX + "," + startY;

                /*
                 * 방문한 정점을 한번 더 도착하였으며,
                 * 이미 지나간 간선을 사용하지 않고 새롭게 도착한 경우 사이클 생성
                 * 참조형이 아닌 반드시 String과 같은 내용비교 기반의 판별식을 사용할 것
                 */
                //System.out.println("startX / startY : " + startX + " " + startY);
                //System.out.println("cx / cy : " + cx + " " + cy);

                if(vertex.contains(next) && !edge.contains(forward) && !edge.contains(back)){
                    //System.out.println("조건 만족");
                    answer++;
                }

                vertex.add(next);
                edge.add(forward);
                edge.add(back);

                startX = cx;
                startY = cy;
            }

        }

        return answer;

    }
}
