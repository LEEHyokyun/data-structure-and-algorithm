package week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class IntSort {
    public static void main(String[] args) throws IOException {
        //java io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Integer import X
        int N = Integer.parseInt(br.readLine());  //br.readLine은 항상 문자열을 반환한다.
        /*
         * Integer.parseInt or Integer.valueOf
         * */

        Integer[] arr = new Integer[N];

        //String[] arr = new String[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.valueOf((br.readLine()));
        }

        //java util
//        Arrays.sort(arr, new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2){
//                if(s1.length() == s2.length())
//                    //단어 정방향 정렬
//                    return s1.compareTo(s2);
//                else
//                    return s1.length() - s2.length();
//            }
//        });
//        Arrays.sort(arr, Comparator
//                .comparingInt(String::length)
//                .thenComparing(Comparator.naturalOrder())
//        );

        Arrays.sort(arr);
        //Arrays.sort(arr, Comparator.comparingInt(Integer::intValue));

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append('\n');

        for(int i = 1; i< N; i++){
            if(arr[i] != arr[i-1])
                sb.append(arr[i]).append('\n');  //index 1부터 삽입 시작, index 0은 초기값으로 반드시 초기화 필요
        }
        System.out.println(sb);
    }
}
