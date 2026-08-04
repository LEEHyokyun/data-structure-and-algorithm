package week32;

import java.util.Arrays;

public class FileNamesSorting_with_String_Simulation_기본적으로_Index_Bound_체크를_먼저_조건에_기재해주어야한다 {
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

            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            while(true){

                //끝까지 읽을 경우 bound error 발생
                while(index < file.length() && !Character.isDigit(file.charAt(index))){
                    //head = head + file.charAt(index);
                    head.append(file.charAt(index));
                    index++;
                }

                //끝까지 읽을 경우 bound error 발생
                //number의 최대 길이는 5개
                int count = 0;
                while(index < file.length() && Character.isDigit(file.charAt(index)) && count < 5){
                    //number = number + file.charAt(index);
                    number.append(file.charAt(index));
                    index++;
                    count++;
                }

                break;

            }

            //list.add(new File(head.toUpperCase(), Integer.parseInt(number), file, i));
            list[i] = new File(head.toString().toUpperCase(), Integer.parseInt(number.toString()), file, i);
            //list[i] = new File(head, Integer.parseInt(number), file, i);
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
