package week27;

public class CountOfOne_bitCountMethod {
    public int solution(int n) {
        int count = Integer.bitCount(n);

        int target = n + 1;
        while(count != Integer.bitCount(target)){
            target = target  +1;
        }

        return target;
    }
}
