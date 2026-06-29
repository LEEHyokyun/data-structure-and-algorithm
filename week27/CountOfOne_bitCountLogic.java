package week27;

public class CountOfOne_bitCountLogic {
    public int solution(int n) {
        int count = getCountOfOne(n);

        int target = n + 1;
        while(count != getCountOfOne(target)){
            target = target + 1;
        }

        return target;
    }

    static int getCountOfOne(int n){
        int count = 0;

        while(n != 0){
            if((n & 1) == 1) { //끝자리가 1인지 확인
                count ++;
            }

            n >>= 1; //비트시프트(오른쪽)
        }

        return count;
    }
}
