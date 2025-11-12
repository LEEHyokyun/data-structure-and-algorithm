package week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        //결과 누적 필요
        java.util.Deque<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){ //while(N-- >0) = 5회 순회
            String str = br.readLine();
            int result = getCommandResult(str, q);

            if(result != -99) sb.append(result).append('\n');
        }

        System.out.print(sb);
    }

    public static int getCommandResult(String str, java.util.Deque<Integer> q){
        StringTokenizer command = new StringTokenizer(str, " ");

        String c1 = command.nextToken();

        //String[] input = br.readLine().split(" ");
        //String c1 = input[0];
        //String c2 = input[1];

        int result = -99;

        switch(c1){
            case "push":
                int item0 = Integer.parseInt(command.nextToken());
                q.offer(item0);

                break;
            case "pop":
                Integer item1 = q.poll();

                if(item1 == null)
                    result = -1;
                else
                    result = item1;

                break;
            case "size":
                result = q.size();

                break;
            case "empty":
                result = (q.size() == 0 ? 1 : 0);

                break;
            case "front":
                Integer item2 = q.peek();

                if(item2 == null)
                    result = -1;
                else
                    result = item2;

                break;
            case "back":
                Integer item3 = q.peekLast();

                if(item3 == null)
                    result = -1;
                else
                    result = item3;

                break;

            //cf : offerFirst, pollFirst
        }

        return result;
    }
}
