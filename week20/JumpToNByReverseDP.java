package week20;

public class JumpToNByReverseDP {
    public int solution(int n) {

        // +K(소모) or *2(소모x)
        // 건전지 사용량의 최소값

        //idx까지 가는데 소요된 건전지 사용량
        // int[] count = new int[n+1];
        // count[0] = 0;
        // count[1] = 1;
        int N = n;

        //1 2 4 8 16 32 64 ...
        //1 2 3 4 5 6 ...

        //dp
        //출발지 = 0
        int count = 0;
        while(N > 0){ //when N == 0 -> 종료
            if(N % 2 == 0){
                N = N/2;
            }else {
                N = N-1;
                count++;
            }
        }

        return count;
    }
}
