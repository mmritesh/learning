package graph.api.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class AdjacencyMap extends AbstractGraph {

    public Map<Integer, Node> graph = new HashMap<Integer, Node>();

    public static class Node {
        int id;
        LinkedList<Node> adjacencyList = new LinkedList<Node>();
        Node(int id) {
            this.id = id;
        }
    }

    public Node getNode(int id) {
        return graph.get(id);
    }

    @Override
    public void addEdge(int src, int dest) {
        Node s = getNode(src);
        Node d = getNode(dest);
        s.adjacencyList.add(d);
    }

    @Override
    public void removeEdge(int source, int dest) {

    }

    @Override
    public boolean hasEdge(int source, int dest) {
        return false;
    }

    public boolean hasPathDfs(int src, int dest) {
        Node s = getNode(src);
        Node d = getNode(dest);
        Set<Integer> visited = new HashSet<Integer>();
        return hasPathDfs(s, d, visited);
    }

    private boolean hasPathDfs(Node s, Node d, Set<Integer> visited) {
        if (visited.contains(s.id)) {
            return false;
        }
        visited.add(s.id);
        if (s == d) {
            return true;
        }
        for (Node node: s.adjacencyList) {
            if (hasPathDfs(node, d, visited)){
                return true;
            }
        }
        return false;
    }

}
