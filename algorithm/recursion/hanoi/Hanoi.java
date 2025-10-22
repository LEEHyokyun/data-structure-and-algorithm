package algorithm.recursion.hanoi;

public class Hanoi {
    public void hanoi(int num, String from, String to, String with){
        if(num == 0) {
            System.out.println("더이상 옮길 원반이 없습니다.");
            return;
        };
        /*
        * 최초시작 - 3개의 원반을 A to C.
        * 이를 위해 하향식 접근 1 - 먼저 2개의 원반을 A to B --이 시점에서 기둥 A에는 가장 큰 원반 1개만 존재
        * 이를 위해 하향식 접근 2 - 나머지 기둥 B에 있는 원반 2개를 기둥 C로 --그럼 종료
        * */
        hanoi(num - 1, from, with, to);
        System.out.println(String.format("원반 %d를 %s에서 %s로 이동", num, from, to));
        hanoi(num - 1, with, to, from);
    }
}
