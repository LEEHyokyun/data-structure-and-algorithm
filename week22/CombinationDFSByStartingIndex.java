package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinationDFSByStartingIndex {
    static int N,M;
    static int[] list;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        //1 - N 중 중복없이 M개를 고른 수열 = 길이가 M
        //고른 수열은 오름차순

        list = new int[N];
        selected = new boolean[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = i+1;
        }

        dfs(0, 0, "");
        System.out.println(sb);
    }

    static void dfs(int start, int depth, String ans){

        //기저
        if(depth == M){
            sb.append(ans).append('\n');
            return;
        }

        //dfs

        //브루트포스인데 한번 선택하고 다시는 안오면 depth
        //브루트포스인데 한번 선택했어도 다음 단계에서 또 이전의 요소를 선택 가능하면 for/start

        //for(int i = start ; i < list.length ; i++){
        //    selected[i] = true;
        //    dfs(i + 1, num + 1, ans + " " + String.valueOf(list[i]));
        //    selected[i] = false;
        //}

        //1 2 2 1 다름 => 순열 -> 부분 수열(선택하거나 안하거나..합산 등)
        //                    -> for + selected (brute force) // 중복제거 //다음 선택은 이전의 요소를 다시 선택할 ㅅ ㅜ있다.
        //1 2 2 1 동등 => 조합 -> 순열이라고 표현되어있지만 오름차순 선택.. .for + start //다음 선택은 항상 큰 수, 이전의 요소를 다시는 보지 않는다.
        //

        for(int i = start ; i < list.length ; i++){
            dfs(i + 1, depth + 1, ans + list[i] + " ");
        }
    }
}
