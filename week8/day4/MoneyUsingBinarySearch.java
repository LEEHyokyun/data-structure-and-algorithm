package week8.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MoneyUsingBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int[] days = new int[N];
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < N ; i++){
            days[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, days[i]);              //용돈 최소값 = 최대값
            right = right + days[i];                     //용돈 최대값 = 모든 용돈의 합
        }

        int answer = right;

        while(left <= right){
            int mid = (left + right) / 2;

            if(isPossible(days, N, M, mid)){
                answer = mid;
                right = mid - 1;      //mid 최소화
            }else{
                left = mid + 1;       //불가능하므로 mid 크게
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int[] days, int N, int M, int mid){
        int count = 1; //최초 인출
        int money = mid;

        for(int i = 0 ; i < N ; i++){
            if(money < days[i]){
                //인출금액보다 더 크니까 인출함
                count++;
                money = mid;
            }
            //인출금액보다 작으면 그대로 사용
            money = money - days[i];
        }

        return count <= M;
    }
}
