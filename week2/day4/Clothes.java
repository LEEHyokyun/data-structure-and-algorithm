package week2.day4;

import java.util.Arrays;

public class Clothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        //greedy : 가장 가까운 학생에게 먼저 체육복을 빌려준다.
        //greedy : 여벌 체육복이 있으면 먼저 본인을 살리고, 그 이후에 가까이 있는 친구에게 빌려준다.

        //학생번호와 매칭하기 위함, n+1
        int[] clothes = new int[n+1];

        //일단 모두 학생 옷 부여
        Arrays.fill(clothes, 1);

        //lost
        for(int num : lost){
            clothes[num]--;
        }

        //reserve
        for(int num : reserve){
            clothes[num]++;
        }

        //greedy
        for(int i = 1 ; i <= n ; i++){
            //옷이 없으면 빌린다.
            if(clothes[i] == 0){
                //옷이 없으면 빌리는데, 왼쪽학생에게 먼저 빌린다.
                if(i > 1 && clothes[i-1] == 2){
                    clothes[i-1]--;
                    clothes[i] ++;
                    //처음 학생에 대해서만 오른쪽에게 빌린다.
                    //이 분기처리를 먼저 두게되면 오른쪽 학생에게 빌린다.
                    //최초 시작부터 오른쪽에게 빌리고, 마지막 학생이 왼쪽에게 빌리는 것은 모순.
                }else if(i < n && clothes[i+1] == 2){
                    //최초 경우에 대해서만 오른쪽한테 빌린다.
                    clothes[i+1]--;
                    clothes[i] ++;
                }
            }
            //옷이 있으면 그 상태가 최선임
        }

        //counting
        for(int i = 1 ; i < clothes.length ; i++){
            if (clothes[i] > 0) answer++;
        }

        return answer;
    }
}
