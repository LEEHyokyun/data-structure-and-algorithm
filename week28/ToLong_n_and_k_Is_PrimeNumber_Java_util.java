package week28;

public class ToLong_n_and_k_Is_PrimeNumber_Java_util {
    public int solution(int n, int k) {

        String val = Long.toString(n, k); //n -> k 진법수

        int answer = 0;

        String[] list = val.split("0+");


        for(String num : list){
            if(isPossible(Long.parseLong(num))) answer++;
        }

        return answer;
    }

    static boolean isPossible(long val){

        if(val == 1) return false;
        if(val == 2) return true;
        if(val == 3) return true;
        if(val % 2 == 0) return false;

        for(long i = 2 ; i * i <= val ; i++){
            if(val % i == 0) return false;
        }

        return true;

    }
}
