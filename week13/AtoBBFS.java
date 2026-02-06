package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoBBFS {
    static boolean[] visited;

    static class Node{
        int num;
        String cmd;

        Node(int num, String cmd){
            this.num = num;
            this.cmd = cmd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        //가능한 수 = 0 이상 10000 미만


        while(T-- > 0){
            StringTokenizer token = new StringTokenizer(br.readLine());

            visited = new boolean[10001];
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());

            sb.append(bfs(A,B)).append('\n');
        }

        System.out.println(sb.toString());
    }

    static String bfs(int start, int target){
        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(start, ""));
        visited[start] = true;

        while(!q.isEmpty()){
            //Main class nested..static으로 외부 인스턴스 선언없이 바로 선언이 가능.
            Node cur = q.poll();

            if(cur.num == target) return cur.cmd;

            int d = D(cur.num);
            int s = S(cur.num);
            int l = L(cur.num);
            int r = R(cur.num);

            if(!visited[d]) {
                q.offer(new Node(d, cur.cmd + "D"));
                visited[d] = true;
            }
            if(!visited[s]){
                q.offer(new Node(s, cur.cmd + "S"));
                visited[s] = true;
            }
            if(!visited[l]){
                q.offer(new Node(l, cur.cmd + "L"));
                visited[l] = true;
            }
            if(!visited[r]){
                q.offer(new Node(r, cur.cmd + "R"));
                visited[r] = true;
            }
        }

        return "";
    }

    static int D(int n){
        return (n * 2) % 10000;
    }

    static int S(int n){
        return (n == 0) ? 9999 : n-1;
    }

    static int L(int n){
        //1234 -> 2341
        return (n % 1000) * 10 + (n / 1000);
    }

    static int R(int n){
        //1234 -> 4123
        return (n / 10) + (n % 10) * 1000;
    }
}
