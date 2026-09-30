package week36;

public class 괄호변환_StringAPI_and_Simulation {
    public String solution(String p) {

        String answer = transform(p);
        return answer;

    }

    static String transform(String p){

        String answer = "";

        if(p.length() == 0) return "";

        int balance = 0;
        int sPoint = 0;

        for(int idx = 0 ; idx < p.length() ; idx++){

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
        }else {
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
