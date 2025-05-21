public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 2);
        graph.addEdge(b, c, 5);
        graph.addEdge(b, d, 10);
        graph.addEdge(c, e, 3);
        graph.addEdge(e, d, 4);

        System.out.println("----- BFS -----");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, a);
        for (Vertex<String> v : graph.getVertices()) {
            System.out.println("Path to " + v + ": " + bfs.pathTo(v));
        }

        System.out.println("\n----- Dijkstra -----");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, a);
        for (Vertex<String> v : graph.getVertices()) {
            System.out.println("Shortest path to " + v + ": " + dijkstra.pathTo(v) +
                    ", Distance: " + dijkstra.distanceTo(v));
        }
    }
}