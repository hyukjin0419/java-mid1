//package baekjoon.algorithm.mst;
//
//
//import java.util.*;
//class E implements Comparable<E> {
//    int u, v, weight;
//
//    public E(int u, int v, int weight) {
//        this.u = u;
//        this.v = v;
//        this.weight = weight;
//    }
//
//    @Override
//    public int compareTo(E other) {
//        return this.weight - other.weight;
//        //-1 : 현재 객체가 다른 객체보다 작음 -> this가 앞에
//        //0: 두 객체가 같음 -> 순서 유지
//        //+1 : 현재 객체가 다른 객체보다 큼 -> this가 뒤에
//    }
//}
//public class Kruskal {
//    static int[] parent;
//
//    public static void main(String[] args) {
//        int V = 5;
//        List<E> edges = new ArrayList<>();
//
//        edges.add(new E(1, 2, 3));
//        edges.add(new E(1, 3, 1));
//        edges.add(new E(2, 3, 7));
//        edges.add(new E(2, 4, 5));
//        edges.add(new E(3, 4, 2));
//        edges.add(new E(4, 5, 4));
//        parent = new int[V+1];
//        for (int i = 1; i <= V; i++) {
//            parent[i] = i;
//        }
//
//        Collections.sort(edges);
//
//        int mstWeight = 0;
//
//        for (E edge : edges) {
//            if(find(edge.u) != find(edge.v)){
//                union(edge.u, edge.v);
//                mstWeight += edge.weight;
//                System.out.println("Edge added: " + edge.u + " - " + edge.v + " (weight: " + edge.weight + ")");
//            }
//        }
//        System.out.println("Total weight of MST: " + mstWeight);
//    }
//
//    static int find(int x) {
//        if (parent[x] != x)
//            parent[x] = find(parent[x]);
//        return parent[x];
//    }
//
//    static void union(int a, int b) {
//        int rootA = find(a);
//        int rootB = find(b);
//        if (rootA != rootB)
//            parent[rootB] = rootA;
//    }
//}
