package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//본인을 기준으로 LIS를 구하면서 점화식 채워나간다.
public class LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int[] dp1 = new int[N]; //LIS
        int[] dp2 = new int[N]; //LDS

        /*
         * 각 요소를 최대, 최소의 후보로 본다.
         */

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] < arr[i]){
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);   //j를 누적해가면서 최대값 갱신
                }
            }
        }

        for(int i = N - 1 ; i >= 0 ; i--){
            for(int j = N -1 ; j > i ; j--){
                if(arr[j] < arr[i]){
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1); //j를 누적해가면서 최대값 갱신
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer = Math.max(answer, dp1[i] + dp2[i] - 1);
        }

        System.out.println(answer);
    }
}
