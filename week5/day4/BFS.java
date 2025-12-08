package week5.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        //도시
        int N = Integer.parseInt(tokenizer.nextToken());
        //도로
        int M = Integer.parseInt(tokenizer.nextToken());
        //거리
        int K = Integer.parseInt(tokenizer.nextToken());
        //출발도시
        int X = Integer.parseInt(tokenizer.nextToken());

        //인접도시정보(도시가 30만개/도로가 100만개..단순 배열은 메모리 초과)
        List<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M ; i++){
            StringTokenizer path = new StringTokenizer(br.readLine(), " ");
            graph[Integer.parseInt(path.nextToken())].add(Integer.parseInt(path.nextToken()));
        }

        int[] dist = new int[N+1];     //30만개
        Arrays.fill(dist, -1);
        dist[X] = 0; //시작점 = 0

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);

        //bfs
        while(!q.isEmpty()){
            int current = q.poll(); //시작점

            for(int next : graph[current]){
                if(dist[next] == -1){
                    dist[next] = dist[current] + 1;    //next = current -> 누적되는 것임
                    q.offer(next);
                }
            }
        }

        boolean found = false;
        for(int i = 1 ; i <= N ; i++){
            if(dist[i] == K){
                System.out.println(i);
                found = true;
            }
        }

        if(found == false){
            System.out.println(-1);
        }
    }
}
