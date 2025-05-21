import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> start) {
        super(start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            for (Edge<T> edge : graph.getEdges(current)) {
                Vertex<T> neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}