package algorithm.graph;

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
}
