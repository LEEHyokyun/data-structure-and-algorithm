package week38;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoomByStringAPIAndSimulation {
    static class Status{

        private String id;
        private String status;

        public Status(String id, String status){
            this.id = id;

            if(status.equals("Enter")) this.status = "들어왔습니다.";
            else this.status = "나갔습니다.";
        }

    }

    static Map<String, String> db = new HashMap<>(); //id / name
    static List<Status> list = new ArrayList<>();
    static String enter = "들어왔습니다.";
    static String leave = "나갔습니다.";

    public String[] solution(String[] record) {

        /*
         * 닉네임님이 들어왔습니다.
         * 닉네임님이 나갔습니다.
         * - 닉네임 변경 시 기존 채팅방 닉네임도 전부 변경됨
         */
        for(String r : record){

            String[] input = r.split(" ");

            String status = input[0];

            if(status.equals("Enter") || status.equals("Leave")){
                list.add(new Status(
                        input[1],
                        input[0]
                ));
            }

            if(!status.equals("Leave")){
                db.put(
                        input[1],
                        input[2]
                );
            };
        }

        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            Status input = list.get(i);
            String id = input.id;
            String status = input.status;

            answer[i] = db.get(id) + "님이 " + status;
        }

        return answer;
    }
}
