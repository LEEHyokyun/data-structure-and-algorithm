package algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Vertex {
    private int data;
    private ArrayList<Vertex> adjacencyList;

    public Vertex(){}

    public Vertex(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    };

    public void setData(int data) {
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
