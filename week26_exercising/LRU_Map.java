package week26_exercising;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRU_Map {
    public int solution(int cacheSize, String[] cities) {
        /*
         * LRU : Least Recently Used, 캐시 교체 알고리즘
         * cache hit -> 1, cache miss -> 5
         */

        //j p s    nps   nls  nlj  plj psj  psn   lsn
        //5 10 15   20    25   30  35   40   45   50

        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();

        int time = 0;
        int curSize = 0;

        for(String city : cities){

            //stem.out.println("current city : " + city);
            city = city.toLowerCase();

            if(curSize < cacheSize){
                if(isInQueue(city, map)){
                    time++;
                    //stem.out.println("case 1 : " + map);
                }else{
                    q.offer(city);
                    map.put(city, 1);

                    curSize++;
                    time += 5;
                    //stem.out.println("case 2 : " + map);
                }
            }else {
                if(isInQueue(city, map)){
                    time++;

                    //System.out.println("case 3 : " + map);
                }else{
                    String removed = q.poll();
                    q.offer(city);

                    map.remove(removed);
                    map.put(city , 1);

                    curSize++;
                    time += 5;

                    //System.out.println("case 4 : " + map);
                }
            }
        }

        return time;
    }

    static boolean isInQueue(String city, Map<String, Integer> map){

        city = city.toLowerCase();

        if(map.getOrDefault(city, 0) == 0) return false;
        else return true;
    }
}
