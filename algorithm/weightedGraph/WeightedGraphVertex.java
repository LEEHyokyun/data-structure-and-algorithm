package algorithm.weightedGraph;

import algorithm.BFS.Vertex;

import java.util.Hashtable;

public class WeightedGraphVertex {
    private String value;
    private Hashtable<String, Integer> adjacency;

    public WeightedGraphVertex(){}

    public WeightedGraphVertex(String value){
        this.value = value;
        this.adjacency = new Hashtable<>();
    }

    public WeightedGraphVertex(String value, Hashtable<String, Integer> adjacency) {
        this.value = value;
        this.adjacency = adjacency;
    }

    //간선정의
    public void addAdjacency(WeightedGraphVertex adjacency, int weight){
        this.adjacency.put(adjacency.getValue(), weight);
    }

    //간선연결제거
    public void removeAdjacency(WeightedGraphVertex adjacency){
        this.adjacency.remove(adjacency.getValue());
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public Hashtable<String, Integer> getAdjacency(){
        return this.adjacency;
    }

}
