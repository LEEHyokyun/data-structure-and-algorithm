package week31;

public class Play_Music_with_String_Simulation {
    public String solution(String m, String[] musicinfos) {
        //재생 시간이 길 경우 처음부터 반복 재생, 재생 시간이 짧으면 재생 시간 만큼
        //조건 일치 음악 여러개일 경우 라디오에서 제일 재생시간이 긴 음악 제목 반환 > 먼저 입력된 음악 제목 반환
        //조건 없으면 " (None) " 반환

        String answer = "";
        int time = 0;

        for(String musicinfo : musicinfos){

            String[] info = musicinfo.split(",");

            String start = info[0];
            String end = info[1];
            String title = info[2];
            String code = info[3];

            String[] startTime = start.split(":");
            String[] endTime = end.split(":");

            //재생시간

            int startHour = Integer.parseInt(startTime[0]);
            int endHour = Integer.parseInt(endTime[0]);
            int startM = Integer.parseInt(startTime[1]);
            int endM = Integer.parseInt(endTime[1]);

            int playTime = (endHour - startHour) * 60 + (endM - startM); //분

            //재생시간동안 플레이된 코드
            int codeLen = code.length();
            int v1 = playTime / codeLen;
            //System.out.println("몫 : " + v1);
            int v2 = playTime % codeLen;
            //System.out.println("나머지 : " + v2);

            //String playCode = "";

            int len1 = 0;
            int len2 = 0;
            StringBuilder sb = new StringBuilder();

            while(true){

                while(len1 < v1){
                    sb.append(code);
                    //System.out.println(code + " 를 몫만큼 문자열 추가!");
                    len1++;
                }

                while(len2 < v2){
                    sb.append(code.charAt(len2));
                    //System.out.println(code + " 중 나머지만큼 잔여 문자 추가!");
                    len2++;
                }

                if(len1 == v1 && len2 == v2) break;

            }

            if(isPossible(sb.toString(), m) && (playTime > time)) {
                answer = title;
            }
        }

        return answer;
    }

    static boolean isPossible(String playCode, String m){

        //System.out.println("비교대상 : " + playCode);
        //System.out.println("악보 : " + m);

        if(m.length() > playCode.length()) return false;

        int idx = 0;
        int count = 0;
        for(char c : playCode.toCharArray()){
            if(c == m.charAt(idx)) {
                count++;
                idx++;
            } else {
                count = 0;
                idx = 0;
            }
            if(count == m.length()) return true;
        }

        return false;
    }
}
