package week2.day3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayWithoutDuplicating {
    public class Solution {
        public int[] solution(int []arr) {
            //int[] answer = {};      -> 아직 객체초기화 안된 상태 ArrayIndexOutOfBounds 오류 발생


            //중복을 제거하고 바로 배열로 반환해주는 API도 기억해둘 것
            //Arrays.stream(arr).distinct().toArray();

            Queue<Integer> q = new LinkedList<>();
            int prev = -1;
            for(int num : arr){
                //if(!q.contains(num))  //linkedList의 contains는 O(N)으로 성능이 좋지 않다.
                //    q.offer(num);     //HashSet / Stream 기반으로 변환하여 O(1) 성능 개선 필요.
                if(prev != num){
                    q.offer(num);
                }
                prev = num;
            }

            int N = q.size();
            int[] answer = new int[N];   //객체 초기화 반드시 필요하다.

            for(int i = 0 ; i < N ; i++){
                answer[i] = q.poll();
            }

            /*
            * int prev = -1;
            * Arrays.stream(arr)
            * .filter(n -> n != (prev = (prev == n? prev : n))
            * .toArray();
            * ---filter -> 기본적으로 "필터링", 즉 통과한 요소만 컬렉트.
            * ----prev와 n이 다를때 prev 값을 갱신
            * n -> {
             *    if( prev == n)
             *       prev = prev;
             *    else
             *       prev = n;
             *       })
            * */

            return answer;
        }
    }
}
