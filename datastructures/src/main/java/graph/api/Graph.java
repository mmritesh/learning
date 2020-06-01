package graph.api;

public interface Graph {
    void addEdge(int source, int dest);
    void removeEdge(int source, int dest);
    boolean hasEdge(int source, int dest);
}
