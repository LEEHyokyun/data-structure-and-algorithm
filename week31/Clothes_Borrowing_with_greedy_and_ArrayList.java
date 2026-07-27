package week31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clothes_Borrowing_with_greedy_and_ArrayList {
    List<Integer> lostList = new ArrayList<>();
    List<Integer> reservedList = new ArrayList<>();

    public int solution(int n, int[] lost, int[] reserve) {
        //reserve 학생이 빌려준 경우
        //reserve가 있는데 lost까지 있어서 못빌려주는 경우
        //최적의 해 = n - lost - reserve + reserve + reserver가 빌려준 인원
        int normalCount = n - lost.length - reserve.length;
        int reservedCount = reserve.length;

        for(int i = 0 ; i < lost.length ; i++) lostList.add(lost[i]);
        for(int i = 0 ; i < reserve.length ; i++){
            if(lostList.contains(reserve[i])) {
                //System.out.println("여분이 있으면서 도난 맞은 학생(본인거 착용) : " + reserve[i]);
                lostList.remove(reserve[i]);
                reservedCount--;
                normalCount++;
            }else {
                //System.out.println("여분 체육복 인원 추가 : " + reserve[i]);
                reservedList.add(reserve[i]);
            }
        }

        int lostCount = 0;
        Collections.sort(lostList);
        for(int i = 0 ; i < lostList.size() ; i++){

            int cur = lostList.get(i);
            System.out.println("현재 인원 : " + cur);

            int v1 = cur - 1;
            int v2 = cur + 1;
            System.out.println("가능 후보1 : " + v1);
            System.out.println("가능 후보2 : " + v2);

            if(reservedList.contains(v1) || reservedList.contains(v2)){
                System.out.println("가능 후보1 가능? : " + reservedList.contains(v1));
                System.out.println("가능 후보2 가능? : " + reservedList.contains(v2));

                if(reservedList.contains(v1)){
                    lostCount++;
                    reservedList.remove(reservedList.indexOf(v1)); //값을 지우는게 아니라 인덱스를 지워야 한다.
                    continue;
                }

                if(reservedList.contains(v2)){
                    lostCount++;
                    reservedList.remove(reservedList.indexOf(v2));
                    continue;
                }
            }

        }

        return normalCount + reservedCount + lostCount;
    }
}
