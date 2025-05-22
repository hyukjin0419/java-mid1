package baekjoon.algorithm.mst;

import java.util.*;

class Edge implements Comparable<Edge> {
    char u, v;
    int weight;

    public Edge(char u, char v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class UnionFind {
    private Map<Character, Character> parent = new HashMap<>();

    public void makeSet(char[] vertices) {
        for (char v : vertices) {
            parent.put(v, v);
        }
    }

    public char find(char x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(char a, char b) {
        char rootA = find(a);
        char rootB = find(b);
        if (rootA != rootB) {
            parent.put(rootB, rootA);
        }
    }

    public boolean connected(char a, char b) {
        return find(a) == find(b);
    }
}

public class KruskalMST {
    public static void main(String[] args) {
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        List<Edge> edges = Arrays.asList(
                new Edge('A', 'B', 4),
                new Edge('A', 'H', 6),
                new Edge('B', 'H', 5),
                new Edge('B', 'C', 9),
                new Edge('B', 'E', 2),
                new Edge('C', 'D', 15),
                new Edge('E', 'D', 15),
                new Edge('E', 'F', 8),
                new Edge('F', 'G', 3),
                new Edge('G', 'H', 14),
                new Edge('H', 'F', 10)
        );

        Collections.sort(edges);

        UnionFind uf = new UnionFind();
        uf.makeSet(vertices);

        int mstWeight = 0;
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (!uf.connected(edge.u, edge.v)) {
                uf.union(edge.u, edge.v);
                mst.add(edge);
                mstWeight += edge.weight;
                System.out.println("Edge added: " + edge.u + " - " + edge.v + " (" + edge.weight + ")");
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
    }
}

