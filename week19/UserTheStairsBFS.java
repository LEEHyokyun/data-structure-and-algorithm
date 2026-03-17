package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UserTheStairsBFS {
    static long[] count;
    static int F,S,G,U,D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //건물 총 F층
        //스타트링크는 G층에 있고
        //강호는 지금 S층에 있고
        //엘리베이터를 타고 G층에 가려고 해
        //엘리베이터는 UP or DOWN

        //버튼을 적어도 몇번 = 최소값 = bfs
        StringTokenizer token = new StringTokenizer(br.readLine());

        F = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        G = Integer.parseInt(token.nextToken());
        U = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());

        if(S == G) {
            System.out.println(0);
            return; //멈추고 싶으면 return
        }

        //해당 index 층에 가기 위해 버튼을 몇번 눌렀나
        count = new long[F+1];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == G) {
                System.out.println(count[G]);
                return;
            }
            //이미 간 곳은 최소값을 보장해야 하기에 연산 불가
            if(cur + U <= F && count[cur + U] == 0 && U > 0) {
                q.offer(cur + U);
                count[cur + U] = count[cur] + 1;
            }

            if(cur - D >= 1 && count[cur - D] == 0 && D > 0) {
                q.offer(cur - D);
                count[cur - D] = count[cur] + 1;
            }

        }

        System.out.println("use the stairs");
    }
}
