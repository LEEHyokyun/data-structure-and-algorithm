package week33;

public class NumberWithN_with_String_Simulation_Util_IntegerToString_및_최초_범위_조정값_도출 {
    public String solution(int n, int t, int m, int p) {
        //Integer.toString(v, n)
        StringBuilder pool = new StringBuilder();

        //튜브의 순서(p)부터 최소한 숫자가 t번까지 일단 구해본다.(*모두 부른다고 가정할 경우)
        for(int i = 0 ; i < m * t ; i++){
            pool.append(Integer.toString(i, n).toUpperCase());
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < t ; i++){
            char c = pool.charAt((p - 1) + i * m);

            //튜브의 순서는 p
            //1번째 -> 인덱스 0 / 0 + 4 / 0 + 4 * 2 ..
            answer.append(c);
        }

        return answer.toString();
    }
}
