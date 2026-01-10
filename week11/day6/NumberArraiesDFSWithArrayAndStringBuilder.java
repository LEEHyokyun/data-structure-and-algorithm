package week11.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberArraiesDFSWithArrayAndStringBuilder {
    static char[] list;
    static StringBuilder sb = new StringBuilder();
    //static boolean[] selected;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        //L개 알파벳 조합
        //최소 1개 이상의 a e i o u
        //최소 2개 이상의 b c d..
        //증가순 = 순열
        //문자는 C개 안에서.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(token1.nextToken());
        int C = Integer.parseInt(token1.nextToken());

        //selected = new boolean[C];
        list = new char[C];
        arr = new char[L];
        //String s = br.readLine();
        for(int i = 0 ; i < C ; i++){
            list[i] = token2.nextToken().charAt(0); //항상 첫째자리
        }
        //list = token2.nextToken().toCharArray();

        //사전순
        Arrays.sort(list);

        dfs(L, C, 0, 0);
        System.out.print(sb.toString());
    }

    static void dfs(int L, int C, int start, int count){

        if(count == L){
            //만족할때만 append, 아니면 그대로 백트래킹
            if(isValid(arr)){
                sb.append(arr).append('\n');
            }
            return;
        }

        //모음(a e i o u) >= 1, 자음 >= 2
        for(int i = start ; i < C ; i++){
            arr[count] = list[i]; //첫번째 문자열은 항상 달라질 수 있다.
            dfs(L, C, i + 1, count + 1);
        }
    }

    static boolean isValid(char[] arr){
        int mo = 0 ;
        int ja = 0;

        for(char c : arr){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                mo++;
            }else{
                ja++;
            }
        }

        if(mo >= 1 && ja >= 2) return true;
        return false;
    }
}
