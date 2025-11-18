package week2.day4;

public class MinRectangle {
    public int solution(int[][] sizes) {
        int answer = 0;

        //수납가능한 지갑의 최소크기 = 일단 모든 요소를 큰값-작은값으로 정렬 후 가큰값 * 세큰값
        int maxWidth = 0;
        int maxHeight = 0;

        for(int[] size : sizes){
            int w = Math.max(size[0],size[1]);
            int h = Math.min(size[0],size[1]);

            maxWidth = w > maxWidth ? w : maxWidth;
            maxHeight = h > maxHeight ? h : maxHeight;
        }

        return maxWidth*maxHeight;
    }
}
