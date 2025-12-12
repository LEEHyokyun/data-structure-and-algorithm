package week6.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSForString {
    static String S = "";
    static String T = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        //문자열 뒤에 A추가          -> ___A
        //문자열 뒤에 B추가 + 뒤집기  -> B___

        //역 dfs
        //역으로 dfs 탐색, 문자열 S? OK.
        //앞의 A제거
        //뒤집고 뒤의 B제거

        boolean isPossible = dfs(T);

        System.out.println(isPossible == true ? 1 : 0);
    }

    static boolean dfs(String T){
        if(T.equals(S)) return true;
        if(T.length() < S.length()) return false;

        boolean result = false;

        if(T.charAt(T.length() - 1) == 'A'){     //앞 A제거
            result |= dfs(T.substring(0, T.length() - 1)); //뒤의 false 누적을 위하 OR연산
        }

        if(T.charAt(0) == 'B'){   //뒤집고 앞 B제거
            String reversed = new StringBuilder(T).reverse().toString();
            String removed = reversed.substring(0, reversed.length() - 1);
            result |= dfs(removed);
        }

        return result;
    }
}
