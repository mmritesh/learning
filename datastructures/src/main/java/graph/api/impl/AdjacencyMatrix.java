package graph.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjacencyMatrix extends AbstractGraph {

    private int[][] graph;
    private int numberOfVertices;
    private static final int DEFAULT_VALUE = 0;

    public AdjacencyMatrix(int numberOfVertices) {
        this.graph = new int[numberOfVertices][numberOfVertices];
        this.numberOfVertices = numberOfVertices;
    }

    @Override
    public void displayGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
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
            graph[source][dest] = DEFAULT_VALUE;
            graph[dest][source] = DEFAULT_VALUE;
        }
    }

    @Override
    public boolean hasEdge(int source, int dest) {
        return areVerticesValid(source, dest) && graph[source][dest] == 1;
    }

    @Override
    public List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numberOfVertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        result.add(start);
        visited[start] = true;

        int adjacentVertex;

        while (!stack.isEmpty()) {
            adjacentVertex = getAdjacentVertex(stack.peek(), visited);
            if (adjacentVertex != -1) {
                visited[adjacentVertex] = true;
                result.add(adjacentVertex);
                stack.push(adjacentVertex);
            } else {
                stack.pop();
            }
        }

        return result;
    }

    @Override
    public List<Integer> dfsRecursive(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numberOfVertices];
        recurse(start, visited, result);
        return result;
    }

    private void recurse(int vertex, boolean[] visited, List<Integer> result) {
        result.add(vertex);
        visited[vertex] = true;
        for (int i = 0; i < numberOfVertices ; i++) {
            if (graph[vertex][i] != DEFAULT_VALUE && !visited[i]) {
                recurse(i, visited, result);
            }
        }
    }

    private void displayVertex(int index) {
        System.out.print(index + " ");
    }

    private int getAdjacentVertex(Integer vertex, boolean[] visited) {
        for (int i = 0; i < numberOfVertices; i++) {
            if (graph[vertex][i] != DEFAULT_VALUE && !visited[i]) {
                return i;
            }
        }
        return -1;
    }

    private boolean areVerticesValid(int source, int dest) {
        return source > -1 && source < numberOfVertices && dest > -1 && dest < numberOfVertices;
    }


}
