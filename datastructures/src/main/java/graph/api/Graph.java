package graph.api;

import java.util.List;

public interface Graph {
    void addEdge(int source, int dest);
    void removeEdge(int source, int dest);
    boolean hasEdge(int source, int dest);
    List<Integer> dfs(int start);
    List<Integer> dfsRecursive(int start);
    List<Integer> dfs(int start, int end);
    List<Integer> dfsRecursive(int start, int end);
    List<Integer> bfs(int start);
    void displayGraph();
}
