package algorithm.maximumFlow;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//ford fulkerson
public class MaxFlow {
    private HashMap<String, City> allCities;
    private Stack<City> stack;

    public MaxFlow(){
        this.allCities = new HashMap<>();
        this.stack = new Stack<>();
    }

    public void registerCity(City city){
        this.allCities.put(city.getCityName(), city);
    }

    /*
    * ford-fulkerson
    * DFS로 탐색 후 유량 흘러보내기
    * 증가경로를 찾아 최대 유량 흘러보내기
    * 더이상 유량을 흐르지 못하는 상태까지 반복
    */
    public void fordFulkerson(City source, City sink){
        int maxFlow = 0;

        //logically weird point 1
        while(this.DFS(source, sink, null)){
            this.stack.push(sink);
            int currentPathFlow = 999;

            for(int i = 0; i < this.stack.size() - 1; i++){
                City currentCity = this.stack.get(i);
                City nextCity = this.stack.get(i+1);
                FlowAndCapacity edge = currentCity.getAdjacentCityList().get(nextCity);
                currentPathFlow = Math.min(currentPathFlow, edge.getCapacity() - edge.getFlow());
            }

            //logically weird point 2
            for(int i = 0; i < this.stack.size() - 1; i++){
                City currentCity = this.stack.get(i);
                City nextCity = this.stack.get(i+1);
                int flowFromCurrentToNextCity = currentCity.getAdjacentCityList().get(nextCity).getFlow();
                int flowFromNextToCurrentCity = nextCity.getAdjacentCityList().get(currentCity).getFlow();

                //flow
                currentCity.getAdjacentCityList().get(nextCity).setFlow(flowFromCurrentToNextCity + currentPathFlow);


            }

            maxFlow = maxFlow + currentPathFlow;
            this.stack.clear();
        }

        System.out.println("*****최대유량을 도출하였습니다.******");
        System.out.println(maxFlow);
    }

    //logically weird point 4(전체)
    public boolean DFS(City source, City sink, HashMap<String, City> visitedCities) {
        if(visitedCities == null)
            visitedCities = new HashMap<>();

        if (source.getCityName().equals(sink.getCityName())) {
            return true;
        }

        visitedCities.put(source.getCityName(), source);

        for(Map.Entry<City, FlowAndCapacity> adjacentCity : source.getAdjacentCityList().entrySet()){
            City city = adjacentCity.getKey();
            FlowAndCapacity flowAndCapacity = adjacentCity.getValue();

            if(visitedCities.containsKey(city.getCityName())){
                continue;
                //logically weird point 3
            }else if(flowAndCapacity.getCapacity() - flowAndCapacity.getFlow() > 0){
                stack.push(city);

                if(this.DFS(adjacentCity.getKey(), sink, visitedCities)){
                    return true;
                }else{
                    stack.pop();
                }
            }
        }

        return false;
    }

}
