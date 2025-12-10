package week5.day6;

public class StringUandV {
    public String solution(String p) {

        String answer = transform(p);
        return answer;
    }

    static String transform(String p) {
        String answer = "";

        if(p.length() == 0) return "";

        //u, v로 나누기
        int balance = 0;
        int sPoint = 0;
        for(int idx = 0 ; idx < p.length() ; idx++){
            //균형 - 갯수
            char c = p.charAt(idx);
            if(c == '(') balance++;
            else balance --;

            if(balance == 0){
                sPoint = idx + 1;
                break;
            }
        }

        String u = p.substring(0, sPoint);
        String v = p.substring(sPoint);

        if(isProper(u)){
            return u + transform(v);
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(transform(v));
            sb.append(')');
            sb.append(flip(u.substring(1, u.length() - 1)));

            return sb.toString();
        }

    }

    static boolean isProper(String s){
        int bal = 0;
        for(char c : s.toCharArray()){
            if(c == '(') bal++;
            else bal--;

            //( -> ++, ) -> --
            //끝까지 순회했을때 bal = 0일 경우만 올바른 문자열, 나머지는 모두 아님
            if(bal < 0) return false;
        }

        return bal == 0;
    }

    static String flip(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }
}
