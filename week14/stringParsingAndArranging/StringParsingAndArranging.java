package week14.stringParsingAndArranging;

import java.util.ArrayList;

public class StringParsingAndArranging {
    static class FileInfo {
        String file;
        String head;
        int number;
        int index;

        FileInfo(String file, String head, int number, int index){
            this.file = file;
            this.head = head;
            this.number = number;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {

        ArrayList<FileInfo> list = new ArrayList<>();
        int idx = 0;

        for(String file : files){
            int idx1 = 0;
            int length = file.length();

            //HEAD : 문자
            while(idx1 < length && !Character.isDigit(file.charAt(idx1))){
                idx1++;
            }

            //idx1 : 숫자시작
            String head = file.substring(0, idx1);

            //Number : 숫자
            int idx2 = idx1;
            while(idx2 < length && Character.isDigit(file.charAt(idx2))){
                idx2++;
            }

            //idx2 : 문자시작
            int number = Integer.parseInt(file.substring(idx1, idx2));

            list.add(new FileInfo(file, head, number, idx));
            idx++;
        }

        list.sort((a,b) -> {

            int headCompareTo = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if(headCompareTo != 0) return headCompareTo;

            if(a.number != b.number) return a.number-b.number;

            return a.index - b.index;

        });

        String[] answer = new String[files.length];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = list.get(i).file;
        }

        return answer;
    }
}
