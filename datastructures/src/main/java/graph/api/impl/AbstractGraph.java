package graph.api.impl;

import graph.api.Graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph implements Graph {

    @Override
    public List<Integer> dfs(int start) {
        System.out.println("dfs: This feature is not yet supported.");
        return null;
    }

    @Override
    public List<Integer> dfs(int start, int end) {
        System.out.println("dfs: This feature is not yet supported.");
        return null;
    }

    @Override
    public List<Integer> dfsRecursive(int start) {
        System.out.println("dfsRecursive: This feature is not yet supported.");
        return null;
    }

    @Override
    public List<Integer> dfsRecursive(int start, int end) {
        System.out.println("dfsRecursive: This feature is not yet supported.");
        return null;
    }

    @Override
    public void displayGraph() {
        System.out.println("Cannot display graph.");
    }
}
