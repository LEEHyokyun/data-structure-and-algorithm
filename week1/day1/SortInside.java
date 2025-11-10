package week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortInside {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();

        /*
        * sort : 정방향 정렬
        * charToArry : char[]
        * 정방향 정렬 후 역방향 출력 필요.
        *
        * Comparator를 사용할 경우 ch -> 원시형타입은 Type 불가, Character -> char[] 형식을 상속받지 않은 타입이므로 불가
        * 애초에 char[]는 Comparator를 사용할 수 없음
        * */
        Arrays.sort(ch);

        for(int i = ch.length - 1; i >= 0 ; i--) {
            System.out.print(ch[i]);
        }
    }
}
