package week4.day6;

public class Joystick {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        //알파벳 변환의 최소값 = min(A오름차순, Z내림차순)
        //건너뛰기 - 어디까지 가야 할지 혹은 어디서 되돌아가야할지.
        //최종적으로 상하이동비용의 최소 + 좌우이동비용의 최소

        //상하
        for(int i = 0 ; i < length ; i++){
            char c = name.charAt(i);
            //문자의 거리 A로부터의 거리 혹은 Z로부터의 거리
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        //좌우
        int minMove = length - 1; //첫번째 인덱스부터 끝까지 정방향으로 이동했을때

        for(int i = 0 ; i < length ; i++){
            int next = i + 1;

            while(next < length && name.charAt(next) == 'A'){
                next++;
            }

            //위에서 이미 모두 바꾼 상태
            //A를 제외한 모든 경로를 탐색하는 최소값을 도출하면 된다.
            //A구간의 길이를 도출한 상태.
            //i까지 이동해서 A가 연속된 구간을 만났기에 경로를 탐색하는 최소 경로를 구하는 과정.
            minMove = Math.min(minMove, i*2 + (length - next));  //오 -> 왼
            minMove = Math.min(minMove, i + 2*(length - next)); // 왼 -> 오
        }

        return answer + minMove;
    }
}
