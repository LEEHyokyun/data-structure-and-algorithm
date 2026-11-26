package week39;

public class MatrixRotationBySimulation {
    static int[][] matrix;

    public int[] solution(int rows, int columns, int[][] queries) {
        /*
         * rows * columns(행 x 열)
         * 이 행렬에서 직사각형 모양으로 선택해서 시계 방향으로 회전
         * 각 회전에서 이동한 수 중 최소값만 골라서 배열화
         */

        matrix = new int[rows][columns];
        int num = 1;

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                matrix[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];

        /*
         * x1행 y1열부터 x2행 y2행열까지 해당하는 직사각형 테두리 영역을 시계 방향 회전
         */

        for(int q = 0 ; q < queries.length ; q++){
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;

            int temp = matrix[x1][y1];
            int min = matrix[x1][y1];

            //왼쪽 변 회전
            for(int i = x1 ; i < x2 ; i++){
                matrix[i][y1] = matrix[i+1][y1];
                min = Math.min(min, matrix[i+1][y1]);
            }

            //아래쪽 변 회전
            for(int j = y1 ; j < y2 ; j++){
                matrix[x2][j] = matrix[x2][j+1];
                min = Math.min(min, matrix[x2][j+1]);
            }

            //오른쪽 변 회전
            for(int i = x2 ; i > x1 ; i--){
                matrix[i][y2] = matrix[i-1][y2];
                min = Math.min(min, matrix[i-1][y2]);
            }

            //위쪽 변 회전
            for(int j = y2 ; j > y1 + 1 ; j--){
                matrix[x1][j] = matrix[x1][j - 1];
                min = Math.min(min, matrix[x1][j - 1]);
            }

            //temp 복원
            matrix[x1][y1+1] = temp;

            answer[q] = min;
        }

        return answer;

    }
}
