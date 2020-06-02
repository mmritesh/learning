package graph;

import graph.api.Graph;
import graph.api.impl.AdjacencyMatrix;

public class Main {

    public static void main(String[] args) {
        System.out.println("*** Adjacency Matrix ***");
        Graph graph = new AdjacencyMatrix(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.displayGraph();
        System.out.println("DFS Iterative: " + graph.dfs(0));
        System.out.println("DFS Recursive: " + graph.dfsRecursive(0));
    }
}
