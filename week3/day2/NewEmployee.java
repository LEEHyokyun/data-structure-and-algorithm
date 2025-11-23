package week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NewEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        //하나의 점수가 다른 사람보다 높다면 그 사람은 합격을 무조건 보장
        //일단 어찌되었든 두 요소를 모두 확인하기 해야한다(브루트포스처럼 보이지만 동시비교는 필요없는 그리디)
        //유의사항 : "서류심사 성적, 면접 성적의 순위" .. 따라서 낮을수록 좋다.
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            int[][] arr = new int[num][2];

            for(int j = 0 ; j < num ; j++){
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                int score1 = Integer.parseInt(tokenizer.nextToken());
                int score2 = Integer.parseInt(tokenizer.nextToken());

                arr[j][0] = score1;
                arr[j][1] = score2;
            }

            //arr자체를 비교.. 비교대상은 "(s1, s2)"의 배열.
            Arrays.sort(arr, (s1, s2) ->
                    s1[0] - s2[0]
            );

            int count = 1;
            int first = arr[0][1];

            for(int j = 1 ; j < num ; j++){
                if(arr[j][1] < first){
                    count++;
                    first = arr[j][1];
                }
            }


            sb.append(count);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
