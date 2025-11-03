package algorithm.DFS;

public class Test {
    public static void main(String[] args) {
        Vertex Ben = new Vertex("Ben");
        Vertex Ivy = new Vertex("Ivy");
        Vertex Joy = new Vertex("Joy");
        Vertex Jake = new Vertex("Jake");
        Vertex Anna = new Vertex("Anna");
        Vertex David = new Vertex("David");
        Vertex Elin = new Vertex("Elin");
        Vertex Owen = new Vertex("Owen");

        Ben.addAdjacencyList(Ivy);
        Ben.addAdjacencyList(Jake);
        Ben.addAdjacencyList(Anna);
        Ben.addAdjacencyList(David);

        Ivy.addAdjacencyList(Ben);
        Ivy.addAdjacencyList(Joy);

        Ivy.addAdjacencyList(Jake);
        Jake.addAdjacencyList(Ivy);

        Joy.addAdjacencyList(Ivy);
        Joy.addAdjacencyList(Jake);

        Jake.addAdjacencyList(Ben);
        Jake.addAdjacencyList(Joy);

        Anna.addAdjacencyList(Ben);

        David.addAdjacencyList(Ben);
        David.addAdjacencyList(Elin);

        Elin.addAdjacencyList(David);
        Elin.addAdjacencyList(Owen);

        Owen.addAdjacencyList(Elin);

        Graph graph = new Graph();
        graph.DFS(Ben, null);
    }
}
