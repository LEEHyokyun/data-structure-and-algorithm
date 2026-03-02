package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WifiBinarySearch {
    static int[] list;

    public static void main(String[] args) throws IOException {
        //x1, x2, ... , xn
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());

        list = new int[N];

        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        //가장 가까운 거리
        //최소거리를 기준으로 이분탐색
        //최소 거리 설치가능? => 늘림(포함개념)
        //최소 거리 설치불가? => 줄임(포함불가) .. 이 과정이 중요, 그 과정의 값 포함불가 ..

        int left = 1;
        int right = list[N-1] - list[0];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canInstall(list, mid, N, C)){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canInstall(int[] list, int dis, int N, int C){
        int count = 1;
        int lastInstalled = list[0];

        for(int i = 1 ; i < N ; i++){
            if(list[i] - lastInstalled >= dis){
                count++;
                lastInstalled = list[i];
            }
        }

        return (count >= C) ? true : false;
    }
}
