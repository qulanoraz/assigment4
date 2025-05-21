import java.util.*;

public class WeightedGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjacencyList = new HashMap<>();

    public void addVertex(Vertex<T> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(new Edge<>(source, destination, weight));
    }

    public List<Edge<T>> getEdges(Vertex<T> vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<Vertex<T>> getVertices() {
        return adjacencyList.keySet();
    }
}