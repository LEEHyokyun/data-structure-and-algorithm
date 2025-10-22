package algorithm.recursion.hanoi;

import algorithm.recursion.Recursion;

public class Test {
    public static void main(String[] args){
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3, "A", "C", "B");
    }
}
