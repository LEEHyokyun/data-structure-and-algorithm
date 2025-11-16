package week2.day1;

import java.util.*;

class ArrayCopyOfRange {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];  //초기화

        for(int i = 0 ; i < commands.length ; i++){
            int[] command = commands[i];
            int from = command[0] - 1;  //from = index
            int to = command[1];          //to = 그"번째" 전번째까지
            int k = command[2] - 1;

            int[] sliced = Arrays.copyOfRange(array, from, to); //raw-from-to
            Arrays.sort(sliced);

            answer[i] = sliced[k];
        }

        return answer;
    }
}