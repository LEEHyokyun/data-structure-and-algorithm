package week28;

import java.util.Arrays;

public class Marathon_Arrays_fill_불참자는_한명_활용 {
    public String solution(String[] participant, String[] completion) {
        //굳이 map 없어도 정렬기준을 같게 해서, 각 인덱스 위치가 다르면 없는 것으로 판단 가능
        Arrays.sort(participant);
        Arrays.sort(completion);

        //어차피 단 한 명
        String ans = "";
        for(int i = 0 ; i < completion.length ; i++){
            //불일치가 나타나는 순간 멈춰야함
            if(!participant[i].equals(completion[i])){
                ans = participant[i];
                break;
            }

        }

        return (ans.equals("")) ? participant[participant.length - 1] : ans;
    }
}
