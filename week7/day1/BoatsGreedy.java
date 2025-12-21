package week7.day1;

import java.util.Arrays;

public class BoatsGreedy {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int boats = 0;
        int start = 0;
        int end = people.length - 1;

        while(start <= end){
            if(people[start] + people[end] <= limit){
                start++; //만족할때만 가벼운 사람 태우기
            }
            end--;       //무거운 사람은 무조건 태우기

            boats++;
        }

        return boats;
    }
}
