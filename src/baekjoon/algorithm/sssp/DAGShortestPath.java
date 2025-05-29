package baekjoon.algorithm.sssp;

import java.util.*;

public class DAGShortestPath {
    static class Edge {
        int v, w;

        Edge (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void ssspDag(int V, List<List<Edge>> E, int s, int [] d) {
        Stack<Integer> topoOrder = topologicalSort(V,E);
        initialization(d, V, s);
        relaxAll(topoOrder, d, E);
    }

    private static void initialization(int[] d, int V, int s) {
        Arrays.fill(d,INF);
        d[s] = 0;
    }

    private static Stack<Integer> topologicalSort(int V, List<List<Edge>> E) {
        boolean[] visited = new boolean[V];
        Stack<Integer> topoStack = new Stack<>();
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                dfsTopoSort(u, visited, E, topoStack);
            }
        }
        return topoStack;
    }

    private static void dfsTopoSort(int u, boolean[] visited, List<List<Edge>> E, Stack<Integer> stack) {
        visited[u] = true;
        for (Edge edge: E.get(u)) {
            if (!visited[edge.v]) {
                dfsTopoSort(edge.v, visited, E, stack);
            }
        }
        stack.push(u);
    }

    private static void relaxation(int[] d, int u, int v, int w) {
        if (d[u] != INF && d[v] > d[u] + w){
            d[v] = d[u] + w;
        }
    }

    private static void relaxAll(Stack<Integer> topoStack, int[] d, List<List<Edge>> E) {
        while (!topoStack.isEmpty()) {
            int u = topoStack.pop();
            if (d[u] != INF) {
                for (Edge edge : E.get(u)) {
                    relaxation(d,u,edge.v,edge.w);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> E = new ArrayList<>();
        for (int i = 0; i < V; i++) E.add(new ArrayList<>());

        E.get(0).add(new Edge(1, 5));
        E.get(0).add(new Edge(2, 3));
        E.get(1).add(new Edge(3, 6));
        E.get(1).add(new Edge(2, 2));
        E.get(2).add(new Edge(4, 4));
        E.get(2).add(new Edge(5, 2));
        E.get(2).add(new Edge(3, 7));
        E.get(3).add(new Edge(4, -1));
        E.get(4).add(new Edge(5, -2));

        int[] d = new int[V];
        int s = 1;
        ssspDag(V,E,s,d);

        System.out.println("최단 거리 결과 (source = " + s + "):");
        for (int v = 0; v < V; v++) {
            System.out.println(s + " → " + v + " = " + (d[v] == INF ? "∞" : d[v]));
        }
    }
}
