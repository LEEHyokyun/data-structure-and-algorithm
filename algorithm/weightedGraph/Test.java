package algorithm.weightedGraph;

public class Test {
    public static void main(String[] args) {
        WeightedGraphVertex seoul = new WeightedGraphVertex("Seoul");
        WeightedGraphVertex wonju = new WeightedGraphVertex("Wonju");
        WeightedGraphVertex gangneung = new WeightedGraphVertex("gangneung");
        WeightedGraphVertex daejeon = new WeightedGraphVertex("daejeon");
        WeightedGraphVertex jeonju = new WeightedGraphVertex("jeonju");
        WeightedGraphVertex daegu = new WeightedGraphVertex("daegu");

        seoul.addAdjacency(wonju, 87);
        seoul.addAdjacency(daejeon, 140);
        seoul.addAdjacency(jeonju, 187);

        seoul.getAdjacency().keySet().stream().forEach(item -> System.out.println(item));
    }
}
