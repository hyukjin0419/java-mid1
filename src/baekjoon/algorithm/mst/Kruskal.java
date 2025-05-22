package baekjoon.algorithm.mst;

import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
        //-1 : 현재 객체가 다른 객체보다 작음
        //0: 두 객체가 같음
        //+1 : 현재 객체가 다른 객체보다 큼
    }
}
public class Kruskal {
    static int[] parent;

    public static void main(String[] args) {
        int V = 7;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(2, 3, 7));
        edges.add(new Edge(2, 4, 5));
        edges.add(new Edge(3, 4, 2));
        edges.add(new Edge(4, 5, 4));

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Collections.sort(edges);

        int mstWeight = 0;

        for (Edge edge : edges) {
            if(find(edge.u) != find(edge.v)){
                union(edge.u, edge.v);
                mstWeight = edge.weight;
                System.out.println("Edge added: " + edge.u + " - " + edge.v + " (weight: " + edge.weight + ")");
            }
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB)
            parent[rootB] = rootA;
    }
}
