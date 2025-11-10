package week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WordSort {
    public static void main(String[] args) throws IOException {
        //java io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Integer import X
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine();
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
        Arrays.sort(arr, Comparator
                .comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder())
        );

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append('\n');

        for(int i = 1; i< N; i++){
            if(!arr[i].equals(arr[i-1]))
                sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}