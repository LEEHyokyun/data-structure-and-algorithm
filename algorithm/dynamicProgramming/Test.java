package algorithm.dynamicProgramming;

import algorithm.recursion.Recursion;

import java.util.Hashtable;

public class Test {
    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fibonacciWithMemoization(5, new Hashtable<>());
        System.out.println(result);
    }
}
