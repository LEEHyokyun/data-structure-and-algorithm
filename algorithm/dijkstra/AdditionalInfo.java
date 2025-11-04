package algorithm.dijkstra;

import java.util.LinkedList;

public class AdditionalInfo {
    private Double distance;
    private LinkedList<String> pathInfo;

    public AdditionalInfo(Double distance) {
        this.distance = distance;
        this.pathInfo = new LinkedList<>();
    }


    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setPathInfo(String city){
        this.pathInfo.add(city);
    }
}
