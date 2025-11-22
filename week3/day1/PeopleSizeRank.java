package week3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeopleSizeRank {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //모든 요소를 탐색하는 브루트포스
        int[][] people = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            String[] str = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(str[0]);
            people[i][1] = Integer.parseInt(str[1]);
        }

        StringBuilder sb = new StringBuilder();
        //brute force
        for(int i = 0 ; i < N ; i++){
            int rank = 1;
            for(int j = 0 ; j < N ; j++){
                if(i == j) continue;
                if((people[i][0] < people[j][0]) && (people[i][1] < people[j][1]))
                    rank++;
            }

            sb.append(rank);
            sb.append(" ");
        }

        System.out.print(sb);
    }
}
