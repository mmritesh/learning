package graph.api.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyMapPractice extends AbstractGraph {

    private Map<Integer, Node> graph = new HashMap<>();

    private static class Node {
        int id;
        LinkedList<Node> adjacencyList = new LinkedList<>();

        public Node(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return id == node.id;
        }
    }

    private Node getNode(int id) {
        Node node = graph.get(id);
        if (node != null) {
            return node;
        }
        node = new Node(id);
        graph.put(id, node);
        return node;
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

    @Override
    public List<Integer> dfsRecursive(int start, int end) {
        Node s = getNode(start);
        Node e = getNode(end);
        List<Integer> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        recurse(s, e, result, visited);
        return result;
    }

    private void recurse(Node s, Node e, List<Integer> result, Set<Node> visited) {
        if (visited.contains(s)) {
            return;
        }
        visited.add(s);
        result.add(s.id);
        if (s.equals(e)) {
            return;
        }
        s.adjacencyList.forEach(node -> {
            recurse(node, e, result, visited);
        });
        result.remove(s.id);
    }

}
