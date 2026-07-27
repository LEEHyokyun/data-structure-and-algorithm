package week31;

import java.util.Arrays;

public class Clothes_Borrowing_with_greedy_and_int_array {
    public int solution(int n, int[] lost, int[] reserve) {
        //reserve 학생이 빌려준 경우
        //reserve가 있는데 lost까지 있어서 못빌려주는 경우
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);

        //0 : 잃어버림, 1 : 정량, 2 : 여분있음
        for(int l : lost) clothes[l]--;
        for(int r : reserve) clothes[r]++;

        for(int i = 0 ; i < clothes.length ; i++){

            //옷이 없는 경우에만(판별 대상 : i번 인원)
            if(clothes[i] == 0){

                if(i == 1){
                    int v1 = i + 1;
                    if(clothes[v1] > 1){
                        clothes[v1]--;
                        clothes[i]++;
                    }
                }else {
                    int v1 = i - 1;
                    int v2 = i + 1;

                    if(clothes[v1] > 1){
                        clothes[v1]--;
                        clothes[i]++;

                        continue;
                    }

                    if(v2 > n) break; //v2 > clothes.length (=n+1) .. length - 1
                    if(clothes[v2] > 1){
                        clothes[v2]--;
                        clothes[i]++;

                        continue;
                    }
                }

            }

        }

        int answer = 0;
        for(int i = 1 ; i < clothes.length ; i++) {
            if(clothes[i] >= 1) answer++;
        }

        return answer;
    }
}
