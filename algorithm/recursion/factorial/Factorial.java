package algorithm.recursion.factorial;

public class Factorial {
    public int factorial(int n){
        //5! -> 5 4 3 2 1
        // = 5 * factorial(4)
        if(n == 1 || n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
