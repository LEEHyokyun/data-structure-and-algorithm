package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LottoDFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1 ~ 49 중에 k개 수를 먼저 선별하고, 여기ㅏ서 수 6개를 고른다.
        //조합

        while(true){
            StringTokenizer token = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(token.nextToken());

            if(N == 0) break;

            int[] list = new int[N];
            int[] path = new int[6];

            for(int i = 0 ; i < N ; i++){
                list[i] = Integer.parseInt(token.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            dfs(list, path, 0, 0, sb);
            System.out.print(sb);
            System.out.println();
        }

    }

    //조합
    static void dfs(int[] list, int[] path, int start, int selected, StringBuilder sb){

        //기저조건
        if(selected == 6){
            for(int i = 0 ; i < 6 ; i++){
                sb.append(path[i]).append(" ");
            }
            sb.append('\n');

            return;
        }

        //6개 골라야 함
        //6 길이 -> 인덱스 0까지
        //7 길이 -> 인덱스 1까지

        //조합
        for(int i = start ; i < list.length ; i++){
            //이 부분이 중요
            path[selected] = list[i];
            dfs(list, path, i + 1, selected + 1, sb);
        }
    }
}
