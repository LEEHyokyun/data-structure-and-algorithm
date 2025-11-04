package algorithm.dijkstra;

import java.util.Hashtable;

public class WeightedGraphCityVertex {
    private String name;
    private Hashtable<String, Double> adjacenctCities;

    public WeightedGraphCityVertex(){}

    public WeightedGraphCityVertex(String name){
        this.name = name;
        this.adjacenctCities = new Hashtable<>();
    }

    public WeightedGraphCityVertex(String name, Hashtable<String, Double> adjacenctCities) {
        this.name = name;
        this.adjacenctCities = adjacenctCities;
    }

    //간선정의
    public void addAdjacenctCities(WeightedGraphCityVertex adjacenctCity, Double weight){
        this.adjacenctCities.put(adjacenctCity.getName(), weight);
    }

    //간선연결제거
    public void removeAdjacenctCities(WeightedGraphCityVertex adjacenctCity){
        this.adjacenctCities.remove(adjacenctCity.getName());
    }

    public String getName(){
        return this.name;
    }

    public void setName(String value){
        this.name = value;
    }

    public Hashtable<String, Double> getAdjacenctCities(){
        return this.adjacenctCities;
    }

}
