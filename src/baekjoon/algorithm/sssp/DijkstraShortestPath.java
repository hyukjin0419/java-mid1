package baekjoon.algorithm.sssp;

import java.util.*;

public class DijkstraShortestPath {
    static class Edge{
        int v, w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        int u,d;
        Node(int u, int d) {
            this.u = u;
            this.d= d;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.d, other.d);
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int V, List<List<Edge>> Adj, int s, int[] d) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Node> Q = new PriorityQueue<>();

        Arrays.fill(d, INF);
        d[s] = 0;
        Q.add(new Node(s, 0));

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            int u = cur.u;
            if (visited[u]) continue;
            visited[u] = true;

            for (Edge edge : Adj.get(u)) {
                int v = edge.v;
                int w = edge.w;
                relax(u,v,w,d,Q);
            }
        }
    }

    private static void relax (int u, int v, int w, int[] d, PriorityQueue<Node> Q) {
        if (d[u] != INF & d[v] > d[u] + w) {
            d[v] = d[u] + w;
            Q.add(new Node(v, d[v]));
        }
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> Adj = new ArrayList<>();
        for (int i = 0; i < V; i++) Adj.add(new ArrayList<>());

        Adj.get(0).add(new Edge(1, 4));
        Adj.get(0).add(new Edge(2, 1));
        Adj.get(2).add(new Edge(1, 2));
        Adj.get(1).add(new Edge(3, 1));
        Adj.get(2).add(new Edge(3, 5));
        Adj.get(3).add(new Edge(4, 3));
        Adj.get(4).add(new Edge(5, 1));

        int[] d = new int[V];
        int s = 0;

        dijkstra(V, Adj, s, d);

        System.out.println("최단 거리 결과 (source = " + s + "):");
        for (int v = 0; v < V; v++) {
            System.out.println(s + " → " + v + " = " + (d[v] == INF ? "∞" : d[v]));
        }
    }
}
