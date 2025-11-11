package week1.day3;

import java.io.*;
import java.util.*;

public class CheckBalancingByStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            sb.append(isBalanced(br.readLine())).append('\n'); //main -> this 불가
        }

        System.out.print(sb);
    }

    public static String isBalanced(String str){
        Stack<Character> stack = new Stack();

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }else if(stack.isEmpty()){
                return "NO";
            }else{
                stack.pop();
            }

        }

        if(stack.isEmpty())
            return "YES";
        else
            return "NO";
    }
}