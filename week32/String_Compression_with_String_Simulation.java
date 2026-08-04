package week32;

public class String_Compression_with_String_Simulation {
    public int solution(String s) {

        if(s.length() == 1) return 1;

        //최초 = 압축안한 raw 길이
        int answer = s.length();

        //단위를 넓혀가면서
        for(int unit = 1 ; unit <= s.length() / 2 ; unit++){

            String u = s.substring(0, unit); // 0 ~ unit - 1

            //s.length() <= 1000 ... 2중 순회 허용
            StringBuilder sb = new StringBuilder();
            int count = 1;

            //2글자로 잘랐다면 인덱스는 unit부터 반복 여부 탐색 시작
            for(int i = unit ; i < s.length() ; i+=unit){

                //unit으로 끊은 지점 직후부터 unit 길이만큼 자르는데, unit slice 지점이 문자열 길이보다 더 클 수 있음
                //1 ~ 2,3,4,5,6,....
                int end = Math.min(s.length(), i + unit); //맨 마지막 길이 조절(i+unit이 문자열 길이 넘어갔을경우)
                String c = s.substring(i, end); //unit idx ~ end - 1 idx

                //System.out.println("현재 탐색 대상 : " + c);

                if(u.equals(c)) {
                    count++;
                    continue;
                }

                if(count > 1) sb.append(count + u);

                    //반복 시 카운트 붙이고 문자열, 반복 안하면 그대로 문자열
                else sb.append(u);
                //System.out.println("압축한 최종 문자열 중간 결과 : " + sb.toString());

                u = c;
                count = 1;
            }

            //i == s.length() -1 도달하였고, 그것이 반복하지 않는 문자열이라면 문자열 별도 붙이는 작업 필요함
            //반복 시 카운트 붙이고 문자열, 반복 안하면 그대로 문자열
            if(count > 1) sb.append(count + u);
            else sb.append(u);

            //단위 문자열 순회 종료 후 길이 비교
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
