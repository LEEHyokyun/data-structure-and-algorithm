package week11.day5;

public class StringParsingToIntAndMinMax {
    static int[] list;

    public String solution(String s) {

        String[] ss = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(String part : ss){
            int val = Integer.parseInt(part);
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        String answer = "";
        answer = answer + min + " " + max;

        return answer;
    }
}
