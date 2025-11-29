package week4.day3;

public class BruteForce {
    //완전탐색
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;

        //i,j,k가 모두 다른 인덱스를 보장
        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i+1 ; j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    if(number[i] + number[j] + number[k] == 0)
                        answer+=1;
                }
            }
        }

        return answer;
    }
}
