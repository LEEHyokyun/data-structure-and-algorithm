package week26;

import java.util.Arrays;

public class phoneBookBySimulationsAndString {
    public boolean solution(String[] phone_book) {
        //정렬해서 마주보는 내역이 서로 접두어 관계면 바로 true

        Arrays.sort(phone_book);

        String prev = phone_book[0];
        //System.out.println(prev);
        int len = phone_book.length;

        if(len == 1) return true;

        for(int i = 1 ; i < len ; i++){
            String cur = phone_book[i];

            //System.out.println(cur);
            //if(cur.contains(prev)) return false;
            if(cur.startsWith(prev)) return false;

            prev = cur;
        }

        return true;
    }
}
