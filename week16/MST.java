package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MST {
    static class Edge{
        int u,v,weight;
        Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static int[] parent;

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());

        List<Edge> edges = new ArrayList<>();

        for(int i = 0 ; i < E ; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token2.nextToken());
            int b = Integer.parseInt(token2.nextToken());
            int weight = Integer.parseInt(token2.nextToken());
            edges.add(new Edge(a, b, weight));
        }

        //가중치 오름차순 정렬
        edges.sort((a,b) -> a.weight - b.weight);

        parent = new int[V+1];
        for(int i = 1 ; i <= V ; i++) parent[i] = i;

        int result = 0;
        int count = 0;

        for(Edge e : edges){
            if(find(e.u) != find(e.v)){
                union(e.u, e.v);
                result += e.weight;
                count++;

                if(count == V-1) break;
            }
        }

        System.out.println(result);
    }
}
