package week30;

import java.util.ArrayList;

public class String_Sort_with_String_Utils_and_비교_대상이_다수일_경우_nested_Class_를_활용하여_Simulation {
    static class File{

        String origin;
        String head;
        int number;

        public File(String origin, String head, int number){
            this.origin = origin;
            this.head = head;
            this.number = number;
        }

    }

    public String[] solution(String[] files) {

        ArrayList<File> list = new ArrayList<>();

        for(String file : files){

            boolean isFound1 = true;
            boolean isFound2 = true;
            int idx1 = 0;
            int len = file.length();

            while(idx1 < len && !Character.isDigit(file.charAt(idx1))){
                idx1++;
            }

            int idx2 = idx1;
            while(idx2 < len && Character.isDigit(file.charAt(idx2))){
                idx2++;
            }

            String head = file.substring(0, idx1);
            int number = Integer.parseInt(file.substring(idx1, idx2));
            //int number = 0;

            list.add(new File(file, head, number));

        }

        list.sort((a,b) -> {

            String str1 = a.head.toLowerCase();
            String str2 = b.head.toLowerCase();

            if(!str1.equals(str2)){
                return str1.compareTo(str2);
            }else {
                return a.number - b.number;
            }

        });

        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++)
            answer[i] = list.get(i).origin;

        return answer;
    }
}
