package week28;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CacheSize_HashMap {
    public int solution(int cacheSize, String[] cities) {

        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();

        int curSize = 0 ;
        int time = 0;

        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){

            city = city.toLowerCase();


            int count = map.getOrDefault(city, 0);

            //System.out.println("현재 도시 캐싱 여부 : " + count);
            //System.out.println("현재 도시 : " + city);

            if(count == 0){
                if(curSize < cacheSize){

                    q.offer(city);
                    map.put(city, count + 1);
                    time += 5;
                    curSize++;

                }else{

                    String deleted = q.poll();
                    map.remove(deleted);

                    q.offer(city);
                    map.put(city, count + 1);
                    time += 5;

                }
            }else {

                q.remove(city);
                q.offer(city);
                map.put(city, count + 1);

                time += 1;

            }

        }

        return time;

    }
}
