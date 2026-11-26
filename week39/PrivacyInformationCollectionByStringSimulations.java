package week39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivacyInformationCollectionByStringSimulations {
    static Map<String, Integer> db = new HashMap<>();
    static List<Integer> list = new ArrayList<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        /*
         * 1 ~ n번 분류 개인정보에 대해 유효기간 전까지 보관 가능, 지났을경우 파기
         * A 약관 -> 12달이라면 21.1.5일의 개인정보는 22.1.5일에 폐기
         */

        int intToday = getInt(today);

        for(String term : terms){
            String[] info = term.split(" ");

            String standard = info[0];
            int interval = Integer.parseInt(info[1]);

            db.put(standard, interval);
        }

        for(int i = 0 ; i < privacies.length ; i++){

            String[] info = privacies[i].split(" ");

            String date = info[0];
            String standard = info[1];

            int collectedDate = getInt(date);
            int interval = db.get(standard);

            if(collectedDate + interval * 28 <= intToday){
                list.add(i+1);
            }

        }

        int[] answer = new int[list.size()];

        for(int i = 0 ; i < answer.length ; i++) answer[i] = list.get(i);

        return answer;

    }


    static int getInt(String date){

//         StringBuilder sb = new StringBuilder();

//         for(char ch : today.toCharArray())
//             if(Character.isDigit(ch)) sb.append(ch);

//         return Integer.parseInt(sb.toString());

        String[] dates = date.split("\\.");

        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);

        return year * 12 * 28 + month * 28 + day;
    }
}
