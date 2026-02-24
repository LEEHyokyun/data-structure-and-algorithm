package week16;

import java.util.Arrays;

public class StringPhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book); //오름차순
        //있으면 false, 없으면 true

        //아이디어 : 접두관계에 있다면, 정렬 시 서로 인접을 한 배열원소는 반드시 접두사 관계임.
        for(int i = 0 ; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
