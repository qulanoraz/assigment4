import java.util.*;

public abstract class Search<T> {
    protected final Vertex<T> start;
    protected final Map<Vertex<T>, Vertex<T>> edgeTo = new HashMap<>();
    protected final Set<Vertex<T>> visited = new HashSet<>();

    public Search(Vertex<T> start) {
        this.start = start;
    }

    public boolean hasPathTo(Vertex<T> goal) {
        return visited.contains(goal);
    }

    public List<Vertex<T>> pathTo(Vertex<T> goal) {
        if (!hasPathTo(goal)) return null;
        List<Vertex<T>> path = new ArrayList<>();
        for (Vertex<T> v = goal; v != null; v = edgeTo.get(v)) {
            path.add(0, v);
        }
        return path;
    }
}