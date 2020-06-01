package graph.api.impl;

import graph.api.Graph;

public class AdjacencyMatrix implements Graph {

    private int[][] graph;
    private int numberOfVertices;

    public AdjacencyMatrix(int numberOfVertices) {
        this.graph = new int[numberOfVertices][numberOfVertices];
        this.numberOfVertices = numberOfVertices;
    }

    @Override
    public void addEdge(int source, int dest) {
        if (areVerticesValid(source, dest)) {
            graph[source][dest] = 1;
            graph[dest][source] = 1;
        }
    }

    @Override
    public void removeEdge(int source, int dest) {
        if (areVerticesValid(source, dest)) {
            graph[source][dest] = 0;
            graph[dest][source] = 0;
        }
    }

    @Override
    public boolean hasEdge(int source, int dest) {
        return areVerticesValid(source, dest) && graph[source][dest] == 1;
    }

    private boolean areVerticesValid(int source, int dest) {
        return source > 0 && source < numberOfVertices && dest > 0 && dest < numberOfVertices;
    }


}
