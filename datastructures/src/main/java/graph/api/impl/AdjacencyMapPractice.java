package graph.api.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AdjacencyMapPractice extends AbstractGraph {

    private Map<Integer, Node> graph = new HashMap<>();

    private static class Node {
        int id;
        LinkedList<Node> adjacencyList = new LinkedList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return id == node.id;
        }
    }

    private Node getNode(int id) {
        return graph.get(id);
    }

    @Override
    public void addEdge(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);
        s.adjacencyList.add(d);
    }

    @Override
    public void removeEdge(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);

        s.adjacencyList.removeFirstOccurrence(d);
    }

    @Override
    public boolean hasEdge(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);
        return s.adjacencyList.indexOf(d) > -1;
    }

}
