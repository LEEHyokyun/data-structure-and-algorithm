package algorithm.dijkstra;

import java.util.HashMap;

public class Dijkstra {
    private HashMap<String, WeightedGraphCityVertex> allCities;

    public Dijkstra() {
        allCities = new HashMap<>();
    }

    public Dijkstra(HashMap<String, WeightedGraphCityVertex> allCities) {
        this.allCities = allCities;
    }

    public void registerCity(WeightedGraphCityVertex cityVertex){
        this.allCities.put(cityVertex.getName(), cityVertex);
    }

    public void Dijkstra(WeightedGraphCityVertex startCityVertex, WeightedGraphCityVertex endCityVertex){
        HashMap<String, WeightedGraphCityVertex> visitedCities = new HashMap<>();
        HashMap<String, WeightedGraphCityVertex> unvisitedCities = new HashMap<>();
        HashMap<String, Double> dijkstraTable = new HashMap<>();

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
            dijkstraTable.put(cityVertex.getName(), Double.POSITIVE_INFINITY);
        }
        dijkstraTable.put(startCityVertex.getName(), 0D);

        //dijkstra
        /*
        * 최초 반복문에서 이미 최초 시작점의 정점의 인접노드들로 테이블을 갱신해주었으므로, 다음 순회도 그 인접노드에 대해 반복하고,
        * 인접노드에 대해 방문하지 않아도 이미 그 노드에 방문하기 전까지의 경로가 모두 누적갱신된 상태.
        * */
        while(!unvisitedCities.isEmpty()){
            //최초 상태를 정의하며, 이 이후에 그 상태가 항상 누적된다(*객체비교).
            WeightedGraphCityVertex currentCityVertex = null;

            /*
            * 최초 상태는 null
            * for 반복순회를 하면서 미방문 도시들 중, 가장 가중치가 작은 정점을 선택하여 다익스트라 테이블을 갱신한다.
            * */
            for(WeightedGraphCityVertex cityVertex: unvisitedCities.values()){
                if(currentCityVertex == null || dijkstraTable.get(cityVertex.getName()) < dijkstraTable.get(currentCityVertex.getName())){
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

                Double distance = dijkstraTable.get(currentCityVertex.getName()) + visitedCities.get(currentCityVertex.getName()).getAdjacenctCities().get(adjacentCity);

                if(dijkstraTable.get(adjacentCity) > distance){
                    dijkstraTable.put(adjacentCity, distance);
                }
            }
        }

        System.out.println(dijkstraTable.entrySet());
    }
}
