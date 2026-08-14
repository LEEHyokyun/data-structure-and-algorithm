package week33;

import java.util.HashMap;
import java.util.Map;

public class Find_MusicCodes_with_String_Simulations_and_HashMap {
    public String solution(String m, String[] musicinfos) {
        //String.contains(str)
        //List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(String musicinfo : musicinfos){

            StringBuilder sb = new StringBuilder();

            String[] mu = musicinfo.split(",");

            //분단위
            String start = mu[0];
            String[] s = start.split(":");
            int sh = Integer.parseInt(s[0]) * 60;
            int sm = Integer.parseInt(s[1]);

            String end = mu[1];
            String[] e = end.split(":");
            int eh = Integer.parseInt(e[0]) * 60;
            int em = Integer.parseInt(e[1]);

            int total = (eh + em) - (sh + sm);

            String music = mu[3];
            int musicLength = music.length();

            int v1 = total / musicLength ;
            int v2 = total % musicLength ;

            String title = mu[2];

            //악보만들기
            for(int i = 0 ; i < v1 ; i++) sb.append(music);
            sb.append(music.substring(0, v2));

            map.put(title, sb.toString());
            //System.out.println("key : " + title);
            //System.out.println("key : " + sb.toString());

        }

        String answer = "None";
        int curLength = 0;
        for(String key : map.keySet()){

            String music = map.get(key);
            int length = music.length();

            if(music.contains(m) && length > curLength){
                answer = key;
            }

        }

        return answer;
    }
}
