package algorithm.maximumFlow;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
    private String cityName;
    private HashMap<City, FlowAndCapacity> adjacentCityList;

    public City(String cityName) {
        this.cityName = cityName;
        this.adjacentCityList = new HashMap<>();
    }

    public void removeAdjacentCity(String cityName) {
        adjacentCityList.remove(cityName);
    }

    //initial
    public void addAdjacentCities(City adjacentCity) {
        FlowAndCapacity initialFlowAndCapacity = new FlowAndCapacity(0, 0);
        this.adjacentCityList.put(adjacentCity, initialFlowAndCapacity);
    }

    //additional
    public void addAdjacentCities(City adjacentCity, FlowAndCapacity flowAndCapacity) {
        this.adjacentCityList.put(adjacentCity, flowAndCapacity);
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public HashMap<City, FlowAndCapacity> getAdjacentCityList() {
        return this.adjacentCityList;
    }
}
