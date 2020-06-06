package graph;

import graph.api.Graph;
import graph.api.impl.AdjacencyMap;
import graph.api.impl.AdjacencyMapPractice;
import graph.api.impl.AdjacencyMatrix;

public class Main {

    public static void main(String[] args) {
        System.out.println("*** Adjacency Matrix ***");
        Graph graph = new AdjacencyMatrix(8);
        graph = addEdges(graph);
        graph.displayGraph();
        System.out.println("DFS Iterative: " + graph.dfs(0));
        System.out.println("DFS Recursive: " + graph.dfsRecursive(0));

        System.out.println("*** Adjacency Map ***");
        Graph graphMap = new AdjacencyMapPractice();
        graphMap = addEdges(graphMap);
        System.out.println("DFS Recursive: " + graphMap.dfsRecursive(0, 5));

    }

    private static Graph addEdges(Graph graph) {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        return graph;
    }
}
