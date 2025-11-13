package week1.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MeetByBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer command = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(command.nextToken());
        int k = Integer.parseInt(command.nextToken());

        if(n == k){
            System.out.print(0);
            return;
        }

        //방문한 곳
        boolean[] visited = new boolean[100001];
        visited[n] = true;
        //현재의 위치를 저장하는 queue
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        //현재의 위치에서 도달가능한 "인접거리"의 "경우의 수"를 모두 계산하는 BFS.
        System.out.print(BFS(visited, q, k));
    }

    public static int BFS(boolean[] visited, Queue<Integer> q, int k){
        int count = 0;

        //현재 지점에서 방문가능한 인접노드를 지나치면서 동일시하는 지점(BFS)
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                //size만큼 순회
                int x = q.poll();
                if(x == k) return count;

                if(x-1 >=0 && visited[x-1] == false){
                    visited[x-1] = true;
                    q.offer(x-1);
                }
                if(x+1 <= 100000 && visited[x+1] == false){
                    visited[x+1] = true;
                    q.offer(x+1);
                }
                if(x*2 <= 100000 && visited[x*2] == false){
                    visited[x*2] = true;
                    q.offer(x*2);
                }
            }

            count++;
        }

        return count;
    }
}
