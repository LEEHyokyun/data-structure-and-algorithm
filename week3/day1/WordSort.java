package week3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WordSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, Comparator
                .comparingInt(String::length) //함수
                .thenComparing(Comparator.naturalOrder())
        );

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        //싱글쿼터로 해야 개행으로 인식
        sb.append('\n');

        for(int i = 1 ; i < N ; i++){
            if(!arr[i].equals(arr[i-1])){
                sb.append(arr[i]);
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
