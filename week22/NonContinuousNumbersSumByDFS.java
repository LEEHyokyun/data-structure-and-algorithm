package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NonContinuousNumbersSumByDFS {
    static int N,S;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());

        list = new int[N];
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(token2.nextToken());
        }

        //부분수열, 비연속적일 수 있기에 슬라이딩 윈도우는 아님
        //선택의 문제 = dfs

        int answer = dfs(0, 0);
        //아무것도 선택안했을때 집계에서 제외
        if(S == 0) answer--;
        System.out.println(answer);
    }

    static int dfs(int start, int sum){

        //기저조건
        if(start == N){
            if(sum == S) return 1;
            else return 0;
        }

        //재귀
        int count = 0;
//        for(int i = start ; i < list.length ; i++){
        //모든 경우에 대해 재귀 : 선택하냐 안하냐
        //start가 아니라 i를 기준
        //start -> i=1,2일때 start=0일때 반복됨
        //반드시 i기준
//            count += dfs(i + 1, sum + list[i]) + dfs(i + 1, sum);
//        }

        count += dfs(start + 1, sum + list[start]) + dfs(start + 1, sum);

        return count;
    }
}
