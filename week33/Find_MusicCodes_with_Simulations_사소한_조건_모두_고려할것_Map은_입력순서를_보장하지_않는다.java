package week33;

public class Find_MusicCodes_with_Simulations_사소한_조건_모두_고려할것_Map은_입력순서를_보장하지_않는다 {
    /*
     * Map은 입력순서를 보장하지 않는다.
     * Map에 넣을 필요없이 바로 비교/탐색한다.
     */

    public String solution(String m, String[] musicinfos) {
        //String.contains(str)
        //List<String> list = new ArrayList<>();
        //Map<String, String> map = new HashMap<>();
        String answer = "(None)";
        int curLength = 0;

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
            music = getConverted(music);

            int musicLength = music.length();

            int v1 = total / musicLength ;
            int v2 = total % musicLength ;

            String title = mu[2];

            //악보만들기(*C# -> c 등으로 치환하여 저장해야 할 듯하다.)
            for(int i = 0 ; i < v1 ; i++) sb.append(music);
            sb.append(music.substring(0, v2));

            int length = sb.toString().length();
            //map.put(title, sb.toString());
            System.out.println("key : " + title);
            System.out.println("music : " + sb.toString());

            if(sb.toString().contains(getConverted(m)) && length > curLength){
                answer = title;
                curLength = length;
            }
        }

        //int curLength = 0;
//         for(String key : map.keySet()){

//             String music = map.get(key);
//             int length = music.length();

//             if(music.contains(getConverted(m)) && length > curLength){
//                 //조건이 맞으면 같이 연관 조건 모두 변경
//                 answer = key;
//                 curLength = length;
//             }

//         }

        return answer;
    }

    static String getConverted(String str){
        return  str.replace("A#", "a")
                .replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                ;
    }
}
