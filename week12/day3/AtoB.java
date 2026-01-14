package week12.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(token.nextToken()); //10억 이상..정방향 DP는 한계
        int B = Integer.parseInt(token.nextToken());

        //역방향
        int count = 0;
        int cur = B;
        while(true){

            if(cur == A){
                count++;
                break;
            }

            //if(cur < B){
            //    count = -1;
            //    break;
            //}

            if(cur % 2 == 0){
                cur = cur / 2;
                count++;
            }
            else{
                //ex. 7571 = 757 / 1
                //ex. 1 -> 10 * 0 + 1 (x) cur == 1 (o)
                if(cur < 10) {
                    count = -1;
                    break;
                }else{
                    int cur1 = cur / 10;
                    int cur2 = cur % 10;

                    //홀수인데 1로 안끝나면 무조건 -1
                    if(cur2 != 1){
                        count = -1;
                        break;
                    }

                    //홀수이면서 끝자리가 1로 끝나는 두자리 숫자라면 1빼기
                    if(cur2 == 1){
                        cur = cur1;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
