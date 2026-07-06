package week28;

public class JoyStick_Greedy {
    /*
     * 이것이 그리디인 이유?
     * - 좌우 이동이 핵심.
     * - 좌우 이동을 누적하는 것이 아니라
     * - 여러번 누적해서 왔다갔다 하는 것 보다, A가 여러번 연속하여 있을때 방향을 바꾸느냐, 그대로 가느냐 이것을 유리하게 선택하는 것이 전체의 해이다.
     * - 이 문제가 그리디인 이유이다.
     */

    public int solution(String name) {
        //AAA -> ???
        int n = name.length();

        //조작 횟수 = 상하 + 좌우
        int cUD = 0;

        for(int i = 0 ; i < n ; i++){

            char c = name.charAt(i);
            cUD += Math.min(c - 'A', 'Z' - c + 1);

        }

        //첫번째에서 문자열 끝으로 이동하였을때
        int cLR = n - 1;

        for(int i = 0 ; i < n ; i++){
            int next = i + 1;

            //A면 안움직여도 됨, A가 없어지는 부분을 찾는다.
            while(next < n && name.charAt(next) == 'A'){
                next++;
            }

            //3글자, AAIA -> 2번 이동
            //오른쪽 이동 = 현재 위치 = 방향을 바꾸기로 결정한 최초 지점
            cLR = Math.min(
                    cLR,
                    Math.min(
                            //기본적으로 해당 위치까지 이동하는게 포함됨 = i
                            2 * i + (n - next),
                            i + 2 * (n - next)
                    )
            );
            //오른쪽 접근 + 왼쪽으로 되돌아오기 = 현재위치 = i * 2번 + n - next
            //왼쪽 접근 + 오른쪽으로 되돌아오기 = 현재위치 = i + 2 * (n - next)
        }

        return cLR + cUD;
    }
}
