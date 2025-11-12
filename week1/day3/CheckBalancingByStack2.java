package week1.day3;

import java.io.*;
import java.util.*;

public class CheckBalancingByStack2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        //for(int i = 0 ; i < N ; i++){
        //    if(i < N-1)
        //        sb.append(isBalancing(br.readLine())).append('\n');
        //    else
        //        sb.append("yes");
        //}

        String line = "";
        while(!(line=br.readLine()).equals(".")){
            //br.readLine() 두번 호출 -> 줄 두번 넘어감
            //sb.append(isBalancing(br.readLine())).append('\n');
            sb.append(isBalancing(line)).append('\n');
        }

        System.out.print(sb);
    }

    public static String isBalancing(String str){
        Stack<Character> stack = new Stack();
        String result = "yes";

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '[')
                stack.push(ch);
            else if(ch == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return "no";
                }
                stack.pop();
            }else if(ch == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return "no";
                }
                stack.pop();
            }

        }

        if(!stack.isEmpty())
            result = "no";
        else
            result = "yes";

        return result;
    }

}