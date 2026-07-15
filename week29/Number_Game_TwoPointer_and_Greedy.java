package week29;

import java.util.Arrays;

public class Number_Game_TwoPointer_and_Greedy {
    /*
     * 그리디만으론 부족함
     * 그리디 + 투포인터
     * 그리디 : 작은 A를 이기기 위해 큰 B를 사용할 필요는 없다.
     * 투포인터 : A가 이겼다면 B만 다음, B가 이겼다면 A/B 둘다 다음
     */
    public int solution(int[] A, int[] B) {
        //2*N, A - B팀
        //숫자 큰 쪽이 승리하고 숫자가 같다면 점수 없음
        //관건은 무조건 이겨야 한다는 것.

        //Arrays.sort(A, (a,b) -> a[0] - b[0]);
        //Arrays.sort(B, (a,b) -> a[0] - b[0]);
        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;
        int idxA = 0;
        int idxB = 0;
        //원소 10만개 : 1회 순회까지 허용
        while(true){

            if(idxA == A.length || idxB == B.length) break;

            int a = A[idxA];
            int b = B[idxB];

            if(a > b || a == b) {
                idxB++;
            }else {
                idxA++;
                idxB++;
                count++;
            }
        }

        return count;
    }
}
