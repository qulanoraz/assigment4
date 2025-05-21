import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Double> distance = new HashMap<>();

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> start) {
        super(start);
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph<T> graph, Vertex<T> start) {
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        distance.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            visited.add(current);

            for (Edge<T> edge : graph.getEdges(current)) {
                Vertex<T> neighbor = edge.getDestination();
                double newDist = distance.get(current) + edge.getWeight();
                if (!distance.containsKey(neighbor) || newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    queue.remove(neighbor); // remove if exists
                    queue.add(neighbor);
                }
            }
        }
    }

    public double distanceTo(Vertex<T> vertex) {
        return distance.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }
}