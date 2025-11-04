package algorithm.dijkstra;

public class Test {
    public static void main(String[] args) {
        WeightedGraphCityVertex seoul = new WeightedGraphCityVertex("seoul");
        WeightedGraphCityVertex wonju = new WeightedGraphCityVertex("wonju");
        WeightedGraphCityVertex gangneung = new WeightedGraphCityVertex("gangneung");
        WeightedGraphCityVertex jeonju = new WeightedGraphCityVertex("jeonju");
        WeightedGraphCityVertex daejeon = new WeightedGraphCityVertex("daejeon");
        WeightedGraphCityVertex daegu = new WeightedGraphCityVertex("daegu");

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.registerCity(seoul);
        dijkstra.registerCity(wonju);
        dijkstra.registerCity(gangneung);
        dijkstra.registerCity(jeonju);
        dijkstra.registerCity(daejeon);
        dijkstra.registerCity(daegu);

        seoul.addAdjacenctCities(wonju, 87D);
        seoul.addAdjacenctCities(gangneung, 165D);
        seoul.addAdjacenctCities(daejeon, 140D);
        seoul.addAdjacenctCities(jeonju, 187D);

        wonju.addAdjacenctCities(seoul, 87D);
        wonju.addAdjacenctCities(gangneung, 95D);
        wonju.addAdjacenctCities(daejeon, 118D);
        wonju.addAdjacenctCities(daegu, 178D);

        gangneung.addAdjacenctCities(seoul, 165D);
        gangneung.addAdjacenctCities(wonju, 95D);
        gangneung.addAdjacenctCities(daegu, 212D);

        daejeon.addAdjacenctCities(seoul, 140D);
        daejeon.addAdjacenctCities(wonju, 118D);
        daejeon.addAdjacenctCities(jeonju, 56D);
        daejeon.addAdjacenctCities(daegu, 122D);

        jeonju.addAdjacenctCities(seoul, 187D);
        jeonju.addAdjacenctCities(daejeon, 56D);
        jeonju.addAdjacenctCities(daegu, 130D);

        daegu.addAdjacenctCities(wonju, 178D);
        daegu.addAdjacenctCities(gangneung, 212D);
        daegu.addAdjacenctCities(daejeon, 122D);
        daegu.addAdjacenctCities(jeonju, 130D);

        dijkstra.Dijkstra(seoul, daegu);

    }
}
