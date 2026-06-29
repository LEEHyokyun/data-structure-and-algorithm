package week27;

public class CountOfOne_WhileLoop {
    public int solution(int n) {
        int countOfOne = getCountOfOne(n);

        int res = 0;
        int target = n + 1;
        while(getCountOfOne(n) != getCountOfOne(target)){
            target = target + 1;
        }

        return target;
    }

    static int getCountOfOne(int n){

        int count = 0;

        //System.out.println(n + " 탐색 시작");

        //5 -> (1) -> 101
        while(n != 0){

            if(n % 2 == 1) count++;

            n = n / 2;
        }

        System.out.println("1의 개수 : " + count);

        return count + 1;
    }
}
