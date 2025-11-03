package algorithm.DFS;

import java.util.HashMap;

public class Graph {
    private Vertex vertex;

    public Graph(){}

    public Graph(Vertex vertex){
        this.vertex = vertex;
    }

    public Vertex getVertex(){
        return this.vertex;
    }

    public void setVertex(Vertex vertex){
        this.vertex = vertex;
    }

    //DFS
    public void DFS(Vertex vertex, HashMap visitedVertex){
        if(visitedVertex == null)
            visitedVertex= new HashMap();

        visitedVertex.put(vertex.getData(), true);
        System.out.println(vertex.getData());

        //인접 노드를 대상으로 DFS를 재귀적 호출, 인접노드를 계속 "끝까지" 파고들어 탐색한다는 점
        //key point : 두가지 이상의 인접노드를 동시에 탐색하지 않는다는 점
        for(Vertex adjacency : vertex.getAdjacencyList()){
            if(visitedVertex.containsKey(adjacency.getData()))
                continue;
            else
                DFS(adjacency, visitedVertex);
        }
    }
}
