package week32;

import java.util.Arrays;

public class FileNamesSorting_with_String_Simulation {
    static class File{

        String head;
        int number;
        String original;
        int idx;

        public File(String head, int number, String original, int idx){
            this.head = head;
            this.number = number;
            this.original = original;
            this.idx = idx;
        }

    }

    public String[] solution(String[] files) {
        /*
         * HEAD(최초 영문 문자열)을 사전 순으로 정렬(*대소문자 구분 없음)
         * 사전 순 정렬이 동일하다면 number(그 이후에 나타나는 숫자) 순 정렬
         * 둘 다 정렬 순서가 같다면 기존 입력 순서를 유지
         */
        File[] list = new File[files.length];

        for(int i = 0 ; i < files.length ; i++){

            String file = files[i];
            int index = 0;

            String head = "";
            String number = "";

            while(true){

                while(!Character.isDigit(file.charAt(index))){
                    head = head + file.charAt(index);
                    index++;
                }

                while(Character.isDigit(file.charAt(index))){
                    number = number + file.charAt(index);
                    index++;
                }

                break;

            }

            //list.add(new File(head.toUpperCase(), Integer.parseInt(number), file, i));
            list[i] = new File(head.toUpperCase(), Integer.parseInt(number), file, i);
        }



        Arrays.sort(list, (a, b) -> {

            if(a.head.equals(b.head)){

                if(a.number == b.number) return a.idx - b.idx;

                return a.number - b.number;
            }

            return a.head.compareTo(b.head);
        });

        String[] answer = new String[files.length];

        for(int i = 0 ; i < list.length ; i++){

            answer[i] = list[i].original;

        }

        return answer;
    }
}
