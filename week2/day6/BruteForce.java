package week2.day6;

public class BruteForce {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //yellow를 약수(인수)로 분해하여 크기를 나눈후
        //이 주변을 brown으로 붙일때 그 크기가 조건에 만족할 경우 크기 계산

        //모든 약수 쌍(divisor pair)은 √N을 기준으로 하나는 작고 하나는 크기 때문에 순회크기는 제곱근까지 진행

        for(int h = 1 ; h <= Math.sqrt(yellow) ; h++){
            if(yellow % h == 0){
                //완전탐색조건 완료, 완전탐색 시작
                int w = yellow / h;

                //yellow의 w,h 구했음, 전체 높이 및 너비 구함
                int height = h + 2;
                int width = w + 2;


                if(height * width - w*h == brown){
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }



        return answer;
    }
}
