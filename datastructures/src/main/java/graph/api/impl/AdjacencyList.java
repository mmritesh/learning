package graph.api.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AdjacencyList extends AbstractGraph {
    private List<Integer> vertices;
    private List<LinkedList<Integer>> edges;
    private int numberOfVertices;

    public AdjacencyList(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            vertices.add(i);
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            edges.add(list);
        }
    }

    @Override
    public void addEdge(int source, int dest) {
        if (areVerticesValid(source, dest)) {
            edges.get(source).addFirst(dest);
            edges.get(dest).addFirst(source);
        }
    }

    @Override
    public void removeEdge(int source, int dest) {
        if (areVerticesValid(source, dest)) {
            edges.get(source).removeFirstOccurrence(dest);
            edges.get(dest).removeFirstOccurrence(source);
        }
    }

    @Override
    public boolean hasEdge(int source, int dest) {
        return edges.get(source).indexOf(dest) > -1;
    }

    private boolean areVerticesValid(int source, int dest) {
        return source > 0 && source < numberOfVertices && dest > 0 && dest < numberOfVertices;
    }
}
