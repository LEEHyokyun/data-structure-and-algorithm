package algorithm.MST.prim;

import java.util.HashMap;

public class Prim {
    private HashMap<String, WeightedGraphCityVertex> allCities;

    public Prim() {
        allCities = new HashMap<>();
    }

    public Prim(HashMap<String, WeightedGraphCityVertex> allCities) {
        this.allCities = allCities;
    }

    public void registerCity(WeightedGraphCityVertex cityVertex){
        this.allCities.put(cityVertex.getName(), cityVertex);
    }

    public void MST(WeightedGraphCityVertex startCityVertex){
        HashMap<String, WeightedGraphCityVertex> visitedCities = new HashMap<>();
        HashMap<String, WeightedGraphCityVertex> unvisitedCities = new HashMap<>();
        HashMap<String, Double> mstTable = new HashMap<>();

        //all cities -> unvisted cities
        for(WeightedGraphCityVertex cityVertex: this.allCities.values()){
            unvisitedCities.put(cityVertex.getName(), cityVertex);
        }

        //table init
        if(unvisitedCities.get(startCityVertex.getName()) == null){
            System.out.println("출발지를 다른 도시로 선택하여 주십시오.");
            return;
        }

        for(WeightedGraphCityVertex cityVertex: unvisitedCities.values()){
            mstTable.put(cityVertex.getName(), Double.POSITIVE_INFINITY);
        }
        mstTable.put(startCityVertex.getName(), 0D);

        //prim
        /*
        * 출발지점에서 인접노드로 도달하는 최단경로가 아닌
        * 인접노드간의 최단거리로 즉시 교체
        * */
        while(!unvisitedCities.isEmpty()){
            WeightedGraphCityVertex currentCityVertex = null;

            /*
            * 다익스트라는 정점을 선택한 순간부터 최초지점부터 해당 정점까지 최단경로를 보장해준다.
            * 반면 MST는 그런 논리적 보장은 없다. 다만 모든 정점의 순회와 모든 단계 완료 시 최소신장트리 구현을 보장한다.
            * */
            for(WeightedGraphCityVertex cityVertex: unvisitedCities.values()){
                if(currentCityVertex == null || mstTable.get(cityVertex.getName()) < mstTable.get(currentCityVertex.getName())){
                    currentCityVertex = cityVertex;
                }
            }

            //다음 방문 도시를 방문도시로 넣고 미방문 도시에서 제거
            visitedCities.put(currentCityVertex.getName(), unvisitedCities.get(currentCityVertex.getName()));
            unvisitedCities.remove(currentCityVertex.getName());

            for(String adjacentCity : visitedCities.get(currentCityVertex.getName()).getAdjacenctCities().keySet()){
                if(unvisitedCities.get(adjacentCity) == null){
                    continue;
                }

                //다익스트라(누적)
                //Double distance = mstTable.get(currentCityVertex.getName()) + visitedCities.get(currentCityVertex.getName()).getAdjacenctCities().get(adjacentCity);
                //프림(교체)
                Double distance = mstTable.get(currentCityVertex.getName());

                if(mstTable.get(adjacentCity) > distance){
                    mstTable.put(adjacentCity, distance);
                }
            }
        }

        System.out.println(mstTable.entrySet());
    }
}
