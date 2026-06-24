package week26_exercising;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRU_MapAndCacheSize {
    public int solution(int cacheSize, String[] cities) {
        /*
         * LRU : Least Recently Used, 캐시 교체 알고리즘
         * cache hit -> 1, cache miss -> 5
         */

        //j p s    nps   nls  nlj  plj psj  psn   lsn
        //5 10 15   20    25   30  35   40   45   50

        //방금 사용한 큐 원소는 가장 최근의 위치로 최신화해야함

        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();

        int time = 0;

        for(String city : cities){

            //stem.out.println("current city : " + city);
            city = city.toLowerCase();

            if(map.containsKey(city)){ //hit
                q.remove(city);
                q.offer(city);
                time += 1;
            }else { //miss
                if(cacheSize > 0){

                    if(!q.isEmpty() && q.size() == cacheSize){
                        String removed = q.poll();
                        map.remove(removed);
                    }

                    q.offer(city);
                    map.put(city, 1);

                }

                //cacheSize == 0 -> 큐 사용 불가능한 경우도 고려해야 함

                time += 5;
            }
        }

        return time;
    }

//     static boolean isInQueue(String city, Map<String, Integer> map){

//         city = city.toLowerCase();

//         if(map.getOrDefault(city, 0) == 0) return false;
//         else return true;
//     }
}
