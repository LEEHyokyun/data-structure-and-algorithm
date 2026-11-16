package week38;

import java.util.ArrayList;
import java.util.List;

public class JadenCaseByTypeCastingAndDataStructure {
    static List<String> list1;
    static List<String> list2;

    public int solution(String str1, String str2) {
        /*
         * J(A,B) = 두 집합의 교집합(min) 크기 / 두 집합의 합집합(max) 크기
         * - 각 집합은 중복 허용
         * - str1, str2의 문자열을 두 글자씩 끊어서 다중집합 원소 생성
         */
        List<String> list1 = getList(str1.toLowerCase());
        List<String> list2 = getList(str2.toLowerCase());

        List<String> common = new ArrayList<>();

        /*
         * list1 기준 순회 : 교집합일 경우 별도 배치 + 각 list에서 제거
         * common = 겹치는 횟수
         * 합집합 = 겹치는거는 1개로 카운팅한 합집합
         */
        for(String s1 : list1){
            if(list2.contains(s1)) {
                //System.out.println("공통인지 확인하세요 : " + s1);
                list2.remove(s1);
                //list1.remove(s1);
                common.add(s1);
            }
        }

        //System.out.println("list1 size : " + list1.size());
        //System.out.println("list2 size : " + list2.size());
        //System.out.println("common size : " + common.size());

//        return 0;

        /*
         * 0.4 라는 숫자를 남기려면 (double)로 형변환 필요
         */

        if(list1.size() + list2.size() == 0) return 65536;

        return (int)
                (((double)
                        common.size()
                        /
                        (list1.size() + list2.size())
                )* 65536
                );

    }

    static List<String> getList(String str){

        List<String> res = new ArrayList<>();

        for(int i = 0 ; i < str.length() ; i++){

            if(i == str.length() - 1) break;

            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);

            /*
             * StringBuilder에 추가해서 결과 누적하는게 아니라 list에 바로 추가(원하는건 그룹쌍)
             */
            if(Character.isLetter(c1)){
                if(Character.isLetter(c2)) {

                    res.add("" + c1 + c2);

                }
            }
        }

        return res;
    }
}
