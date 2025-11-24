package week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //1 ~ N까지의 수는 이미 주어져있고 stack 자료구조를 활용한다.
        //주어진 수열을 만들 수 있는가.
        //key point :  push는 언제든지 가능, pop하는 시점에 다르면 무조건 불가능
        int N = Integer.parseInt(br.readLine());
        int turn = 1; //다음에 넣어야 할 값

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(N-- > 0){
            int target = Integer.parseInt(br.readLine());

            //target까지 push
            while(turn <= target){
                stack.push(turn);
                sb.append("+").append('\n');
                turn++;
            }

            //같으면 pop
            if(stack.peek() == target){
                stack.pop();
                sb.append("-").append('\n');
            }else{
                //다르면 불가
                System.out.print("NO");
                return;
            }
        }

        System.out.print(sb);
    }
}
