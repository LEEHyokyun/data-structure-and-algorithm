package week31;

import java.util.HashSet;
import java.util.Set;

public class find_reached_edges_with_simulation_and_hashSet {
    static int[] dx = {0,0,1,-1};      //UDRL
    static int[] dy = {1,-1,0,0};

    public int solution(String dirs) {

        //대각선은 고려할 필요 없음
        //간선(edge)의 양방향을 넣고 이에 대한 존재 여부만 판별하면 됨
        Set<String> edge = new HashSet<>();

        int startX = 0;
        int startY = 0;

        //System.out.println("시작점 : " + startX + ", " + startY);

        int answer = 0;

        for(char c : dirs.toCharArray()){

            int cx = 0;
            int cy = 0;

            if(c == 'U'){

                cx = startX + dx[0];
                cy = startY + dy[0];


            }else if(c == 'D'){

                cx = startX + dx[1];
                cy = startY + dy[1];

            }else if(c == 'R'){

                cx = startX + dx[2];
                cy = startY + dy[2];

            }else if(c == 'L'){

                cx = startX + dx[3];
                cy = startY + dy[3];

            }

            //System.out.println(c + " 이동 후 : " + cx + ", " + cy);
            //좌표면 경계
            if(cx < -5 || cy < -5 || cx > 5 || cy > 5) continue;

            String forward = startX + "," + startY + ":" + cx + "," + cy;
            String back = cx + "," + cy + ":" + startX + "," + startY;

            if(!edge.contains(forward) && !edge.contains(back)) {
                //System.out.println("지나가지 않은 간선이므로 answer+");
                answer++;
                edge.add(forward);
                edge.add(back);
            }

            startX = cx;
            startY = cy;
        }

        return answer;
    }
}
