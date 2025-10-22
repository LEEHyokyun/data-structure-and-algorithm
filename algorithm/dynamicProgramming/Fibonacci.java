package algorithm.dynamicProgramming;

import java.util.Hashtable;

public class Fibonacci {
    public int fibonacci(int n){
        if(n==0 || n==1) return n;
            return fibonacci(n-1) + fibonacci(n-2);
            /*
            * 같은 과정(로직)을 중복하여 호출 및 처리..성능적 하자점 발생.
            * */
            /*
            * 빠른 데이터 삽입/삭제/탐색이 가능한 해쉬테이블 이용
            * 평균적으로 O(1)의 시간복잡도로 매우 효율적!
            */
    }

    public int fibonacciWithMemoization(int n, Hashtable<Integer, Integer> memo){
        if(n==0 || n==1) return n;

        if(!memo.containsKey(n))
            memo.put(n, fibonacciWithMemoization(n-1, memo) + fibonacciWithMemoization(n-2, memo));

        return memo.get(n);
    }
}
