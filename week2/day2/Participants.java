package week2.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Participants {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String person : participant){
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        for(String person : completion){
            map.put(person, map.get(person) - 1);
        }

        for(String person : map.keySet()){
            if(map.get(person) != 0)
                return person;
        }

        //전체적으로 map이 table보다는 더 많이 쓰인다.
        //map.keySet();
        //map.values();
        //map.entrySet()

        return answer;
    }
}

/*
* sort 후 인덱스가 다른 지점이 미완주자인 점을 이용
* String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        //participant > completion
        for(int i = 0 ; i < completion.length ; i++){
            if(!completion[i].equals(participant[i]))
                return participant[i];
        }

        * 순회를모두 했다면 마지막 남은 자가 미완주자
        return participant[participant.length-1];
    }
* */