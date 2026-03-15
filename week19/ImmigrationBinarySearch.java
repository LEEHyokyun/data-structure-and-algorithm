package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImmigrationBinarySearch {
    //기본 : 최소조건으로
    //무한순회 방지를 위해 경계값 +- 1
    //조건 만족 시 해당 mid = answer
    static int N;
    static long M;
    static long[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken()); //입국심사대 개수
        M = Long.parseLong(token.nextToken()); //친구들 M명

        list = new long[N];
        long max = 0;
        for(int i = 0 ; i < N ; i++){
            list[i] = Long.parseLong(br.readLine());
            max = Math.max(max, list[i]);
        }

        long min = 1;
        max = max * M;
        long answer = 0;

        //기본 : 최소조건으로
        //무한순회 방지를 위해 경계값 +- 1
        //조건 만족 시 해당 mid = answer

        while(min <= max){
            //걸리는 시간의 최소값
            long mid = (min + max)/2;

            if(isPossible(list, mid, M)) {
                answer = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(long[] list, long mid, long M){
        long person = 0;
        for(long time : list){
            //mid = 최소값으로 가정한 시간
            person += mid / time;

            if(person >= M) return true;
        }


        return false;
    }
}
