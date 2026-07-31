package week31;

public class N_Number_Game_with_String_Utils_Long_toString {
    public String solution(int n, int t, int m, int p) {
        //n - n진법, t - 구해야하는 숫자의 갯수, m - 참가 인원, p - 자신의 순서
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < (m * t) ; i++){
            //1번째 (idx 0) -> n진법 수 0
            //2번째 (idx 1) -> n진법 수 1
            //p번째 (idx i) -> n진법 수 i
            String value = Long.toString(i, n);
            sb.append(value.toUpperCase());
        }

        //System.out.println("t를 n진법 수로 변환 시  : " + number);
        //System.out.println("최종 변환 진법수 : " + sb.toString());

        String answer = "";
        for(int i = 0 ; i < t ; i++){
            //구한 숫자에서
            //p, p + m
            //번째 -> 인덱스로 치면 -1
            answer = answer + sb.toString().charAt((p-1) + m * i);
        }

        return answer;

    }
}
