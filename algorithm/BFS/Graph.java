package algorithm.BFS;

import java.util.*;

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

    //BFS
    public void BFS1(Vertex vertex){
        Queue<Vertex> queue = new ArrayDeque<>();
        HashMap<String, Boolean> visitedVertex = new HashMap<>();

        visitedVertex.put(vertex.getData(), true);
        queue.offer(vertex);

        while(!queue.isEmpty()){
            //저장된 "인접정점정보"들은 위의 "인접정점"들이 모두 출력되고 난 이후에.
            Vertex currentVertex = queue.poll();
            System.out.println(currentVertex.getData());

            for(Vertex adjacency : currentVertex.getAdjacencyList()){
                if(!visitedVertex.containsKey(adjacency.getData())) {
                    visitedVertex.put(adjacency.getData(), true);
                    queue.offer(adjacency);
                }
            }
        }
    }

    //BFS
    public void BFS2(Vertex vertex){
        Queue<Vertex> queue = new LinkedList<>();
        HashMap<String, Boolean> visitedVertex = new HashMap<>();

        visitedVertex.put(vertex.getData(), true);
        queue.offer(vertex);

        while(!queue.isEmpty()){
            //저장된 "인접정점정보"들은 위의 "인접정점"들이 모두 출력되고 난 이후에.
            Vertex currentVertex = queue.poll();
            System.out.println(currentVertex.getData());

            for(Vertex adjacency : currentVertex.getAdjacencyList()){
                if(visitedVertex.containsKey(adjacency.getData()))
                    continue;
                else {
                    //인접정점들을 모두 저장
                    visitedVertex.put(adjacency.getData(), true);
                    queue.offer(adjacency);
                }
            }
        }
    }
}
