package week3.day5;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Comparator1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //짧은것부터
        //숫자합 작은것부터
        //사전순(숫->영)

        String[] arr = new String[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine();
        }

        //Comparator
        Arrays.sort(arr,
                Comparator
                        .comparingInt(String::length)
                        .thenComparingInt(Comparator1::sumDigits)
                        .thenComparing(Comparator.naturalOrder())
        );

        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }

    static int sumDigits(String s){
        int sum = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) sum = sum + (c - '0');
        }

        return sum;
    }
}
