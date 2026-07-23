package week30;

public class String_Compression_with_String_Simulation {
    public int solution(String s) {
        //문자열 길이가 1000 이하 .. 2회 순회 허용
        //압축 시 단위길이가 가장 길도록 구현
        int len = s.length();

        if(len == 1) return 1;

        int answer = len;

        //unit 길이를 늘려가면서 확인, unit 길이는 최대 반절
        for(int unit = 1 ; unit <= len / 2 ; unit++){
            StringBuilder sb = new StringBuilder();

            //unit 단위로 substring하여 단위 문자열 추출
            String u = s.substring(0, unit); //0 ~ unit -1
            //System.out.println("현재 unit 단위 : " + u);
            int count = 1;

            //unit 단위로 반복 여부 확인(unit / 단위 문자열 하나씩 확인 / unit을 점차 늘려나가기)
            for(int i = unit ; i < len ; i += unit){
                int end = Math.min(i + unit, len); //정한 unit만큼, 문자열을 돌아가면서 반복여부 확인
                String str = s.substring(i, end); //unit ~ end(len - 1)

                if(str.equals(u)){
                    count++;
                }
                else {

                    //반복 되면 일단 붙이고
                    if(count > 1) sb.append(count);
                    sb.append(u);

                    //반복 안되면 unit 갱신
                    u = str;
                    count = 1;
                }
            }

            if(count > 1) sb.append(count);
            sb.append(u);

            //answer = Math.min(answer, sb.length());
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
