package algorithm.graph;

public class Test {
    public static void main(String[] args) {
        Vertex jake = new Vertex(1);
        Vertex ben = new Vertex(2);
        Vertex joy = new Vertex(3);
        Vertex elin = new Vertex(4);

        jake.addAdjacencyList(ben);
        ben.addAdjacencyList(jake);
        joy.addAdjacencyList(elin);

        jake.getAdjacencyList().stream().forEach(item -> System.out.println(item.getData()));
    }
}
