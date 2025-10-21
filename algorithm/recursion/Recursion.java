package algorithm.recursion;

public class Recursion {
    /*
    * key point : 탈출(기저)조건.
    * */
    public void myFunction(int num){
        if(num > 10 ) return;
        System.out.println(num);
        myFunction(num + 1);
    }
}
