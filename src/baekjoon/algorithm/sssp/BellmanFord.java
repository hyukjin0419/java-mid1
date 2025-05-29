package baekjoon.algorithm.sssp;

import java.util.*;

class Edge {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class BellmanFord {
    static final int INF = Integer.MAX_VALUE;

    public static void initialization(int[] d, int V, int s) {
        Arrays.fill(d,INF);
        d[s] = 0;
    }

    public static void relax(int [] d, int u, int v, int w) {
        if (d[u] != INF && d[v] > d[u] + w){
            d[v] = d[u] + w;
        }
    }

    public static boolean bellmanFord(int V, List<Edge> edges, int s, int[] d) {
        initialization(d,V,s);

        for (int i=1;i<=V;i++) {
            for (Edge e: edges) {
                relax(d, e.u, e.v, e.w);
            }
        }

        for (Edge e : edges) {
            if(d[e.u] != INF && d[e.v] > d[e.u] + e.w){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        int[] d = new int[V];
        boolean success = bellmanFord(V, edges, 0 , d);

        if (success) {
            System.out.println("최단 거리 결과 (source = 0):");
            for (int i = 0; i < V; i++) {
                System.out.println("0 → " + i + " = " + (d[i] == INF ? "∞" : d[i]));
            }
        } else {
            System.out.println("음수 사이클이 존재합니다.");
        }
    }
}
