package week34;

public class SecretMap_with_String_Simulation_and_Util_Integer로는_파싱_부족_반드시_Long_으로_넉넉하게 {
    static char[][] graph1;
    static char[][] graph2;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        /*
         * 지도1, 지도2를 겹쳤을때 어느 하나라도 벽(#)이면 벽(#)이다. = 1
         * 모두 벽이 아니어야 0이다.
         * 최종 도출 = 겹친 후에 벽을 1, 아닌 부분을 0으로 나타내었을때의 이진수 배열(십진수)
         * Integer.toString(k, n)
         */
        graph1 = new char[n][n];
        int idx1 = 0;

        String parameter = getParameter(n);

        //System.out.println("****arr1****");
        for(int val : arr1){
            String converted = Long.toString(val, 2); //숫자가 너무 큼 -> long
            converted = String.format(parameter, Long.parseLong(converted));
            //System.out.println("최종변환 : " + converted);

            for(int i = 0 ; i < converted.length() ; i++){
                char c = converted.charAt(i);
                //System.out.println("현재 이진수 값 : " + c);
                graph1[idx1][i] = c;
            }

            idx1++;
        }

        graph2 = new char[n][n];
        int idx2 = 0;
        //System.out.println("****arr2****");
        for(int val : arr2){
            String converted = Long.toString(val, 2);
            converted = String.format(parameter, Long.parseLong(converted));
            //System.out.println("2진법으로 변경한 수 : " + val + " -> " + converted);

            for(int i = 0 ; i < converted.length() ; i++){
                char c = converted.charAt(i);
                graph2[idx2][i] = c;
            }

            idx2++;
        }

        String[] answer = new String[n];
        for(int i = 0 ; i < answer.length ; i++){

            StringBuilder result = new StringBuilder();

            for(int j = 0 ; j < n ; j++){
                //System.out.println("graph1(" + i + "," + j + ") : " + graph1[i][j]);
                //System.out.println("graph2(" + i + "," + j + ") : " + graph2[i][j]);
                if(graph1[i][j] == '0' && graph2[i][j] == '0'){
                    //빈칸
                    result.append(" ");
                }else {
                    //벽
                    result.append("#");
                }
            }

            answer[i] = result.toString();
        }

        return answer;
    }

    static String getParameter(int n){

        StringBuilder result = new StringBuilder();

        //if(n < 10) return result.append("%0").append(n).append("d").toString();
        //else return result.append("%").append(n).append("d").toString();

        return result.append("%0").append(n).append("d").toString();
    }
}
