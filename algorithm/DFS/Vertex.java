package algorithm.DFS;

import java.util.ArrayList;

public class Vertex {
    private String data;
    private ArrayList<Vertex> adjacencyList;

    public Vertex(){}

    public Vertex(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    };

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Vertex> getAdjacencyList(){
        return this.adjacencyList;
    }

    public void addAdjacencyList(Vertex neighbor){
        if(adjacencyList == null){
            adjacencyList = new ArrayList<>();
            this.adjacencyList.add(neighbor);
        }else
            adjacencyList.add(neighbor);
    }

    public void removeAdjacencyList(Vertex neighbor){
        this.adjacencyList.remove(neighbor);
    }
}
