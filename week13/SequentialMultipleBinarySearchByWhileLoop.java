package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequentialMultipleBinarySearchByWhileLoop {
    static long A;
    static long B;
    static long C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        long answer = bs(A, B);

        System.out.println(answer);
    }

    static long bs(long A, long B){

        long result = 1;
        A = A % C;

        while(B > 0){
            if(B % 2 == 1){
                result = result * (A % C);
            }

            //A^4 % C = (A^2 % C) * (A^2 % C)
            //bottom up .. A^2를 C로 나누는 과정을 B의 분할 개수만큼 반복순회
            A = (A * A) % C;
            B = B / 2;
        }

        return result;
    }
}
