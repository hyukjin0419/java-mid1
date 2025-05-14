package baekjoon.algorithm.dfs;

import java.util.*;

public class TopologicalSort {
    private int V;
    private List<List<Integer>> graph;
    private boolean[] visited;
    private Stack<Integer> finishStack;

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort(6);

        ts.addEdge(5, 2);
        ts.addEdge(5, 0);
        ts.addEdge(4, 0);
        ts.addEdge(4, 1);
        ts.addEdge(2, 3);
        ts.addEdge(3, 1);

        List<Integer> sorted = ts.topologicalSort();

        System.out.println("순 방향 그래프");
        for (int i = 0; i < ts.V; i++) {
            System.out.print(i + " -> ");
            for (int neighbors : ts.graph.get(i)) {
                System.out.print(neighbors + " ");
            }
            System.out.println();
        }

        System.out.println("Topological Sort:" + sorted);
    }

    public TopologicalSort(int V) {
        this.V = V;
        graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[V];
        finishStack = new Stack<>();
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
    }

    public void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        finishStack.push(node);
    }

    public List<Integer> topologicalSort() {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!finishStack.isEmpty()) {
            result.add(finishStack.pop());
        }
        return result;
    }
}
