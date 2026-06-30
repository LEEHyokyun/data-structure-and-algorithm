package week27;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Cache_QueueAndMap {
    public int solution(int cacheSize, String[] cities) {
        //가장 이전에 사용된 캐시를 삭제
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();

        int time = 0;
        int size = 0;

        if(cacheSize == 0) return 5 * cities.length;

        for(String city : cities){

            city = city.toLowerCase();

            int count = map.getOrDefault(city, 0);

            if(count > 0){
                //System.out.println("현재 도시[" + city + "] 캐시에 있음");

                //캐시 위치 갱신
                q.remove(city);
                q.offer(city);

                time += 1;
                //System.out.println("시간은 +1 초");
            }else {
                //System.out.println("현재 캐시 크기 : " + size);
                if(size < cacheSize){
                    //System.out.println("현재 도시[" + city + "] 캐시에 없는데 아직 안 참");

                    map.put(city, 1);
                    q.offer(city);

                    size++;
                }else{
                    //System.out.println("현재 도시[" + city + "] 캐시에 없는데 꽉 차있음 제거해야함");

                    String removed = q.poll();
                    //System.out.println("도시[" + removed + "]를 제거한다.");
                    map.remove(removed);

                    map.put(city, 1);
                    q.offer(city);
                }

                time += 5;
                //System.out.println("시간은 +5 초");
            }

            //cacheSize == 0

        }

        return time;
    }
}
