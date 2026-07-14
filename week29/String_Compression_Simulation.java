package week29;

public class String_Compression_Simulation {
    /*
     * 문자열 최대 길이가 1000이므로 O^2 허용
     */

    public int solution(String s) {
        //연속해서 나타나면 2a 2b c (*1은 생략)
        //불연속하면 큐에 스택에 넣고 연속하면 거기서 빼고 map + 1
        int originalLength = s.length();
        if(originalLength == 1) return 1;

        int answer = originalLength;

        //압축 최대 단위 = 원본 길이의 1/2(5글자 -> 2글자 6글자 -> 3글자..)
        for(int unit = 1 ; unit <= originalLength / 2 ; unit++){
            StringBuilder units = new StringBuilder();

            //최초 : 1글자, idx 0 부터 0까지, 0 ~ unit - 1
            String prev = s.substring(0, unit);
            int count = 1;

            //unit 다음 문자열에 대하여 unit 만큼 slice한 문자열의 반복 비교
            for(int i = unit ; i < s.length() ; i += unit){
                /*
                 * 문자열을 unit 만큼 자를때 나누어 떨어지지 않고 맨 마지막 문자열이 남을 경우
                 * 문자열 i부터 unit 만큼 자른 것이 아닌 맨 끝자리 인덱스의 -1(s.length()).
                 */
                int end = Math.min(i + unit, s.length());
                String cur = s.substring(i, end);
                //String cur = s.substring(i, i + unit);

                //잘랐는데 반복 = 카운팅
                if(prev.equals(cur)){
                    count++;
                }
                //미반복
                else{

                    //미반복 시점부터 prev * count
                    if(count > 1) units.append(count);

                    //그리고 반복 문자열 넣기
                    units.append(prev);

                    prev = cur;
                    count = 1;


                }
            }

            //마지막 문자열 처리
            if(count > 1) units.append(count);
            units.append(prev);

            answer = Math.min(answer, units.length());
        }

        return answer;
    }
}
