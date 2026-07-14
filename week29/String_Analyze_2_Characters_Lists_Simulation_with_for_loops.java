package week29;

import java.util.ArrayList;
import java.util.List;

public class String_Analyze_2_Characters_Lists_Simulation_with_for_loops {
    public int solution(String str1, String str2) {
        //집합간 유사도
        //J(A,B)
        //A = 123 B = 234 -> AnB = 23 AuB = 1234 .. J(A,B) = 2/4 = 0.5
        //A = 0 / B = 0 -> J(A,B) = 1

        //문자열 -> 두글자 씩 끊어서 다중 집합 만들기
        //중간에 특수문자가 있다면 전후 문자열을 그대로 버린다(*ab!a => ab / b! 버리고 !a 버리고)

        /*
         * s.length() == 1000
         * 이중 반복 허용
         * 특수문자를 제거하지 않고 두글자씩 끊어서 Character.isLetter()인지 확인
         */

        List<String> list1 = toList(str1.toLowerCase());
        List<String> list2 = toList(str2.toLowerCase());

        int commons = 0;
        int unions = 0;

        //for(element : list)할 경우, 중간에 바꾸려고 하면 안됨(Modification Exception 발생)
        //안전하게 for 순회로 교정
        for(int i = 0 ; i < list1.size() ; i++){
            for(int j = 0 ; j < list2.size() ; j++){
                if(list1.get(i).equals(list2.get(j))){
                    commons++;

                    list1.remove(i);
                    list2.remove(j);

                    //remove할 경우 순서가 달라지므로, 현재 인덱스로 다시 돌아가서 재탐색해야한다.
                    //즉 큰 순회(i)를 다시 현재 위치로 조정해주고, 바뀐 상태에서 반복 다시 진행
                    i--;
                    break;
                }
            }
        }

        unions = list1.size() + list2.size() + commons; //size() -> null일 경우 0, NPE (X)

        if(unions == 0) return 65536;
        return (int) ((double) commons / unions * 65536);
    }

    static List<String> toList(String s){

        List<String> list = new ArrayList<>();

        //두글자 문자열 분해 리스트
        for(int i = 0 ; i < s.length() - 1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);

            if(Character.isLetter(c1) && Character.isLetter(c2)) list.add("" + c1 + c2);

        }

        return list;
    }
}
