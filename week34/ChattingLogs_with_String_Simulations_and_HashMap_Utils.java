package week34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChattingLogs_with_String_Simulations_and_HashMap_Utils {
    static class Member{

        String id;
        String status;

        public Member(String id, String status){
            this.id = id;
            this.status = status;
        }
    }

    static Map<String, String> db = new HashMap<>();

    public String[] solution(String[] record) {
        /*
         * [닉네임]님이 들어왔습니다.
         * [닉네임]님이 나갔습니다.
         * 바꾸면 그대로 닉네임 변경.
         */
        List<Member> logs = new ArrayList<>();

        for(String r : record){

            String[] sentence = r.split(" ");
            String status = sentence[0];
            String id = sentence[1];
            String nick = "";

            if(status.equals("Enter")){
                nick = sentence[2];
                db.put(id, nick);
                status = "님이 들어왔습니다.";

                logs.add(new Member(id, status));
            }else if(status.equals("Leave")){
                status = "님이 나갔습니다.";

                logs.add(new Member(id, status));
            }else if(status.equals("Change")){
                nick = sentence[2];
                db.put(id, nick);
            }

        }

        String[] answer = new String[logs.size()];
        for(int i = 0 ; i < logs.size() ; i++){
            Member member = logs.get(i);

            answer[i] = "" + db.get(member.id) + member.status;
        }

        return answer;
    }
}
