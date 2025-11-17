package week2.day2;

import java.util.Arrays;
import java.util.HashMap;

public class Pokemon {
    public static int solution(int[] nums){
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            //if(!map.containsKey(num))
            //    map.put(num, num);

            //분기처리 제외하고 단순화
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //stream 활용가능
        //int count = Integer.parseInt(Arrays.stream(nums).distinct().count());  //String > Integer / int
        int count = (int) Arrays.stream(nums).distinct().count(); // int
        //int count = Arrays.stream(nums).sum();
        //int count = Arrays.stream(nums).distinct().sum();

        /*
        * 이정도의 문제는 어느정도 방향을 스스로 잡을 필요가 있다.
        * 계산문제보다는 사고력의 문제
        * 중복을 제거한 배열의 크기와 원본 배열의 반의 크기 중 최소값.
        * */

        return Math.min(map.size(),nums.length/2);
    }
}
